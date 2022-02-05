package com.example.demolesson4.service.list;

import com.example.demolesson4.data.Person;

public class Node<T> {
    Node<T> next;
    T item;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
