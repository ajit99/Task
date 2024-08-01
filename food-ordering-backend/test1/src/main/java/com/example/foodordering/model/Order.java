package com.example.foodordering.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String userId;
    private List<CartItem> items;
    private double total;
    private boolean delivered;

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(String id, String userId, List<CartItem> items, double total, boolean delivered) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.total = total;
        this.delivered = delivered;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public boolean isDelivered() {
        return delivered;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
