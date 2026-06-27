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
        if (item.getName() == null || item.getName().isBlank()) {
            throw new IllegalArgumentException("Name darf nicht leer sein");
        }
        if (item.getUnit() == null || item.getUnit().isBlank()) {
            throw new IllegalArgumentException("Einheit darf nicht leer sein");
        }
        if (item.getCategory() == null || item.getCategory().isBlank()) {
            throw new IllegalArgumentException("Kategorie darf nicht leer sein");
        }
        if (item.getQuantity() < 1) {
            throw new IllegalArgumentException("Menge muss mindestens 1 sein");
        }
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}