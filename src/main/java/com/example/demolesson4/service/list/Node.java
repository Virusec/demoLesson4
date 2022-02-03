package com.example.demolesson4.service.list;

import com.example.demolesson4.data.Person;

public class Node {
    Node next;
    Person item;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Person getItem() {
        return item;
    }

    public void setItem(Person item) {
        this.item = item;
    }
}
