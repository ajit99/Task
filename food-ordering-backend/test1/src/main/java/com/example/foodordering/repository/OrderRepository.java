package com.example.foodordering.repository;

import com.example.foodordering.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // Custom query method to find orders by userId
    List<Order> findByUserId(String userId);
}
