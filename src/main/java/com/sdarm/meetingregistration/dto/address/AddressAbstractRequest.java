package com.sdarm.meetingregistration.dto.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AddressAbstractRequest {

    private String city;

    private String fieldId;
}

