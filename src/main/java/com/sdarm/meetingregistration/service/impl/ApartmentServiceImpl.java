package com.sdarm.meetingregistration.service.impl;


import com.sdarm.meetingregistration.domain.Apartment;
import com.sdarm.meetingregistration.service.ApartmentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartmentServiceImpl extends CrudServiceImpl<Apartment> implements ApartmentService {

    public ApartmentServiceImpl(JpaRepository<Apartment, String> repository) {
        super(repository);
    }
}
