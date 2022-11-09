package com.sdarm.meetingregistration.mapper;

import com.sdarm.meetingregistration.domain.Field;
import com.sdarm.meetingregistration.dto.field.FieldResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FieldMapper {

    Field toEntity(FieldResponse response);

}
