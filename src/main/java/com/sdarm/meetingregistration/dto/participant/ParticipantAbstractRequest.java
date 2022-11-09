package com.sdarm.meetingregistration.dto.participant;

import com.sdarm.meetingregistration.enums.UserGender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParticipantAbstractRequest {

    private String name;

    private String email;

    private UserGender gender;

    private String minister;
}

