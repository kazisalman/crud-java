package com.amigoscode.services;

import com.amigoscode.models.Customer;
import com.amigoscode.models.NewCustomerRequest;
import com.amigoscode.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(NewCustomerRequest request) {
        Customer cust = new Customer();
        cust.setName(request.name());
        cust.setAge(request.age());
        cust.setEmail(request.email());
        customerRepository.save(cust);
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);

        //return json { }
    }
}
