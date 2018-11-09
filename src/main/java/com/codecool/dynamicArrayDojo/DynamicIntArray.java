package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    private int size;
    public int[] data;

    public DynamicIntArray() {
        this.size = 0;
        this.data = new int[20];
    }

    public DynamicIntArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("An array cannot have size equal to: " + initialCapacity);
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

    public void clear() {
        this.data = new int[data.length];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void remove(int number) {

        int numberIndex = -1;

        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == number) {
                numberIndex = i;
                break;
            }
        }

        if (numberIndex < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int[] newData = new int[this.size - 1];
        for (int j = 0; j < numberIndex; j ++) {
            newData[j] = this.data[j];
        }

        for (int j = numberIndex; j < this.size - 1; j++) {
            newData[j] = this.data[j + 1];
        }

        this.size--;
        this.data = newData;
    }

    public void insert(int index, int number) {

        if(index >= this.data.length) {
            checkCapacity();
            this.data[this.size] = number;
            this.size++;
        } else {
            int[] newData = new int[this.size + 1];
            for (int j = 0; j < index; j++) {
                newData[j] = this.data[j];
            }

            newData[index] = number;

            for (int j = index +1; j < newData.length; j++) {
                newData[j] = this.data[j - 1];
            }

            this.size++;
            this.data = newData;
        }
    }

    public String toString() {
        String arr = "";
        for (int i = 0; i < this.size; i++) {
            arr = arr.concat((" " + data[i]));
        }
        return arr;
    }
    private void checkCapacity() {
        if ((size + 1) >= data.length) {
            int[] newData = Arrays.copyOf(data, data.length + 1);

            this.data = newData;
        }
    }

}
