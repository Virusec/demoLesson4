package com.example.demolesson4.controller;

import com.example.demolesson4.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {
    private final ProductService productService;

    public StoreController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/get/name-by-type")
    public List<String> getProductsNameByType() {
        return productService.getAllProductsName();
    }

    @GetMapping(path = "/get/names")
    public List<String> getALLProducts(@RequestParam("type") String type) {
        return productService.getProductsNameByType(type);
    }

    @GetMapping(path = "/get/count-by-type")
    public long countsProductByType(@RequestParam("type") String type) {
        return productService.countProductsByType(type);
    }

    @GetMapping(path = "/patch/product/")
    public void changeNameByName(@RequestParam("fromName") String fromName,@RequestParam("toName") String toName) {
        productService.changeNameByName(fromName, toName);
    }

    @GetMapping(path = "/get/product/")
    public String getProductNameByType(@RequestParam("type") String type) {
        return productService.getProductNameByType(type);
    }

    @GetMapping(path = "/post/add-product")
    boolean addProduct(@RequestParam("name") String name, @RequestParam("type") String type) {
        return productService.addProduct(name, type);
    }

    @GetMapping(path = "/post/remove-product")
    boolean removeProduct(@RequestParam("name") String name, @RequestParam("type") String type) {
        return productService.removeProduct(name, type);
    }

    @GetMapping(path = "/get/contains-product")
    boolean containsProduct(@RequestParam("name") String name, @RequestParam("type") String type) {
        return productService.containsProduct(name, type);
    }
}
