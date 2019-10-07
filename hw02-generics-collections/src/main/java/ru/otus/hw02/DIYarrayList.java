package ru.otus.hw02;

import java.util.*;


public class DIYarrayList<T> implements List<T> {

    private T[] elements;

    /**
     * индекс последнего заполненного элемента списка
     */
    private int index = -1;

    /**
     * каретка итератора
     */
    private int current = -1;

    private static final int DEFAULT_CAPACITY = 20;

    public DIYarrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public DIYarrayList(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    private void growArray() {
        T[] newArray = (T[]) new Object[length() * 2];
        System.arraycopy(elements, 0, newArray, 0, length() );
        elements = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.index)
            throw new IllegalArgumentException();
    }

    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[]) elements, 0, size(), c);
    }

    @Override
    public boolean add(T element) {
        if (size() == length())
            growArray();

        index++;
        elements[index] = element;

        return true;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public T set(int index, T value) {
        checkIndex(index);
        elements[index] = value;
        return elements[index];
    }

    @Override
    public int size() {
        return index + 1;
    }

    public int length() {
        return elements.length;
    }

    public int indexOf(Object value) {
        int result = -1;
        for (int i = 0; i < index; i++) {
            if (elements[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String str = "[";
        for(T el : elements) str += " " + el;
        str += " ]; size: " + size() + "; len: " + length() + ";";
        return str;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {

        DIYarrayList self = this;
        current = -1;

        return new ListIterator<T>() {
            @Override
            public boolean hasNext() {
                return current + 1 < length();
            }

            @Override
            public T next() {
                current++;
                return elements[current];
            }

            @Override
            public boolean hasPrevious() {
                return current > -1;
            }

            @Override
            public T previous() {
                current--;
                return elements[current];
            }

            @Override
            public int nextIndex() {
                return current +1;
            }

            @Override
            public int previousIndex() {
                return current -1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(T t) {
                self.add(current, t);
            }

            @Override
            public void add(T t) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
