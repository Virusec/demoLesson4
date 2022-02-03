package com.example.demolesson4.service.list;

import com.example.demolesson4.data.Person;

public class Mylist {
    Node head;
    Node tail;
    int size;

    public boolean add(Person item) {
        Node newNode = new Node();
        newNode.setItem(item);
        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
        return true;
    }

    public Person get(int index) {
        if (checkIndex(index)) {
            Node currentNode = getNode(index);
            return currentNode.getItem();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getNode(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    public Person remove(int index) {
        if (checkIndex(index)) {
            Node deleteNode;
            if (index == 0) {
                deleteNode = head;
                head = head.getNext();
                if (size == 1) {
                    tail = null;
                }
            } else {
                Node prevNode = getNode(index - 1);
                deleteNode = prevNode.getNext();
                Node nextNode = deleteNode.getNext();
                prevNode.setNext(nextNode);
                if (nextNode == null) {
                    tail = prevNode;
                }
            }
            size--;
            return deleteNode.getItem();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }
}
