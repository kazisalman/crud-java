package com.amigoscode.controllers;

import com.amigoscode.models.Users;
import com.amigoscode.requestDto.UserLoginDto;
import com.amigoscode.requestDto.UserSignupDto;
import com.amigoscode.services.AuthService;
import com.amigoscode.utils.ResponseHandler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> addCustomer(@RequestBody UserSignupDto request) {
        try {
            String response =  authService.signup(request);
            return ResponseHandler.generateResponse(response, HttpStatus.OK , null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto request) {
        try {
            List<Users> customers = authService.login(request);
            return ResponseHandler.generateResponse("Login successfull", HttpStatus.OK , customers);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
