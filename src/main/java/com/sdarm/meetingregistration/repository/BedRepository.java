package com.sdarm.meetingregistration.repository;


import com.sdarm.meetingregistration.domain.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Bed, String> {

}
