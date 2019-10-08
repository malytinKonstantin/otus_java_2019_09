package ru.otus.hw02;

import java.util.*;


public class DIYarrayList<T> implements List<T> {

    private T[] elements;

    /**
     * индекс последнего заполненного элемента списка
     */
    private int index = -1;

    private static final int DEFAULT_CAPACITY = 10;

    private final ListItr listItr;

    public DIYarrayList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        listItr = new ListItr(this);
    }

    public DIYarrayList(int capacity) {
        elements = (T[]) new Object[capacity];
        listItr = new ListItr(this);
    }

    private void growArray() {
        T[] newArray = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length );
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
        if (size() == elements.length)
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

    public int indexOf(Object value) {
        int result = -1;
        for (int i = 0; i < index +1; i++) {
            if (value != null && value.equals(elements[i])) {
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
        str += " ]; size: " + size() + "; len: " + elements.length + ";";
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

    private class ListItr implements ListIterator<T> {
        private final DIYarrayList<T> self;
        private int current = -1;

        ListItr(DIYarrayList<T> self) {
            this.self = self;
        }

        @Override
        public boolean hasNext() {
            return current + 1 < self.size();
        }

        @Override
        public T next() {
            if (hasNext()) {
                current++;
                return self.elements[current];
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public boolean hasPrevious() {
            return current > -1;
        }

        @Override
        public T previous() {
            if (hasPrevious()) {
                current--;
                return self.elements[current];
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public int nextIndex() {
            if (hasNext()) {
                return current +1;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public int previousIndex() {
            if (hasPrevious()) {
                return current -1;
            } else {
                throw new NoSuchElementException();
            }
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
    }

    @Override
    public ListIterator<T> listIterator() {
        return listItr;
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
