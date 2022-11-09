package com.sdarm.meetingregistration.dto.participant;

import com.sdarm.meetingregistration.dto.address.AddressUpdateRequest;
import com.sdarm.meetingregistration.dto.payment.PaymentUpdateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ParticipantUpdateRequest extends ParticipantAbstractRequest {

    private String id;

    private AddressUpdateRequest address;

    private PaymentUpdateRequest payment;
}
