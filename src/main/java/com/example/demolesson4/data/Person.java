package com.example.demolesson4.data;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return block == person.block && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, block);
    }
}
