package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<E> {

    private static final int INITIAL_CAPACITY = 8;
    private int size;
    private Object[] elementData;

    public CustomArrayList() {
        this.size = 0;
        this.elementData = new Object[INITIAL_CAPACITY];
    }

    public CustomArrayList(int capacity) {
        this.size = 0;
        this.elementData = new Object[capacity];
    }

    public E add(E element) {
        increaseCapacity();
        elementData[size] = element;
        size++;
        return element;
    }

    public E add(int index, E element) {
        if (Math.abs(index) > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index < 0) {
            elementData[index + size] = element;
        }
        increaseCapacity();
        elementData[index] = element;
        if (index == size) {
            size++;
        }
        return element;
    }

    public E get(int index) {
        if (Math.abs(index) >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index < 0) {
            return (E) elementData[index + size];
        } else {
            return (E) elementData[index];
        }
    }

    public void clear() {
        this.elementData = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void addAll(Collection<? extends E> collection) {
        for (E e : collection) {
            add(e);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (index >= 0) {
            moveLeft(index);
        } else {
            moveLeft(index + size);
        }
    }

    public void remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                moveLeft(i);
                break;
            }
        }
    }

    public void sort(Comparator<? super E> comparator) {
        mergeSort((E[]) elementData, 0, size - 1, comparator);
    }

    private void increaseCapacity() {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length + 1);
        }
    }

    private void decreaseCapacity() {
        if (size < elementData.length / 2 - 1) {
            elementData = Arrays.copyOf(elementData, elementData.length / 2);
        }
    }

    private void moveLeft(int index) {
        if (Math.abs(index) >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData = Arrays.copyOf(elementData, elementData.length - 1);
        size--;
    }

    private void mergeSort(E[] a, int from, int to, Comparator<? super E> comp) {
        if (from == to)
            return;
        int mid = (from + to) / 2;
        mergeSort(a, from, mid, comp);
        mergeSort(a, mid + 1, to, comp);
        merge(a, from, mid, to, comp);
    }

    private void merge(E[] a, int from, int mid, int to, Comparator<? super E> comp) {
        int n = to - from + 1;
        Object[] values = new Object[n];

        int fromValue = from;

        int middleValue = mid + 1;

        int index = 0;

        while (fromValue <= mid && middleValue <= to) {
            if (comp.compare(a[fromValue], a[middleValue]) < 0) {
                values[index] = a[fromValue];
                fromValue++;
            } else {
                values[index] = a[middleValue];
                middleValue++;
            }
            index++;
        }

        while (fromValue <= mid) {
            values[index] = a[fromValue];
            fromValue++;
            index++;
        }
        while (middleValue <= to) {
            values[index] = a[middleValue];
            middleValue++;
            index++;
        }

        for (index = 0; index < n; index++)
            a[from + index] = (E) values[index];
    }

    public String toString() {
        Object[] printArray = Arrays.copyOf(elementData, size);
        return Arrays.toString(printArray);
    }
}

