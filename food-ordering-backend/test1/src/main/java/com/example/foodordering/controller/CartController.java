package com.example.foodordering.controller;

import com.example.foodordering.dto.CartDTO;
import com.example.foodordering.model.Cart;
import com.example.foodordering.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<CartDTO> getCart(@PathVariable String userId) {
        Cart cart = cartService.getCartByUserId(userId);
        if (cart == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Convert Cart to CartDTO if needed
        CartDTO cartDTO = convertToDTO(cart);
        return ResponseEntity.ok(cartDTO);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<CartDTO> updateCart(@PathVariable String userId, @Valid @RequestBody CartDTO cartDTO) {
        // Convert CartDTO to Cart
        Cart cart = convertToModel(cartDTO);
        cart.setUserId(userId);

        Cart updatedCart = cartService.saveCart(cart);
        CartDTO updatedCartDTO = convertToDTO(updatedCart);

        return ResponseEntity.ok(updatedCartDTO);
    }

    private CartDTO convertToDTO(Cart cart) {
        // Implement conversion logic from Cart to CartDTO
        // Example:
        return new CartDTO(cart.getUserId(), cart.getItems(), cart.getTotal());
    }

    private Cart convertToModel(CartDTO cartDTO) {
        // Implement conversion logic from CartDTO to Cart
        // Example:
        return new Cart(cartDTO.getUserId(), cartDTO.getItems(), cartDTO.getTotal());
    }
}
