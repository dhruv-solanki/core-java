package Generics;

public class GenericConstructor {
    Object data;

    public <T> GenericConstructor(T value) {
        this.data = value;
    }

    public Object getData() {
        return data;
    }
}
