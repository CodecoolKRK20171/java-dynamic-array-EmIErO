package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    private int size;
    private int[] data;

    public DynamicIntArray() {
        this.size = 0;
        this.data = new int[20];
    }

    public DynamicIntArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("An array cannot have size equal to: " + initialCapacity);
        }
        else if (initialCapacity < 20) {
            DynamicIntArray();
        } else {
            this.size = 0;
            this.data = new int[initialCapacity];
        }
    }

    public boolean add(int element) {
        checkCapacity();
        data[size++] = element;
        return true;
    }

    private void checkCapacity() {
        if ((size + 1) < data.length) {
            int[] newData = Arrays.copyOf(data, data.length * 3 / 2);
        }
    }

}
