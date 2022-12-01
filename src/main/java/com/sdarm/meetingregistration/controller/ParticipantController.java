package com.sdarm.meetingregistration.controller;

import com.sdarm.meetingregistration.dto.participant.ParticipantResponse;
import com.sdarm.meetingregistration.facade.ParticipantFacade;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/registration/participants")
@OpenAPIDefinition(tags = {@Tag(name = "registration"), @Tag(name = "participants")})
@SecurityRequirement(name = "Bearer Authentication")
@Slf4j
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantFacade participantFacade;

    @GetMapping
    public List<ParticipantResponse> getAll() {
        log.info("Get all participants");

        return participantFacade.getAll();
    }

    @GetMapping("{id}")
    public ParticipantResponse getById(@PathVariable String id) {
        log.info("Get participant by id {}", id);

        return participantFacade.getById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        log.info("Delete participant with id {}", id);

        participantFacade.delete(id);
    }

}
