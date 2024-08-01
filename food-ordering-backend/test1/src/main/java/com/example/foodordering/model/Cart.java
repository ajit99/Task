package com.example.foodordering.model;

public class Cart {
    private String itemId;
    private int quantity;

    // Default constructor
    public Cart() {}

    // Parameterized constructor
    public Cart(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    // Getters
    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
