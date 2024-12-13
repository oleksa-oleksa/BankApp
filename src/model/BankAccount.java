package src.model;

public class BankAccount {
    private String iban;
    private double accountBalance;
    private double accountLimit;
    private double creditCardLimit;

    private Card creditCard;
    private Card debitCard;


    // Constructor
    public BankAccount(String iban, double accountBalance, double accountLimit, double creditCardLimit) {
        this.iban = iban;
        this.accountBalance = accountBalance;
        this.accountLimit = accountLimit;
        this.creditCardLimit = creditCardLimit;
        this.creditCard = null;
        this.debitCard = null;
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

    public void payOffOwnCredit(double amount, String cardNumber) throws IllegalArgumentException {
        if ((accountBalance - amount) < accountLimit) {
            throw new IllegalArgumentException("Insufficient funds or exceeds account limit");
        }
        accountBalance -= amount;
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
