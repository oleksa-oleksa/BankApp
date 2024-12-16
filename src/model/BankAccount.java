package src.model;

public class BankAccount {
    private String iban;
    private double accountBalance;
    private double accountLimit;
    private double creditCardLimit;

    // Constructor
    public BankAccount(String iban, double accountBalance, double accountLimit, double creditCardLimit) {
        this.iban = iban;
        this.accountBalance = accountBalance;
        this.accountLimit = accountLimit;
        this.creditCardLimit = creditCardLimit;
    }

    public void addCreditCard() {

    }    

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if ((accountBalance - amount) < accountLimit) {
            throw new IllegalArgumentException("Insufficient funds or exceeds account limit");
        }
        accountBalance -= amount;
    }

    public boolean payOffOwnCredit(double amount, String creditCard) throws IllegalArgumentException {
        if ((accountBalance - amount) < accountLimit) {
            throw new IllegalArgumentException("Insufficient funds or exceeds account limit");
        }
        accountBalance -= amount;
        return true;
    }

    public String getIban() {
        return iban;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getAccountLimit() {
        return accountLimit;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountLimit(double accountLimit) {
        this.accountLimit = accountLimit;
    }

    public double getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(double creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

}
