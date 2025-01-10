package src.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import src.config.AccountType;
import src.exceptions.InsufficientFundsException;

public class BankAccount {
    private String iban;
    private BigDecimal accountBalance;
    private BigDecimal accountMinimumBalance;
    private List<Card> cards;
    private Person owner; // Initially null
    private AccountType accountType; // Keep a reference to the account type

    // Constructor
    public BankAccount(String iban, 
                       BigDecimal initialBalance,
                       AccountType accountType) {
        this.iban = iban;
        this.accountBalance = initialBalance;
        this.accountType = accountType;
        this.accountMinimumBalance = accountType.getMinimumBalance();
        this.cards = new ArrayList<>();
    }

    public void addCreditCard() {

    }    

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void deposit(BigDecimal amount) {
        accountBalance = accountBalance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        // compareTo returns -1(less than), 0(Equal), 1(greater than) according to values. 
        if ((accountBalance.subtract(amount)).compareTo(accountMinimumBalance) < 0) {
            throw new InsufficientFundsException("Insufficient funds or exceeds account limit");
        }
        accountBalance = accountBalance.subtract(amount);
    }


    public boolean payOffOwnCredit(BigDecimal amount, String creditCard) throws InsufficientFundsException {
        if ((accountBalance.subtract(amount)).compareTo(accountMinimumBalance) < 0) {
            throw new InsufficientFundsException();
        }
        accountBalance.subtract(amount);
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

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public BigDecimal getAccountMinimumBalance() {
        return accountMinimumBalance;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountMinimumBalance(BigDecimal newAccountMinimumBalance) {
        this.accountMinimumBalance = newAccountMinimumBalance;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Person getOwner() {
        return owner;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    } 
      
}
