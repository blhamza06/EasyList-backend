package de.htw_berlin.EasyList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {
    List<ShoppingList> findByOwner(User owner);
}