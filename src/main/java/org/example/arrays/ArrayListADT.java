package org.example.arrays;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListADT {
    int SIZE = 0;
    int CAPACITY = 10;
    int[] arr;

    public int getSIZE() {
        return SIZE;
    }

    public ArrayListADT() {
        arr = new int[CAPACITY];
    }

    public ArrayListADT(int initialCapacity) {
        if (initialCapacity > 0) arr = new int[initialCapacity];
        else if (initialCapacity == 0) {
            arr = new int[]{};
        } else throw new IllegalArgumentException("Illegal Capacity" + initialCapacity);

    }

    void push(int value) {
        checkCapacity(SIZE + 1);

        arr[SIZE++] = value;

    }

    void pop() {
        checkCapacity(SIZE - 1);
        arr[SIZE--] = 0;

    }

    int get(int index) {
        if (index < 0 || index >= SIZE) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
        return arr[index];
    }

    void update(int index, int value) {
        if (index < 0 || index >= SIZE) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
        arr[index] = value;
    }

    void clear() {
        for (int i = 0; i < getSIZE(); i++) {
            arr[i] = 0;
        }
        SIZE = 0;
    }

    void remove(int index) {
        if (index < 0 || index >= SIZE) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + SIZE);
        int numMoved = getSIZE() - index - 1;
    }


    int[] list() {
        return arr;
    }

    void checkCapacity(int minCapacity) {
        if (minCapacity > arr.length) {
            int newCapacity = arr.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            arr = Arrays.copyOf(arr, newCapacity);

        }
    }


    void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(arr[i] + " ");

        }
    }

}

class Main {
    public static void main(String[] args) {

        ArrayListADT list = new ArrayListADT();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);

        System.out.println(list);
    }
}