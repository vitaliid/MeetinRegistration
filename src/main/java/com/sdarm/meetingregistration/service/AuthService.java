package com.sdarm.meetingregistration.service;

public interface AuthService {

    String auth(String username, String password);

    Boolean validateToken(String token);
}
