package ExceptionHandling;

public class InsufficientBalanceException extends Throwable {
    public InsufficientBalanceException() {
        super("Insufficient Balance");
    }
}
