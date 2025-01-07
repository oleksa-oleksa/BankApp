package src.model;
import java.util.List;

import src.exceptions.InsufficientFundsException;

public class BankAccount {
    private String iban;
    private double accountBalance;
    private double accountMinimumBalance;
    private double creditCardLimit;
    private List<Card> cards;

    // Constructor
    public BankAccount(String iban, 
                       double initialBalance, 
                       double accountMinimumBalance, 
                       double creditCardLimit,
                       List<Card> cards) {
        this.iban = iban;
        this.accountBalance = initialBalance;
        this.accountMinimumBalance = accountMinimumBalance;
        this.creditCardLimit = creditCardLimit;
        this.cards = cards;
    }

    public void addCreditCard() {

    }    

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if ((accountBalance - amount) < accountMinimumBalance) {
            throw new InsufficientFundsException("Insufficient funds or exceeds account limit");
        }
        accountBalance -= amount;
    }

    public boolean payOffOwnCredit(double amount, String creditCard) throws InsufficientFundsException {
        if ((accountBalance - amount) < accountMinimumBalance) {
            throw new InsufficientFundsException();
        }
        accountBalance -= amount;
        return true;
    }

    // Add a card to this bank account
    public void addCard(Card card) {
        cards.add(card);
        card.setBankAccount(this); // Set the relationship
    }

    // Get all cards associated with this account
    public List<Card> getCards() {
        return cards;
    }

    public String getIban() {
        return iban;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getAccountMinimumBalance() {
        return accountMinimumBalance;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountMinimumBalance(double newAccountMinimumBalance) {
        this.accountMinimumBalance = newAccountMinimumBalance;
    }

    public double getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(double creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

}
