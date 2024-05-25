package com.posystem.posystem.Service;

import com.posystem.posystem.entity.Items;
import com.posystem.posystem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemsRepository;

    @Override
    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    @Override
    public Items getItemById(Long id) {
        return itemsRepository.findById(id).orElse(null);
    }

    @Override
    public Items createItem(Items item) {
        return itemsRepository.save(item);
    }

    @Override
    public Items updateItem(Long id, Items item) {
        Optional<Items> optionalItem = itemsRepository.findById(id);
        if (optionalItem.isPresent()) {
            Items existingItem = optionalItem.get();
            existingItem.setItemId(item.getItemId());
            existingItem.setItemName(item.getItemName());
            existingItem.setPrice(item.getPrice());
            existingItem.setStockQuantity(item.getStockQuantity());
            existingItem.setItemCategory(item.getItemCategory());
            return itemsRepository.save(existingItem);
        } else {
            return null;
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemsRepository.deleteById(id);
    }
}

