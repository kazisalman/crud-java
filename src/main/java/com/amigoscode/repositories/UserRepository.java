package com.amigoscode.repositories;

import com.amigoscode.models.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    // Additional custom query methods can be defined here if needed
      List<Users> findByEmail(String email);
}
