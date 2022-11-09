package com.sdarm.meetingregistration.facade;

import com.sdarm.meetingregistration.domain.Address;
import com.sdarm.meetingregistration.domain.Field;
import com.sdarm.meetingregistration.domain.Participant;
import com.sdarm.meetingregistration.domain.Payment;
import com.sdarm.meetingregistration.dto.participant.ParticipantCreateRequest;
import com.sdarm.meetingregistration.dto.participant.ParticipantResponse;
import com.sdarm.meetingregistration.dto.participant.ParticipantUpdateRequest;
import com.sdarm.meetingregistration.mapper.ParticipantMapper;
import com.sdarm.meetingregistration.service.AddressService;
import com.sdarm.meetingregistration.service.FieldService;
import com.sdarm.meetingregistration.service.ParticipantService;
import com.sdarm.meetingregistration.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipantFacade {

    private final ParticipantService participantService;
    private final ParticipantMapper participantMapper;
    private final FieldService fieldService;
    private final AddressService addressService;
    private final PaymentService paymentService;

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
        return participantMapper.toDto(created);
    }

    public ParticipantResponse update(ParticipantUpdateRequest request) {
        Participant participant = participantMapper.toEntity(request);

        //TODO finalize

        Participant created = participantService.update(participant);
        return participantMapper.toDto(created);
    }

    public void delete(String id) {
        participantService.delete(id);
    }
}
