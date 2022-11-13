package com.sdarm.meetingregistration.domain;

import com.sdarm.meetingregistration.enums.ParticipantGender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "apartment")
public class Apartment extends IdHolder {

    private String number;

    @Enumerated(EnumType.STRING)
    private ParticipantGender gender;

    @OneToMany(mappedBy = "apartment", fetch = FetchType.EAGER)
    private List<Bed> beds = new ArrayList<>();
}
