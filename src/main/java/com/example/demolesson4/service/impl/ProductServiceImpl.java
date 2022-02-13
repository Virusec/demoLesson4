package com.example.demolesson4.service.impl;

import com.example.demolesson4.data.Product;
import com.example.demolesson4.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<>();
        products.add(new Product("еда", "хлеб"));
        products.add(new Product("еда", "колбаса"));
        products.add(new Product("еда", "йогурт"));
        products.add(new Product("техника", "телефон"));
        products.add(new Product("техника", "телефон"));
        products.add(new Product("техника", "телефон"));
        products.add(new Product("техника", "телефон"));
        products.add(new Product("техника", "планшет"));
        products.add(new Product("еда", "колбаса"));
    }

    @Override
    public List<String> getProductsNameByType(String type) {
        return products.stream()
                .filter(product -> product.getType().equals(type))
                .map(product -> product.getName())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllProductsName() {
        return products.stream()
                .map(product -> product.getName())
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public long countProductsByType(String type) {
        return products.stream()
                .filter(product -> product.getType().equals(type))
                .map(product -> product.getName())
                .count();
    }

    public String getProductNameByType(String type) {
        return products.stream()
                .filter(product -> product.getType().equals(type))
                .map(product -> product.getName())
                .findFirst()
                .orElse("Not found");
    }

    public void changeNameByName(String fromName, String toName) {
        products.stream()
                .filter(product -> product.getName().equals(fromName))
                .forEach(product -> product.setName(toName));
    }

    @Override
    public boolean containsProduct(String name, String type) {
        return products.contains(new Product(type, name));
    }

    @Override
    public boolean addProduct(String name, String type) {
        return products.add(new Product(type, name));
    }

    @Override
    public boolean removeProduct(String name, String type) {
        return products.remove(new Product(type, name));
    }
}
