package com.posystem.posystem.controller;

import com.posystem.posystem.entity.Items;
import com.posystem.posystem.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Items>> getAllItems() {
        List<Items> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Items> getItemById(@PathVariable Long id) {
        Items item = itemService.getItemById(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Items> createItem(@RequestBody Items item) {
        Items createdItem = itemService.createItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Items> updateItem(@PathVariable Long id, @RequestBody Items item) {
        Items updatedItem = itemService.updateItem(id, item);
        return updatedItem != null ? ResponseEntity.ok(updatedItem) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
