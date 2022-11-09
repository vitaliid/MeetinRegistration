package com.sdarm.meetingregistration.dto.payment;

import com.sdarm.meetingregistration.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PaymentAbstractRequest {

    private PaymentType type;
}

