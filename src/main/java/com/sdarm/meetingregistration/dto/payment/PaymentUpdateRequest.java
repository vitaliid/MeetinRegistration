package com.sdarm.meetingregistration.dto.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PaymentUpdateRequest extends PaymentAbstractRequest {

    private String id;
}
