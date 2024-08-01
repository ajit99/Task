package com.example.foodordering.controller;

import com.example.foodordering.dto.OrderDTO;
import com.example.foodordering.model.Order;
import com.example.foodordering.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrders(@PathVariable String userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        if (orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<OrderDTO> orderDTOs = orders.stream()
                                         .map(this::convertToDTO)
                                         .collect(Collectors.toList());
        return ResponseEntity.ok(orderDTOs);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        try {
            Order order = convertToEntity(orderDTO);
            Order savedOrder = orderService.saveOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body(convertToDTO(savedOrder));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .build();
        }
    }

    private OrderDTO convertToDTO(Order order) {
        return new OrderDTO(
            order.getId(),
            order.getUserId(),
            order.getItems(), // Ensure items are properly mapped or handled
            order.getTotal(),
            order.getStatus() // Assuming status is part of the Order model
        );
    }

    private Order convertToEntity(OrderDTO orderDTO) {
        return new Order(
            orderDTO.getId(),
            orderDTO.getUserId(),
            orderDTO.getItems(), // Ensure items are properly mapped or handled
            orderDTO.getTotal(),
            orderDTO.getStatus() // Assuming status is part of the Order model
        );
    }
}
