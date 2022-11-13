package com.sdarm.meetingregistration.mapper;

import com.sdarm.meetingregistration.domain.Apartment;
import com.sdarm.meetingregistration.dto.apartment.ApartmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApartmentMapper {

    ApartmentResponse toDto(Apartment domain);
}
