package com.sdarm.meetingregistration.facade;

import com.sdarm.meetingregistration.domain.*;
import com.sdarm.meetingregistration.dto.participant.ParticipantCreateRequest;
import com.sdarm.meetingregistration.dto.participant.ParticipantResponse;
import com.sdarm.meetingregistration.mapper.ParticipantMapper;
import com.sdarm.meetingregistration.service.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        if (StringUtils.isNotBlank(request.getBedId())) {
            Bed bed = bedService.getById(request.getBedId())
                    .orElseThrow(() -> new NoSuchElementException("There is no bed with such id: " + request.getBedId()));

            participant.setBed(bed);
            bed.setParticipant(participant);

            bedService.update(bed);
        }

        Participant created = participantService.create(participant);
        return participantMapper.toDto(created);
    }

    public void delete(String id) {
        participantService.delete(id);
    }
}
