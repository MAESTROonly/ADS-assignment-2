package setofarraylists;
import java.util.Iterator;
public class MyStack<T> implements Mylist<T> {
    private Mylist<T> list;

    public MyStack() {
        list = new Myarraylist<>();
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void add(int index, T item) {
        throw new UnsupportedOperationException("Method not supported for Stack");
    }

    @Override
    public void addFirst(T item) {
        list.addFirst(item);
    }

    @Override
    public void addLast(T item) {
        list.addLast(item);
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
        throw new UnsupportedOperationException("Method not supported for Stack");
    }

    @Override
    public void removeFirst() {
        list.removeFirst();
    }

    @Override
    public void removeLast() {
        throw new UnsupportedOperationException("Method not supported for Stack");
    }

    @Override
    public void set(int index, T item) {
        list.set(index, item);
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Method not supported for Stack");
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
