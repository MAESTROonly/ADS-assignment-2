package setofarraylists;

import java.util.Iterator;

public class Myarraylist<T> implements Mylist<T> {
    private T[] array;
    private int size;
    private int capacity;
    public Myarraylist(){
        array = (T[])new Object[5];
        capacity = 5;
        size = 0;
    }

    public Myarraylist(int capacity){
        array = (T[])new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }
    @Override
    public void add(T element) {
        if (size >= capacity) {
            IncreaseSize();
        }
        array[size++] = element;
    }
    private void IncreaseSize() {
        capacity += size * 2;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) { // Iterate up to size, not capacity
            newArray[i] = array[i];
        }
        array = newArray;
    }
    private void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public void add(int index, T item) {
        if (size >= capacity) {
            IncreaseSize();
        }
        checkIndex(index);
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        if(size >= capacity){
            IncreaseSize();
        }
        for(int i=size; i>=1; i--) {
            array[i] = array[i-1];
        }
        array[0] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if(size >= capacity){
            IncreaseSize();
        }
        array[size++] = item;

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public T getFirst(){
        return array[0];
    }

    @Override
    public T getLast(){
        return array[size - 1];
    }

    @Override
    public void remove(int index){
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    @Override
    public void removeFirst() {
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
    @Override
    public void removeLast(){
        for (int i = size - 1; i > 0;i--){
            array[i] = array[i-1];
        }
        size--;
    }
    @Override
    public void set (int index, T element){
        checkIndex(index);
        array[index] = element;
    }
    @Override
    public void sort(){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (((Comparable<T>)array[i]).compareTo(array[j]) < 0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    @Override
    public int indexOf(Object o){
        for (int i = 0; i < size; i++) {
            if (array[i]==o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size; i >= 0; i--) {
            if (array[i]==object) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean exists(Object o){
        for (int i = 0; i < size; i++) {
            if (array[i]==o) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public Object[] toArray(){
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = array[i];
        }
        return array;
    }
    @Override
    public void clear(){
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}