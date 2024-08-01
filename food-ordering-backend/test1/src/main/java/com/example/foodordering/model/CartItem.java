package com.example.foodordering.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart_items")
public class CartItem {

    @Id
    private String id;
    private String userId; // Reference to the user who owns this cart item
    private String itemId; // Reference to the item
    private String itemName; // Name of the item (for convenience)
    private int quantity; // Quantity of the item in the cart
    private double price; // Price of a single item

    // Constructors
    public CartItem() {}

    public CartItem(String userId, String itemId, String itemName, int quantity, double price) {
        this.userId = userId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Calculate total price for this cart item
    public double getTotalPrice() {
        return this.price * this.quantity;
    }
}
