package com.example.foodordering.dto;

public class CartItemDTO {

    private String itemId; // ID of the item
    private String name; // Name of the item
    private int quantity; // Quantity of the item in the cart
    private double price; // Price per unit of the item

    // Constructors
    public CartItemDTO() {}

    public CartItemDTO(String itemId, String name, int quantity, double price) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    // Calculate the total price for this item
    public double getTotalPrice() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
