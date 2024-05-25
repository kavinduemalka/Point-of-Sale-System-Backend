package com.posystem.posystem.controller;

import com.posystem.posystem.entity.Items;
import com.posystem.posystem.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/items") 
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Items> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Items getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public Items createItem(@RequestBody Items item) {
        return itemService.createItem(item);
    }

    @PutMapping("/{id}")
    public Items updateItem(@PathVariable Long id, @RequestBody Items item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
