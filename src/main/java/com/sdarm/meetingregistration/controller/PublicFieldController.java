package com.sdarm.meetingregistration.controller;

import com.sdarm.meetingregistration.dto.field.FieldResponse;
import com.sdarm.meetingregistration.facade.FieldFacade;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/public/registration/fields")
@OpenAPIDefinition(tags = {@Tag(name = "public"), @Tag(name = "registration"), @Tag(name = "fields")})
@Slf4j
@RequiredArgsConstructor
public class PublicFieldController {

    private final FieldFacade fieldFacade;

    @GetMapping
    public List<FieldResponse> get() {
        log.info("Get all fields");

        return fieldFacade.getAll();
    }
}
