package com.posystem.posystem.Service;

import com.posystem.posystem.entity.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Items> getAllItems();
    Items getItemById(Long id);
    Items createItem(Items item);
    Items updateItem(Long id, Items item);
    void deleteItem(Long id);
}
