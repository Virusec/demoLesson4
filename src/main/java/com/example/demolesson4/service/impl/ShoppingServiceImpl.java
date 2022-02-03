package com.example.demolesson4.service.impl;

import com.example.demolesson4.service.ShoppingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    List<String> shoppingList;

    public ShoppingServiceImpl() {
        shoppingList = new ArrayList<>();
    }

    @Override
    public boolean addToShoppingList(String item) {
        return shoppingList.add(item);
    }

    @Override
    public boolean removeFromShoppingList(int index) {
        String deletedItem = shoppingList.remove(index);
        return deletedItem != null;
    }

    @Override
    public List<String> getShoppingList() {
        return shoppingList;
    }
}
