package Generics.Container;

public class GenericContainer<T> implements Container<T> {
    T item;

    @Override
    public void add(T value) {
        this.item = value;
    }

    @Override
    public T get() {
        return item;
    }
}
