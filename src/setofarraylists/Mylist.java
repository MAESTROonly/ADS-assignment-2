package setofarraylists;
public interface Mylist<T> extends Iterable<T> {
    void add(T item);
    void add(int index, T item);



    T get(int index);
    T getFirst();
    T getLast();

    void remove(int index);
    void removeFirst();
    void removeLast();

    void set(int index, T item);

    void sort();

    int indexOf(Object object);
    int lastIndexOf(Object object);

    boolean exists(Object object);

    int size();
    Object[] toArray();

    void clear();
}