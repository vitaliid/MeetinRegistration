package com.sdarm.meetingregistration.facade;

import com.sdarm.meetingregistration.domain.*;
import com.sdarm.meetingregistration.dto.participant.ParticipantCreateRequest;
import com.sdarm.meetingregistration.dto.participant.ParticipantResponse;
import com.sdarm.meetingregistration.mapper.ParticipantMapper;
import com.sdarm.meetingregistration.service.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipantFacade {

    private final ParticipantService participantService;
    private final ParticipantMapper participantMapper;
    private final FieldService fieldService;
    private final AddressService addressService;
    private final PaymentService paymentService;
    private final BedService bedService;

    @PersistenceContext
    private EntityManager entityManager;

    public List<ParticipantResponse> getAll() {
        return participantService.getAll().stream()
                .map(participantMapper::toDto)
                .collect(Collectors.toList());
    }

    public ParticipantResponse getById(String id) {
        return participantService.getById(id)
                .map(participantMapper::toDto)
                .orElse(null);
    }

    @Transactional
    public ParticipantResponse create(ParticipantCreateRequest request) {
        Participant participant = participantMapper.toEntity(request);

        //handle address
        Address address = participant.getAddress();
        Field field = fieldService.getById(request.getAddress().getFieldId()).orElse(null);
        participant.getAddress().setField(field);
        addressService.create(address);
        participant.setAddress(address);

        //handle payment
        Payment payment = participant.getPayment();
        paymentService.create(payment);
        participant.setPayment(payment);

        Participant created = participantService.create(participant);

        try {
            if (StringUtils.isNotBlank(request.getBedId())) {
                Bed bed = bedService.getById(request.getBedId())
                        .orElseThrow(() -> new NoSuchElementException("There is no bed with such id: " + request.getBedId()));

                if (bed.getParticipant() != null) {
                    throw new ObjectOptimisticLockingFailureException("Specified bed is already booked by: " + bed.getParticipant().getId(), null);
                }

                entityManager.detach(bed);

                bed.setBooking(request.getBooking());
                bed.setParticipant(created);
                bedService.update(bed);

                participant.setBed(bed);
            }
        } catch (ObjectOptimisticLockingFailureException e) {
            throw new IllegalArgumentException("It was not possible to book the apartment. Please update information and choose another one.", e);
        }

        return participantMapper.toDto(created);
    }

    @Transactional
    public void delete(String id) {
        bedService.getByParticipant(id).ifPresent(bed -> {
            bed.setParticipant(null);
            bedService.update(bed);
        });

        participantService.delete(id);
    }
}
