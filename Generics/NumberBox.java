package Generics;

// bounded types
// extends class & interface & interface ...
public class NumberBox<N extends Number> {
    private N data;

    public N getData() {
        return data;
    }

    public void setData(N data) {
        this.data = data;
    }
}
