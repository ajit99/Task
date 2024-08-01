package com.example.foodordering.repository;

import com.example.foodordering.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Custom method to find a user by their email
    User findByEmail(String email);
}
