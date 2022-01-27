package com.example.demolesson4;

public class Person {
    private String name;
    private boolean block;

    public Person(String name, boolean block) {
        this.name = name;
        this.block = block;
    }

    public String getName() {
        return name;
    }

    public boolean isBlock() {
        return block;
    }
}
