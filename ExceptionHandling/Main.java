package ExceptionHandling;

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
