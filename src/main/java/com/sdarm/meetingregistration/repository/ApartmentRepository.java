package com.sdarm.meetingregistration.repository;


import com.sdarm.meetingregistration.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, String> {

}
