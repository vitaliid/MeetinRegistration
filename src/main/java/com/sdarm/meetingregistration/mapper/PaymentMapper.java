package com.sdarm.meetingregistration.mapper;

import com.sdarm.meetingregistration.domain.Payment;
import com.sdarm.meetingregistration.dto.payment.PaymentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    Payment toEntity(PaymentResponse response);

}
