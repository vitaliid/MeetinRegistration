package com.sdarm.meetingregistration.dto.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressUpdateRequest extends AddressAbstractRequest {

    private String id;
}
