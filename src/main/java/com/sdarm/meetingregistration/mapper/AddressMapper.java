package com.sdarm.meetingregistration.mapper;

import com.sdarm.meetingregistration.domain.Address;
import com.sdarm.meetingregistration.dto.address.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressResponse response);

}
