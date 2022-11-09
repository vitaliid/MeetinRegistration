package com.sdarm.meetingregistration.service;


import com.sdarm.meetingregistration.domain.Field;

import java.util.List;

public interface FieldService {

    Field getById(String id);

    List<Field> getAll();

    Field create(Field field);

    Field update(Field field);

    void delete(String id);
}
