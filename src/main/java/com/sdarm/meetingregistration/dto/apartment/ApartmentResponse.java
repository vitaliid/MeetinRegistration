package com.sdarm.meetingregistration.dto.apartment;


import com.sdarm.meetingregistration.dto.bed.BedResponse;
import com.sdarm.meetingregistration.enums.ParticipantGender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ApartmentResponse {

    private String id;

    private String number;

    private ParticipantGender gender;

    private List<BedResponse> beds = new ArrayList<>();
}
