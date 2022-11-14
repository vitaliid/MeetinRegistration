package com.sdarm.meetingregistration.dto.participant;

import com.sdarm.meetingregistration.enums.ParticipantGender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParticipantAbstractRequest {

    private String name;

    private String email;

    private ParticipantGender gender;

    private String minister;

    private String bedId;

    private int booking;
}

