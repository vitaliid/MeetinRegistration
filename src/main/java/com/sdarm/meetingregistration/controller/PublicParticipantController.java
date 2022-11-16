package com.sdarm.meetingregistration.controller;

import com.sdarm.meetingregistration.dto.participant.ParticipantCreateRequest;
import com.sdarm.meetingregistration.dto.participant.ParticipantResponse;
import com.sdarm.meetingregistration.facade.ParticipantFacade;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("api/public/registration/participants")
@OpenAPIDefinition(tags = {@Tag(name = "public"), @Tag(name = "registration"), @Tag(name = "participants")})
@Slf4j
@RequiredArgsConstructor
public class PublicParticipantController {

    private final ParticipantFacade participantFacade;

    @PostMapping
    public ParticipantResponse create(@RequestBody ParticipantCreateRequest request) {
        log.info("Create participant");

        return participantFacade.create(request);
    }
}
