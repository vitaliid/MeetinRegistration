package com.sdarm.meetingregistration.mapper;

import com.sdarm.meetingregistration.domain.Address;
import com.sdarm.meetingregistration.dto.address.AddressCreateRequest;
import com.sdarm.meetingregistration.dto.address.AddressResponse;
import com.sdarm.meetingregistration.dto.address.AddressUpdateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressResponse toDto(Address domain);

    Address toEntity(AddressCreateRequest request);

    Address toEntity(AddressUpdateRequest request);
}
