package com.sdarm.meetingregistration.mapper;

import com.sdarm.meetingregistration.domain.Payment;
import com.sdarm.meetingregistration.dto.payment.PaymentCreateRequest;
import com.sdarm.meetingregistration.dto.payment.PaymentResponse;
import com.sdarm.meetingregistration.dto.payment.PaymentUpdateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentResponse toDto(Payment domain);

    Payment toEntity(PaymentCreateRequest request);

    Payment toEntity(PaymentUpdateRequest request);
}
