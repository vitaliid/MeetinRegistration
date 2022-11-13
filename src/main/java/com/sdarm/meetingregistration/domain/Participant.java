package com.sdarm.meetingregistration.domain;

import com.sdarm.meetingregistration.enums.ParticipantGender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "participant")
public class Participant extends IdHolder {

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private ParticipantGender gender;

    private String minister;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(mappedBy = "participant")
    private Bed bed;
}
