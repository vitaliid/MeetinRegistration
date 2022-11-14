package com.sdarm.meetingregistration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "bed")
public class Bed extends IdHolder {

    private String number;

    private int level;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @Version
    @Column(name = "booking")
    private int booking;
}
