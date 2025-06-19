package Threads.Executor;

public class LambdaExpression {
    public static void main(String[] args) {
//        we can assign lambda expression to functional interface's instance
//        functional interface means a interface that has only single abstract method
//        that means lambda expression (anonymous function) is given for method only
//        it is a implementation of that abstract method
        Runnable task1 = () -> {
            for(int i=0; i<5; i++) {
                System.out.println("Task1 count: " + (i+1));
            }
        };
        Thread t1 = new Thread(task1);
        t1.start();

        Thread t2 = new Thread(() -> System.out.println("I am task2"));
        t2.start();
    }
}
