package com.amigoscode.repositories;

import com.amigoscode.models.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Patients, Integer> {

    // Additional custom query methods can be defined here if needed
}
