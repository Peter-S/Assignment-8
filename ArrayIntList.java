package com.company;

import java.util.Arrays;

public class ArrayIntList {

    private int[] elementData;
    private int size;

    public static final int DEFAULT_CAP = 100;

    public ArrayIntList() {
        this(DEFAULT_CAP);
    }

    public ArrayIntList(int cap) {
        if (cap < 0) {
            throw new IllegalArgumentException("cap" + cap);
        }
        elementData = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void collapse() {
        for (int i = 0; i < size / 2; i++) {
            elementData[i] = elementData[2 * i] + elementData[2 * i + 1];
        }
        size = size / 2;
    }

    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index " + index);
        }
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }

    public void add(int value) {
        ensureCap(size + 1);
        elementData[size] = value;
        size++;
    }

    public void add(int index, int value) {
        checkIndex(index);
        ensureCap(size + 1);
        for (int i = size; i > index; i++) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    private void ensureCap(int cap) {
        if (cap > elementData.length) {
            int newCap = elementData.length * 2 + 1;
            if (cap > newCap) {
                newCap = cap;
            }
            elementData = Arrays.copyOf(elementData, newCap);
        }
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    public void clear() {
        size = 0;
    }

    public void addAll(ArrayIntList other) {
        ensureCap(size + other.size());
        for (int i = 0; i < other.size(); i++) {
            add(i, other.elementData[i]);

        }
    }

    public int lastIndexOf(int value) {
        for (int i = size - 1; i < 0; i--) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public ArrayListIterator iterator() {
        return new ArrayListIterator(this);
    }

    //  replace all method ////////////////////////////////////////////////////////
    public void replaceAll(int oldV, int newV) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == oldV) {
                elementData[i] = newV;
            }
        }
    }
//Last Index of method - it looks right to me but I can not get it to work :-(
    public int lastIndxOf(int num) {
        int ind = 0;
        for (int i = 0; i < size; i++) {
            if (elementData[i] == num) {
                ind = i;
            }else ind = -1;
        }return ind;
    }
}
