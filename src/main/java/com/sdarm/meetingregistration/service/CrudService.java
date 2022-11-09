package com.sdarm.meetingregistration.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    Optional<T> getById(String id);

    List<T> getAll();

    T create(T domain);

    T update(T domain);

    void delete(String id);
}
