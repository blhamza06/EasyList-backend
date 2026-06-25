package de.htw_berlin.EasyList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EasyListApplicationTests {

    @Autowired
    private ShoppingItemService service;

    @Test
    void contextLoads() {
        assertNotNull(service);
    }

    @Test
    void saveItem_returnsSavedItem() {
        ShoppingItem item = new ShoppingItem(null, "Milch", 2, "L", "Getränke");
        ShoppingItem saved = service.saveItem(item);
        assertNotNull(saved.getId());
        assertEquals("Milch", saved.getName());
    }

    @Test
    void saveItem_withEmptyName_throwsException() {
        ShoppingItem item = new ShoppingItem(null, "", 2, "L", "Getränke");
        assertThrows(IllegalArgumentException.class, () -> service.saveItem(item));
    }

    @Test
    void getAllItems_returnsNonNullList() {
        var items = service.getAllItems();
        assertNotNull(items);
    }
}