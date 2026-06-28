package de.htw_berlin.EasyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository repository;

    public List<ShoppingList> getAllLists() {
        return (List<ShoppingList>) repository.findAll();
    }

    public ShoppingList createList(ShoppingList list) {
        return repository.save(list);
    }

    public void deleteList(Long id) {
        repository.deleteById(id);
    }
}