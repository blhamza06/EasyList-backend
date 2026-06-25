package de.htw_berlin.EasyList;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ShoppingItemController {

    @Autowired
    private ShoppingItemService service;

    @GetMapping("/items")
    public ResponseEntity<List<ShoppingItem>> getItems() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @PostMapping("/items")
    public ResponseEntity<ShoppingItem> createItem(@Valid @RequestBody ShoppingItem item) {
        return ResponseEntity.ok(service.saveItem(item));
    }
}