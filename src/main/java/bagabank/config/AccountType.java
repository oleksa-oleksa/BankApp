package bagabank.config;

import java.math.BigDecimal;

public enum AccountType {
    DEFAULT(new BigDecimal("2000.00"), new BigDecimal("25.00")),
    STUDENT(new BigDecimal("1000.00"), new BigDecimal("10.00")),
    UNEMPLOYED(new BigDecimal("500.00"), new BigDecimal("5.00"));

    private final BigDecimal creditLimit;
    private final BigDecimal minimumBalance;

    AccountType(BigDecimal creditLimit, BigDecimal minimumBalance) {
        this.creditLimit = creditLimit;
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }
}
