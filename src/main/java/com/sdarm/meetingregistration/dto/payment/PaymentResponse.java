package com.sdarm.meetingregistration.dto.payment;


import com.sdarm.meetingregistration.enums.PaymentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PaymentResponse {

    private String id;

    private PaymentType type;
}
