package setofarraylists;

import java.util.Iterator;

public class MyLinkedList<T> implements Mylist<T> {
    private Node<T> head;

    private Node<T> tail;
    private int size;


    public MyLinkedList(){

    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node<T> nodeToInsert = new Node<>(item);
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            Node<T> prevNode = currentNode.getPrev();

            prevNode.setNext(nodeToInsert);
            nodeToInsert.setPrev(prevNode);

            nodeToInsert.setNext(currentNode);
            currentNode.setPrev(nodeToInsert);
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        if(head == null){
            head = node;
            tail = node;
        } else {
            Node<T> prevHead = head;
            node.setNext(prevHead);
            head.setPrev(node);
            head = head.getPrev();
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if(head == null){
            addFirst(item);
        } else{
            Node<T> nodeToInsert = new Node<>(item);
            tail.setNext(nodeToInsert);
            nodeToInsert.setPrev(tail);
            tail = nodeToInsert;
            size++;
        }

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        Node<T> node = head;
        for(int i=0;i<index;i++){
            node = node.getNext();
        }
        return node.getValue();
    }

    @Override
    public T getFirst() {
        checkIndex(0);
        return head.getValue();
    }

    @Override
    public T getLast() {
        checkIndex(size-1);
        return tail.getValue();
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        Node<T> node = head;
        for(int i=0;i<index;i++){
            node = node.getNext();
        }
        Node<T> prevNode = node.getPrev();
        Node<T> nextNode = node.getNext();
        node.setNext(null);
        node.setPrev(null);
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        size--;
    }

    @Override
    public void removeFirst() {
        checkIndex(0);
        head = head.getNext();
        head.setPrev(null);
        size--;
    }

    @Override
    public void removeLast() {
        checkIndex(size-1);
        Node<T> prevNode = tail.getPrev();
        tail.setPrev(null);
        if(prevNode != null) {
            prevNode.setNext(null);
        } else{
            head = null;
        }
        tail = prevNode;
        size--;
    }

    @Override
    public void sort() {
        Object[] arr = toArray();
        quickSort(arr,0, arr.length-1);
        toLinkedList(arr);

    }
    private void quickSort(Object[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Object[] arr, int low, int high) {
        T pivot = (T) arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (get(j).compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public int indexOf(Object obj) {
        Node<T> node = head;
        for(int i=0;i<size;i++){
            if(node.getValue().equals(obj)){
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        Node<T> node = tail;
        for(int i=0;i<size;i++){
            if(node.getValue().equals(obj))
                return i;
            node = node.getPrev();
        }
        return -1;
    }

    @Override
    public boolean exists(Object obj) {
        Node<T> node = head;
        for(int i=0;i<size;i++){
            if(node.getValue().equals(obj))
                return true;
            node = node.getNext();
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        Node<T> node = head;
        for(int i=0;i<size;i++){
            newArray[i] = node.getValue();
            node = node.getNext();
        }
        return newArray;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;

    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        Node<T> node = head;
        for(int i=0;i<index;i++){
            node = node.getNext();
        }
        node.setValue(item);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index out of range");
        }
    }


    public void print(){
        Node<T> node = head;
        while(node != null){
            System.out.printf("%s ", node.getValue());
            node = node.getNext();
        }
        System.out.println();
    }
    public void printReverse(){
        Node<T> node = tail;
        for(int i=0;i<size;i++){
            System.out.printf("%s ", node.getValue());
            node = node.getPrev();
        }
        System.out.println();
    }

    private void toLinkedList(Object[] arr){
        Node<T> node = new Node<>((T) arr[0]);
        head = node;
        for(int i=1;i<arr.length;i++){
            node.setNext(new Node<>((T) arr[i]));
            node = node.getNext();
        }

    }
}
