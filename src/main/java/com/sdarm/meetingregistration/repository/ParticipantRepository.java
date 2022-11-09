package com.sdarm.meetingregistration.repository;


import com.sdarm.meetingregistration.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, String> {

}
