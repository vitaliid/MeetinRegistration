package com.sdarm.meetingregistration.mapper;

import com.sdarm.meetingregistration.domain.Participant;
import com.sdarm.meetingregistration.dto.participant.ParticipantCreateRequest;
import com.sdarm.meetingregistration.dto.participant.ParticipantResponse;
import com.sdarm.meetingregistration.dto.participant.ParticipantUpdateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {

    ParticipantResponse toDto(Participant domain);

    Participant toEntity(ParticipantCreateRequest request);

    Participant toEntity(ParticipantUpdateRequest request);
}
