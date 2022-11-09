package com.sdarm.meetingregistration.service;


import com.sdarm.meetingregistration.domain.Payment;

import java.util.List;

public interface PaymentService {

    Payment getById(String id);

    List<Payment> getAll();

    Payment create(Payment field);

    Payment update(Payment field);

    void delete(String id);
}
