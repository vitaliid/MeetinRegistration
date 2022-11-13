package com.sdarm.meetingregistration.dto.participant;


import com.sdarm.meetingregistration.dto.address.AddressResponse;
import com.sdarm.meetingregistration.dto.payment.PaymentResponse;
import com.sdarm.meetingregistration.enums.ParticipantGender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ParticipantResponse {

    private String id;

    private String name;

    private String email;

    private ParticipantGender gender;

    private String minister;

    private PaymentResponse payment;

    private AddressResponse address;
}
