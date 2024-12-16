package src.exceptions;

public class InsufficientFundsException extends Exception {
    private static final String ERROR_NOT_ENOUGH_MONEY = "Not enough money on bank account to proceed";

    public InsufficientFundsException() {
        super(ERROR_NOT_ENOUGH_MONEY);
    }
    
    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}