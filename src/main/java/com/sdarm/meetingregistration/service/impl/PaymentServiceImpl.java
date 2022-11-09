package com.sdarm.meetingregistration.service.impl;


import com.sdarm.meetingregistration.domain.Payment;
import com.sdarm.meetingregistration.service.PaymentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends CrudServiceImpl<Payment> implements PaymentService {

    public PaymentServiceImpl(JpaRepository<Payment, String> repository) {
        super(repository);
    }
}
