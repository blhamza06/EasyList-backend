package de.htw_berlin.EasyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository listRepository;

    @Autowired
    private ShoppingItemRepository itemRepository;

    public List<ShoppingList> getAllLists() {
        return (List<ShoppingList>) listRepository.findAll();
    }

    public ShoppingList createList(ShoppingList list) {
        return listRepository.save(list);
    }

    public ShoppingList renameList(Long id, String newName) {
        ShoppingList list = listRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liste nicht gefunden"));
        list.setName(newName);
        return listRepository.save(list);
    }

    public void deleteList(Long id) {
        listRepository.deleteById(id);
    }

    public List<ShoppingItem> getItemsByList(Long id) {
        return itemRepository.findByShoppingListId(id);
    }

    public ShoppingItem addItemToList(Long id, ShoppingItem item) {
        ShoppingList list = listRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Liste nicht gefunden"));
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
        item.setShoppingList(list);
        return itemRepository.save(item);
    }
}