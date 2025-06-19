public class Singleton {
    private static Singleton instance;

//    private constructor so that no one can create
//    object of this class
    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
