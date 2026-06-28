package de.htw_berlin.EasyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/lists")
public class ShoppingListController {

    @Autowired
    private ShoppingListService service;

    @GetMapping
    public ResponseEntity<List<ShoppingList>> getAllLists() {
        return ResponseEntity.ok(service.getAllLists());
    }

    @PostMapping
    public ResponseEntity<ShoppingList> createList(@RequestBody ShoppingList list) {
        return ResponseEntity.ok(service.createList(list));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        service.deleteList(id);
        return ResponseEntity.ok().build();
    }
}