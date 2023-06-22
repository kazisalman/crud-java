package com.amigoscode.controllers;

import com.amigoscode.requestDto.UserRequestDto;
import com.amigoscode.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/")
public class AuthController {

    public final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("signup")
    public void addCustomer(@RequestBody UserRequestDto request) {
        System.out.println("REACHED");
        authService.addCustomer(request);
    }

}
