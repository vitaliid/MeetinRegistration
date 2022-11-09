package com.sdarm.meetingregistration.service;


import com.sdarm.meetingregistration.domain.User;

import java.util.List;

public interface UserService {

    User getById(String id);

    List<User> getAll();

    User create(User field);

    User update(User field);

    void delete(String id);
}
