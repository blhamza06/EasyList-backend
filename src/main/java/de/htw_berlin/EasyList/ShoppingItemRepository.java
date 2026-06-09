package de.htw_berlin.EasyList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
}