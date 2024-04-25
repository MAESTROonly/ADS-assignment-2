package setofarraylists;

public class MyMinHeap<T> implements Mylist<T> {
    private Mylist<T> list;

    public MyMinHeap() {
        this.list = new Myarraylist<>();
    }

    @Override
    public void add(T item) {
        insert(item);
    }

    @Override
    public void add(int index, T item) {
        throw new UnsupportedOperationException("Method not supported for MinHeap");
    }

    @Override
    public void addFirst(T item) {
        throw new UnsupportedOperationException("Method not supported for MinHeap");
    }

    @Override
    public void addLast(T item) {
        insert(item);
    }

    private void insert(T item) {
        list.add(item);
        int currentIndex = list.size() - 1;
        bubbleUp(currentIndex);
    }

    private void bubbleUp(int index) {
        if (index <= 0) return;
        int parentIndex = (index - 1) / 2;
        if (compare(list.get(index), list.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int compare(T a, T b) {
        if (a instanceof Comparable && b instanceof Comparable) {
            @SuppressWarnings("unchecked")
            Comparable<T> comparableA = (Comparable<T>) a;
            return comparableA.compareTo(b);
        }
        throw new IllegalStateException("Objects must implement Comparable interface");
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public T getFirst() {
        return list.getFirst();
    }

    @Override
    public T getLast() {
        return list.getLast();
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException("Method not supported for MinHeap");
    }

    @Override
    public void removeFirst() {
        throw new UnsupportedOperationException("Method not supported for MinHeap");
    }

    @Override
    public void removeLast() {
        throw new UnsupportedOperationException("Method not supported for MinHeap");
    }

    @Override
    public void set(int index, T item) {
        throw new UnsupportedOperationException("Method not supported for MinHeap");
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Method not supported for MinHeap");
    }

    @Override
    public int indexOf(Object object) {
        return list.indexOf(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return list.lastIndexOf(object);
    }

    @Override
    public boolean exists(Object object) {
        return list.exists(object);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
