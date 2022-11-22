package com.sdarm.meetingregistration.repository;


import com.sdarm.meetingregistration.domain.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BedRepository extends JpaRepository<Bed, String> {

    Optional<Bed> findByParticipantId(String participantId);
}
