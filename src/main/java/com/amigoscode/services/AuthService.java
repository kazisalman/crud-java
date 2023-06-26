package com.amigoscode.services;

import com.amigoscode.models.Users;
import com.amigoscode.repositories.UserRepository;
import com.amigoscode.requestDto.UserLoginDto;
import com.amigoscode.requestDto.UserSignupDto;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String signup(UserSignupDto request) {
        List<Users> customers = userRepository.findByEmail(request.email());
        if(customers.size() > 0){
            return "User with same email already exist";
        }

        Users user = new Users();
        user.setEmail(request.email());
        user.setPassword(request.password());
        userRepository.save(user);
        return "Signup successfull";
    }
    public List<Users> login(UserLoginDto request) {
        List<Users> customers = userRepository.findByEmail(request.email());
        System.out.println(customers.size());
        return customers;
    }
}
