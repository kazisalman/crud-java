package com.amigoscode.repositories;

import com.amigoscode.models.Customer;
import com.amigoscode.models.NewCustomerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Additional custom query methods can be defined here if needed
}
