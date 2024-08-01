package com.example.foodordering.service;

import com.example.foodordering.model.Item;
import com.example.foodordering.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Retrieve items by category
    public List<Item> getItemsByCategory(String category) {
        return itemRepository.findByCategory(category);
    }

    // Retrieve all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Retrieve item by ID
    public Item getItemById(String itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    // Save a new item or update an existing one
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // Delete an item by ID
    public void deleteItem(String itemId) {
        itemRepository.deleteById(itemId);
    }
}
