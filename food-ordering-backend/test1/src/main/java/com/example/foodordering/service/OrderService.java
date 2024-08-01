package com.example.foodordering.service;

import com.example.foodordering.model.Order;
import com.example.foodordering.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Retrieve orders by user ID
    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    // Save a new order
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Retrieve an order by ID
    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    // Retrieve all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Update an existing order
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    // Delete an order by ID
    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
