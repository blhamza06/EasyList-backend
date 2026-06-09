package de.htw_berlin.EasyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemService {

    @Autowired
    private ShoppingItemRepository repository;

    public List<ShoppingItem> getAllItems() {
        return (List<ShoppingItem>) repository.findAll();
    }

    public ShoppingItem saveItem(ShoppingItem item) {
        return repository.save(item);
    }
}