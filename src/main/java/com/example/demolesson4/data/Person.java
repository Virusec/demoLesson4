package com.example.demolesson4.data;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
