package com.sdarm.meetingregistration.facade;

import com.sdarm.meetingregistration.dto.apartment.ApartmentResponse;
import com.sdarm.meetingregistration.mapper.ApartmentMapper;
import com.sdarm.meetingregistration.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentFacade {

    private final ApartmentService apartmentService;
    private final ApartmentMapper apartmentMapper;

    public List<ApartmentResponse> getAll() {
        return apartmentService.getAll().stream()
                .map(apartmentMapper::toDto)
                .collect(Collectors.toList());
    }
}
