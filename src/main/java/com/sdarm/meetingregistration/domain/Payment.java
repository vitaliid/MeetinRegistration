package com.sdarm.meetingregistration.domain;

import com.sdarm.meetingregistration.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment extends IdHolder {

    @Enumerated(EnumType.STRING)
    private PaymentType type;
}
