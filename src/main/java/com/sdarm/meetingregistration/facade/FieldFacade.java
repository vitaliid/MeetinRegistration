package com.sdarm.meetingregistration.facade;

import com.sdarm.meetingregistration.dto.field.FieldResponse;
import com.sdarm.meetingregistration.mapper.FieldMapper;
import com.sdarm.meetingregistration.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FieldFacade {

    private final FieldService fieldService;
    private final FieldMapper fieldMapper;

    public List<FieldResponse> getAll() {
        return fieldService.getAll().stream()
                .map(fieldMapper::toDto)
                .collect(Collectors.toList());
    }
}
