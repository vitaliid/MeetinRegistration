package com.sdarm.meetingregistration.controller;

import com.sdarm.meetingregistration.dto.apartment.ApartmentResponse;
import com.sdarm.meetingregistration.facade.ApartmentFacade;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/registration/apartments")
@OpenAPIDefinition(tags = {@Tag(name = "registration"), @Tag(name = "apartments")})
@Slf4j
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentFacade apartmentFacade;

    @GetMapping
    public List<ApartmentResponse> getAll() {
        log.info("Get all apartments");

        return apartmentFacade.getAll();
    }
}
