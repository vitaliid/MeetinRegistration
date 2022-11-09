package com.sdarm.meetingregistration.repository;


import com.sdarm.meetingregistration.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
