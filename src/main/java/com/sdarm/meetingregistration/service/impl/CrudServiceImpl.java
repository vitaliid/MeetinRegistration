package com.sdarm.meetingregistration.service.impl;

import com.sdarm.meetingregistration.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class CrudServiceImpl<T> implements CrudService<T> {

    private final JpaRepository<T, String> repository;

    public Optional<T> getById(String id) {
        return repository.findById(id);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T create(T domain) {
        return repository.save(domain);
    }

    public T update(T domain) {
        return repository.save(domain);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
