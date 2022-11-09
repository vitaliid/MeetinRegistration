package com.sdarm.meetingregistration.dto.participant;

import com.sdarm.meetingregistration.dto.address.AddressCreateRequest;
import com.sdarm.meetingregistration.dto.payment.PaymentCreateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ParticipantCreateRequest extends ParticipantAbstractRequest {

    private AddressCreateRequest address;

    private PaymentCreateRequest payment;
}
