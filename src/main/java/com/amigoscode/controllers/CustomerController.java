package com.amigoscode.controllers;

import com.amigoscode.models.Customer;
import com.amigoscode.models.NewCustomerRequest;
import com.amigoscode.response.ResponseHandler;
import com.amigoscode.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class CustomerController {
    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        customerService.addCustomer(request);
    }

    @GetMapping
    public ResponseEntity<Object> getCustomers() {

        try {
             List<Customer> customers = customerService.getCustomers();
             return ResponseHandler.generateResponse("Successfull", HttpStatus.OK,customers);
//            return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerService.deleteCustomer(id);
    }
}
