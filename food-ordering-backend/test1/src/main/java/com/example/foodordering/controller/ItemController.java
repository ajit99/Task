package com.example.foodordering.controller;

import com.example.foodordering.dto.ItemDTO;
import com.example.foodordering.model.Item;
import com.example.foodordering.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        List<ItemDTO> itemDTOs = items.stream()
                                      .map(this::convertToDTO)
                                      .collect(Collectors.toList());
        return ResponseEntity.ok(itemDTOs);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ItemDTO>> getItemsByCategory(@PathVariable String category) {
        List<Item> items = itemService.getItemsByCategory(category);
        if (items.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        List<ItemDTO> itemDTOs = items.stream()
                                      .map(this::convertToDTO)
                                      .collect(Collectors.toList());
        return ResponseEntity.ok(itemDTOs);
    }

    private ItemDTO convertToDTO(Item item) {
        return new ItemDTO(
            item.getId(),
            item.getName(),
            item.getDescription(),
            item.getCategory(),
            item.getPrice(),
            item.getStock()
        );
    }
}
