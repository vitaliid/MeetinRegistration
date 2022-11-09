package com.sdarm.meetingregistration.service.impl;


import com.sdarm.meetingregistration.domain.Field;
import com.sdarm.meetingregistration.service.FieldService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl extends CrudServiceImpl<Field> implements FieldService {

    public FieldServiceImpl(JpaRepository<Field, String> repository) {
        super(repository);
    }
}
