package com.sdarm.meetingregistration.dto.bed;


import com.sdarm.meetingregistration.dto.participant.ParticipantShortResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class BedResponse {

    private String id;

    private String number;

    private int level;

    private LocalDateTime bookingTime;

    private ParticipantShortResponse participant;
}
