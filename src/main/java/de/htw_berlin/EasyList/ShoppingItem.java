package de.htw_berlin.EasyList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShoppingItem {
    private String name;
    private int quantity;
    private String category;
}
