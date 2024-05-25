package com.posystem.posystem.Service;

import com.posystem.posystem.entity.ItemCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<ItemCategory> getAllCategories();
    ItemCategory getCategoryById(Long Id);

    ItemCategory createCategory(ItemCategory itemCategory);

    ItemCategory updateCategory(Long id, ItemCategory itemCategory);

    void deleteCategory(Long id);

}
