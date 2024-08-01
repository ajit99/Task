package com.example.foodordering.service;

import com.example.foodordering.model.Cart;
import com.example.foodordering.model.CartItem;
import com.example.foodordering.repository.CartRepository;
import com.example.foodordering.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Cart getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId).orElse(new Cart(userId));
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart addItemToCart(String userId, String itemId, int quantity) {
        Cart cart = getCartByUserId(userId);
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getItemId().equals(itemId))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem(itemId, quantity);
            cart.getItems().add(newItem);
        }

        return saveCart(cart);
    }

    public Cart removeItemFromCart(String userId, String itemId) {
        Cart cart = getCartByUserId(userId);
        cart.getItems().removeIf(item -> item.getItemId().equals(itemId));
        return saveCart(cart);
    }

    public Cart updateItemQuantity(String userId, String itemId, int quantity) {
        Cart cart = getCartByUserId(userId);
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getItemId().equals(itemId))
                .findFirst();

        existingItem.ifPresent(item ->
