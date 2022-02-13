package com.example.demolesson4.service;

import java.util.List;

public interface ProductService {
    List<String> getProductsNameByType(String type);
    List<String> getAllProductsName();
    long countProductsByType(String type);
    void changeNameByName(String fromName, String toName);
    String getProductNameByType(String type);
    boolean containsProduct(String name, String type);
    boolean addProduct(String name, String type);
    boolean removeProduct(String name, String type);


}
