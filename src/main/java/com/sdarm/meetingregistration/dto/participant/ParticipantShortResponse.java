package com.sdarm.meetingregistration.dto.participant;


import com.sdarm.meetingregistration.enums.ParticipantGender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ParticipantShortResponse {

    private String id;

    private String name;

    private String email;

    private ParticipantGender gender;

    private String minister;
}
