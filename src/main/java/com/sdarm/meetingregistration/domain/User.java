package com.sdarm.meetingregistration.domain;

import com.sdarm.meetingregistration.enums.UserGender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends IdHolder {

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserGender gender;

    private String minister;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
