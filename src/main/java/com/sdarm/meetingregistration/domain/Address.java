package com.sdarm.meetingregistration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address extends IdHolder {

    private String city;

    @OneToOne
    @JoinColumn(name = "field_id")
    private Field field;
}
