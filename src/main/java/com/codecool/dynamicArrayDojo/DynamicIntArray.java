package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    private int[] array;

    public DynamicIntArray(int size) {
        this.array = new int[size];
    }

    public DynamicIntArray() {
        this.array = new int[0];
    }

//    public int[] createArray(int size) {
//        int[] array = new int[size];
//        for (int i=0; i<size; i++) {
//            array[i] = i;
//        }
//        return array;
//    }

    public void remove(int value) {
        boolean isValueInArray = false;
        for (int n: this.array) {
            if (n==value) isValueInArray = true;
        }
        if (!isValueInArray) throw new ArrayIndexOutOfBoundsException();
        boolean valueFound = false;
        int newArraySize = this.array.length -1;
        int[] temp = this.array;
        this.array = new int[newArraySize];
        for (int i=0; i<temp.length-1; i++) {
            if (i == value) valueFound = true;
            this.array[i] = valueFound ? temp[i + 1] : temp[i];
        }
    }

    public void add(int value) {
        int newArraySize = this.array.length + 1;
        int[] temp = this.array;
        this.array = new int[newArraySize];
        for (int i=0; i<temp.length; i++) {
            this.array[i] = temp[i];
        }
        this.array[newArraySize-1] = value;
    }

    public void insert(int index, int value) {
        boolean valueFound = false;
        int newArraySize = this.array.length + 1;
        int[] temp = this.array;
        this.array = new int[newArraySize];
        for (int i=0; i<temp.length; i++) {
            if (valueFound) {
                this.array[i + 1] = temp[i];
            } else {
                if (i == index) {
                    this.array[i] = value;
                    this.array[i + 1] = temp[i];
                    valueFound = true;
                } else {
                    this.array[i] = temp[i];
                }
            }
        }
        if (index > newArraySize - 1) {
            this.array[newArraySize-1] = value;
        }
    }

    public String toString() {
        String toReturn = "";
        for (int i: this.array) {
            toReturn += " " + i;
        }
        return toReturn;
    }
}
