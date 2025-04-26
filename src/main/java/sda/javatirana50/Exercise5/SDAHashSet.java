package sda.javatirana50.Exercise5;

import java.util.LinkedList;

public class SDAHashSet<E>{

    private LinkedList<E>[] elements;
    private static final int MAX_CAPACITY = 20;
    private int size;

    public SDAHashSet() {
        elements = new LinkedList[MAX_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        if (size >= MAX_CAPACITY){
            System.out.println("SDAHashSet is full");
            return;
        }
        elements[size].add(element);
        size++;
    }

    public void remove(E element) {
        if (elements[size].contains(element)){
            elements[size].remove(element);
            size--;
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(E element) {
        return elements[size].contains(element);
    }

    public void clear() {
        size = 0;
    }


}
