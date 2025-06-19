import java.util.Scanner;

public class Main {
  public static void stringExample() {
//    String literal are stored in special memory called string pool
//    that is located inside the heap memory
//    So when we assign Ram for first time it will be stored in string pool
//    and program uses its reference to point to it
    String name = "Ram";
    String a = new String(name);
    String b = new String(name);

    String c = "Ram";
    String d = "Ram";

//    here we are checking if both a and b point to same memory location: false
//    because objects are stored in heap memory so both are different
    System.out.println(a == b);
//    but here c and d points to same memory location stored in string pool: true
    System.out.println(c == d);

//    String is immutable we can't change it, once initialised
//    so each time on doing any operation it will create new string
//    that can create a lots of overhead if we have to do string manipulations

//    StringBuffer: it mutable String class
//    Use it when you have to do lots of string manipulation operations
//    It is not synchronised
    StringBuffer sb = new StringBuffer("Hello");
    sb.append(" World");
    System.out.println(sb);

//    StringBuilder: it is also mutable String class
//    but it is thread safe so use it in multithreaded environment
    StringBuilder sbl = new StringBuilder("Good");
    sbl.append(" Morning");
    sbl.reverse();
    System.out.println(sbl);
  }

  public static void runExamples() {
    System.out.println("Hello World!");

    String firstName = "Dhruv";
    String lastName = "Solanki";

    System.out.println(firstName + " " + lastName);

    int num1 = 5;
    int num2 = 10;

    System.out.println(num1 + num2);

    String name = null;
    System.out.println(name);

    System.out.println(factorial(10));

//    singleton class demo, basically we can only create one instance of a class
    Singleton instance1 = Singleton.getInstance();
    System.out.println(instance1);

    Singleton instance2 = Singleton.getInstance();
    System.out.println(instance2);

    Scanner in = new Scanner(System.in);
    System.out.print("Enter an int: ");
    int number = in.nextInt();
    System.out.println("You entered: " + number);
  }

  public static void main(String[] args) {
//    stringExample();
    System.out.println("Sum of var arg: " + sum(1, 2));
    System.out.println("Sum of var arg: " + sum(1, 2, 3, 4));
  }

  public static int factorial(int n) {
    if(n == 1) return 1;
    return n * factorial(n - 1);
  }

//  we can accept variable number of arguments by using 3 dots
  public static int sum(int ...arr) {
    int sum = 0;
    for(int n: arr) {
      sum += n;
    }
    return sum;
  }
}