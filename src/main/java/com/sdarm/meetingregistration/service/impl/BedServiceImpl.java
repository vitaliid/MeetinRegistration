package com.sdarm.meetingregistration.service.impl;


import com.sdarm.meetingregistration.domain.Bed;
import com.sdarm.meetingregistration.repository.BedRepository;
import com.sdarm.meetingregistration.service.BedService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BedServiceImpl extends CrudServiceImpl<Bed> implements BedService {

    private final BedRepository bedRepository;

    public BedServiceImpl(BedRepository repository) {
        super(repository);
        bedRepository = repository;
    }

    @Override
    public Optional<Bed> getByParticipant(String participantId) {
        return bedRepository.findByParticipantId(participantId);
    }
}
