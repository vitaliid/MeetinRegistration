package com.sdarm.meetingregistration.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "field")
public class Field extends IdHolder {

    private String name;
}
