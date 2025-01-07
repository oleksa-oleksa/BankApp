package src.config;

public enum AccountType {
    DEFAULT(2000.0, 25.0),
    STUDENT(1000.0, 10.0),
    UNEMPLOYED(500.0, 5.0);

    private final double creditLimit;
    private final double minimumBalance;

    AccountType(double creditLimit, double minimumBalance) {
        this.creditLimit = creditLimit;
        this.minimumBalance = minimumBalance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }
}
