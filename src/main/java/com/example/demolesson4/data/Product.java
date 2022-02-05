package com.example.demolesson4.data;

import java.util.Objects;

public class Product {
    private final String type;
    private final String name;

    public Product(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(type, product.type) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
