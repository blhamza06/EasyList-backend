package de.htw_berlin.EasyList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
    List<ShoppingItem> findByShoppingListId(Long shoppingListId);
}