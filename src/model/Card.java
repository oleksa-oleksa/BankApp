package src.model;

public abstract class Card {
    private String cardNumber;
    private BankAccount bankAccount;  // Association to BankAccount

    public Card(String cardNumber, BankAccount bankAccount) {
        this.cardNumber = cardNumber;
        this.bankAccount = bankAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    // Abstract method to get the card type
    public abstract String getCardType();    
    
}
