package com.example.demolesson4.service.list;

public class Mylist<T> {
    //Первый элемент списка
    Node<T> head;
    Node<T> tail;
    int size;


    public int size() {
        //Количество элементов списка
        return size;
    }

    //Добавление нового элемента в список
    public void add(T item) {
        Node<T> newNode = new Node<>();
        newNode.setItem(item);
        if (tail == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    //Получение элемента списка по его номеру
    public T get(int index) {
        if (checkIndex(index)) {
            Node<T> currentNode = getNode(index);
            return currentNode.getItem();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<T> getNode(int index) {
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    //Удаление элемента по его номеру
    public T remove(int index) {
        if (checkIndex(index)) {
            Node<T> deleteNode;
            if (index == 0) {
                deleteNode = head;
                head = head.getNext();
                if (size == 1) {
                    tail = null;
                }
            } else {
                Node<T> prevNode = getNode(index - 1);
                deleteNode = prevNode.getNext();
                Node<T> nextNode = deleteNode.getNext();
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
}
