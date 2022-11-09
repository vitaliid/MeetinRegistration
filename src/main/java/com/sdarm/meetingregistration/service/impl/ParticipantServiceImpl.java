package com.sdarm.meetingregistration.service.impl;


import com.sdarm.meetingregistration.domain.Participant;
import com.sdarm.meetingregistration.service.ParticipantService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl extends CrudServiceImpl<Participant> implements ParticipantService {

    public ParticipantServiceImpl(JpaRepository<Participant, String> repository) {
        super(repository);
    }
}
