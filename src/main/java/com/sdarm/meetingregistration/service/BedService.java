package com.sdarm.meetingregistration.service;


import com.sdarm.meetingregistration.domain.Bed;

import java.util.Optional;

public interface BedService extends CrudService<Bed> {

    Optional<Bed> getByParticipant(String participantId);
}
