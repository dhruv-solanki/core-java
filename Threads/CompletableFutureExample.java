package Threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
//        we can use this to run async operation
//        we are providing anonymous function that will execute as async
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
           try {
               System.out.println("Async started!");
               Thread.sleep(3000);
               System.out.println("Async completed!");
           } catch(InterruptedException e) {
               System.out.println(e);
           }
           return "Yes";
        });
        String s = null;
        try {
//            we are waiting for operation to complete and get the result provided by thread
            s = completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        System.out.println(s);
        System.out.println("Main Thread completed!");

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Async started from f1!");
                Thread.sleep(3000);
                System.out.println("Async completed from f1!");
            } catch(InterruptedException e) {
                System.out.println(e);
            }
            return "Yes";
        });
        CompletableFuture<Void> f = CompletableFuture.allOf(completableFuture, f1);
        f.join();
        System.out.println("Multiple async done!");
    }
}
