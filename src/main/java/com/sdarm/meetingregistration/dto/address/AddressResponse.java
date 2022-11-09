package com.sdarm.meetingregistration.dto.address;


import com.sdarm.meetingregistration.dto.field.FieldResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressResponse {

    private String id;

    private String city;

    private FieldResponse field;
}
