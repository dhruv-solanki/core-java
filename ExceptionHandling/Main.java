package ExceptionHandling;

// An exception is an event that disrupts the normal execution of a program.
// It’s an object that describes an error condition
// and is thrown by a method or the Java Virtual Machine (JVM).

// 1. Checked Exceptions
// Known at compile time
// Must be either caught or declared

// Examples:
// IOException
// FileNotFoundException

// 2. Unchecked Exceptions (Runtime Exceptions)
// Occur during runtime
// Not required to be declared or caught

// Examples:
// NullPointerException
// ArrayIndexOutOfBoundsException
// ArithmeticException

// 3. Errors
// Serious problems not meant to be caught or handled
// Related to system failures or resource exhaustion

// Examples:
// OutOfMemoryError
// StackOverflowError

// try	        Defines a block of code to be tested for exceptions
// catch	    Defines a block of code to handle exceptions
// finally	    Block that executes after try-catch (optional), regardless of outcome
// throw	    Used to explicitly throw an exception
// throws	    Declares exceptions a method might throw

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        try {
            account.withDraw(500);
            account.withDraw(5000);
        } catch(InsufficientBalanceException e) {
            System.out.println(e);
        }
    }

    public static void check() {
        int[] nums = {10, 100, 200, 300, 400, 500};
        int[] dividers = {10, 22, 33, 44, 0, 60};

        for(int i=0; i<nums.length; i++) {
            System.out.println(divide(nums[i], dividers[i]));
        }

        System.out.println("Good Job!");
    }

    public static int divide(int a, int b) {
        try {
            return (a / b);
        } catch(ArithmeticException e) {
            System.out.println(e);
            return -1;
        }
    }
}
