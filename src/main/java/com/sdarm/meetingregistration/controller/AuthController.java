package com.sdarm.meetingregistration.controller;

import com.sdarm.meetingregistration.service.AuthService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
@OpenAPIDefinition(tags = {@Tag(name = "auth")})
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public String auth(@RequestParam String username, @RequestParam String password) {
        return authService.auth(username, password);
    }
}
