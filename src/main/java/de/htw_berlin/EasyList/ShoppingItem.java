package de.htw_berlin.EasyList;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shopping_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name darf nicht leer sein")
    private String name;

    @Min(value = 1, message = "Menge muss mindestens 1 sein")
    private int quantity;

    @NotBlank(message = "Einheit darf nicht leer sein")
    private String unit;

    @NotBlank(message = "Kategorie darf nicht leer sein")
    private String category;
}