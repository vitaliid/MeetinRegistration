package com.sdarm.meetingregistration.dto.bed;


import com.sdarm.meetingregistration.dto.participant.ParticipantResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BedResponse {

    private String id;

    private String number;

    private int level;

    private ParticipantResponse participant;
}
