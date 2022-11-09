package com.sdarm.meetingregistration.service.impl;


import com.sdarm.meetingregistration.domain.Address;
import com.sdarm.meetingregistration.service.AddressService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address> implements AddressService {

    public AddressServiceImpl(JpaRepository<Address, String> repository) {
        super(repository);
    }
}
