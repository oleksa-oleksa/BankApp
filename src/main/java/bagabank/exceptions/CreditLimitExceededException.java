package bagabank.exceptions;

public class CreditLimitExceededException extends Exception {
    private static final String ERROR_CREDIT_LIMIT_EXCEEDED = "Purchase exceeds credit limit";

    public CreditLimitExceededException() {
        super(ERROR_CREDIT_LIMIT_EXCEEDED);
    }

    public CreditLimitExceededException(String message) {
        super(message);
    }

    public CreditLimitExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}