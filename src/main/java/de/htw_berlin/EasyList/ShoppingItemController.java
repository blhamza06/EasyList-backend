package de.htw_berlin.EasyList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ShoppingItemController {

    @GetMapping("/items")
    public ResponseEntity<List<ShoppingItem>> getItems() {
        List<ShoppingItem> items = List.of(
                new ShoppingItem("Milch", 2, "Getränke"),
                new ShoppingItem("Brot", 1, "Backwaren"),
                new ShoppingItem("Äpfel", 5, "Obst")
        );
        return ResponseEntity.ok(items);
    }
}