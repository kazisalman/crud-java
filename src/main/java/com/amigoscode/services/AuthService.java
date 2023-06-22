package com.amigoscode.services;

import com.amigoscode.models.Patients;
import com.amigoscode.repositories.UserRepository;
import com.amigoscode.requestDto.UserRequestDto;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addCustomer(UserRequestDto request) {
        Patients user = new Patients();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setAge(request.age());
        userRepository.save(user);
    }

//    public List<Customer> getCustomers() {
//        List<Customer> customers = userRepository.findAll();
//        return customers;
//    }

//    public void deleteCustomer(Integer id) {
//        customerRepository.deleteById(id);
//
//        //return json { }
//    }
}
