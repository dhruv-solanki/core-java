package ExceptionHandling;

public class BankAccount {
    private double totalAmount;

    public BankAccount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void withDraw(double amount) throws InsufficientBalanceException {
        if(totalAmount - amount < 0) {
            throw new InsufficientBalanceException();
        }
        System.out.println("Withdrew: " + amount);
        totalAmount -= amount;
        System.out.println("Now Balance: " + totalAmount);
    }
}
