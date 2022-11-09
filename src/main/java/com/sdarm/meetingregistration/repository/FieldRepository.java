package com.sdarm.meetingregistration.repository;


import com.sdarm.meetingregistration.domain.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, String> {

}
