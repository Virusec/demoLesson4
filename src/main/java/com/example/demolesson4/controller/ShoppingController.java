package com.example.demolesson4.controller;

import com.example.demolesson4.service.ShoppingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingController {

    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping(path = "/post/shopping-list")
    public boolean addToShoppingList(@RequestParam("item") String item) {
        return shoppingService.addToShoppingList(item);
    }

    @GetMapping(path = "/delete/shopping-list/")
    public boolean removeFromShoppingList(@RequestParam("index") int index) {
        return shoppingService.removeFromShoppingList(index);
    }

    @GetMapping(path = "/get/shopping-list/")
    public List<String> getShoppingList() {
        return shoppingService.getShoppingList();
    }
}
