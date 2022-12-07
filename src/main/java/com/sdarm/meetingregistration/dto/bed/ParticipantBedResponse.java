package com.sdarm.meetingregistration.dto.bed;


import com.sdarm.meetingregistration.dto.apartment.ApartmentBedResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ParticipantBedResponse {

    private String id;

    private String number;

    private int level;

    private int booking;

    private ApartmentBedResponse apartment;
}
