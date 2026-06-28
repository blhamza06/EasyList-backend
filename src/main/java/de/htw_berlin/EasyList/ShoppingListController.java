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

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingList> renameList(@PathVariable Long id, @RequestBody ShoppingList list) {
        return ResponseEntity.ok(service.renameList(id, list.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Long id) {
        service.deleteList(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/items")
    public ResponseEntity<List<ShoppingItem>> getItemsByList(@PathVariable Long id) {
        return ResponseEntity.ok(service.getItemsByList(id));
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<ShoppingItem> addItemToList(@PathVariable Long id, @RequestBody ShoppingItem item) {
        return ResponseEntity.ok(service.addItemToList(id, item));
    }
}