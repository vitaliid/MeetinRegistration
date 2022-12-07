package com.sdarm.meetingregistration.dto.apartment;


import com.sdarm.meetingregistration.enums.ParticipantGender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApartmentBedResponse {

    private String id;

    private String number;

    private ParticipantGender gender;
}
