package com.sdarm.meetingregistration.service.impl;


import com.sdarm.meetingregistration.domain.Bed;
import com.sdarm.meetingregistration.service.BedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BedServiceImpl extends CrudServiceImpl<Bed> implements BedService {

    public BedServiceImpl(JpaRepository<Bed, String> repository) {
        super(repository);
    }
}
