package setofarraylists;
import java.util.Iterator;
public class MyQueue<T> implements Mylist<T> {
    private Mylist<T> list;

    public MyQueue() {
        list = new Myarraylist<>();
    }

    @Override
    public void add(T item) {
        list.addLast(item);
    }

    @Override
    public void add(int index, T item) {
        list.add(index, item);
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
        list.remove(index);
    }

    @Override
    public void removeFirst() {
        list.removeFirst();
    }

    @Override
    public void removeLast() {
        list.removeLast();
    }

    @Override
    public void set(int index, T item) {
        list.set(index, item);
    }

    @Override
    public void sort() {
        list.sort();
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
