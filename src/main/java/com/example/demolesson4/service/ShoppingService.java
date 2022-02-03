package com.example.demolesson4.service;

import java.util.List;

public interface ShoppingService {
    boolean addToShoppingList(String item);

    boolean removeFromShoppingList(int index);

    List<String> getShoppingList();
}
