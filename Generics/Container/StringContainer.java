package Generics.Container;

public class StringContainer implements Container<String> {
    String item;

    @Override
    public void add(String value) {
        this.item = value;
    }

    @Override
    public String get() {
        return item;
    }
}
