package com.posystem.posystem.Service;

import com.posystem.posystem.entity.ItemCategory;
import com.posystem.posystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ItemCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ItemCategory getCategoryById(Long Id) {
        return categoryRepository.findById(Id).orElse(null);
    }

    @Override
    public ItemCategory createCategory(ItemCategory itemCategory) {
        return categoryRepository.save(itemCategory);
    }

    @Override
    public ItemCategory updateCategory(Long id, ItemCategory category) {
        ItemCategory existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory !=  null) {
            ItemCategory updatedCategory = existingCategory;
            updatedCategory.setCategoryName(category.getCategoryName());
            updatedCategory.setDescription(category.getDescription());
            return categoryRepository.save(updatedCategory);
        } else {
            return null;
        }
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        //return ResponseEntity.noContent().build();
    }
}
