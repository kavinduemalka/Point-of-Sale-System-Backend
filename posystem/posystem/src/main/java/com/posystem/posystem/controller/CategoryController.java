package com.posystem.posystem.controller;

import com.posystem.posystem.Service.CategoryService;
import com.posystem.posystem.entity.ItemCategory;
import com.posystem.posystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<ItemCategory> getCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public ItemCategory getCategoryByID(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public ItemCategory createCategory(@RequestBody ItemCategory category){
        return categoryService.createCategory(category);
    }

    // Update an existing category
    @PutMapping("/category/{id}")
    public ItemCategory updateCategory(@PathVariable Long id, @RequestBody ItemCategory category) {
        return categoryService.updateCategory(id, category);
    }

    // Delete a category by ID
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
