package com.sdarm.meetingregistration.service;


import com.sdarm.meetingregistration.domain.Address;

import java.util.List;

public interface AddressService {

    Address getById(String id);

    List<Address> getAll();

    Address create(Address field);

    Address update(Address field);

    void delete(String id);
}
