package src.model;

import src.config.CardType;
import src.exceptions.InsufficientFundsException;
import src.exceptions.CreditLimitExceededException;

public class CreditCard extends Card {
    private final CardType cardType = CardType.CREDIT_CARD;
    private String cardNumber;
    private double creditLimit;
    private double currentCrediBalance;
    private boolean HasOverdraft = false;
    private boolean isCreditPaid = false;

    public CreditCard(String cardNummer,
                      BankAccount bankAccount,
                      double creditLimit,
                      Person owner) {
        super(cardNummer, bankAccount);
        this.creditLimit = owner.getAccountType().getCreditLimit();;
        this.currentCrediBalance = 0.0; // Balance starts at 0
    }

    private void validateCreditLimit(double amount) throws CreditLimitExceededException{
        if (currentCrediBalance + amount > creditLimit) {
            throw new CreditLimitExceededException();
        }
    }

    private void validateAccountStatement() throws InsufficientFundsException {
        if (getBankAccount().getAccountBalance() > currentCrediBalance) {
            throw new InsufficientFundsException();
        }
    }

    public void makePurchase(double amount) throws CreditLimitExceededException{
        
        validateCreditLimit(amount); // This will throw an exception if validation fails.
        currentCrediBalance += amount; // Only executed if validation passes.
    }

    public boolean payOffMontlyCredit() throws InsufficientFundsException {
        boolean isPaid = false;
        if (currentCrediBalance > 0) {
            validateAccountStatement();
            // Attempt to pay off the credit balance through the associated bank account.
            isPaid = getBankAccount().payOffOwnCredit(currentCrediBalance, cardNumber);     
        }  
        if (isPaid) {
            currentCrediBalance = 0; // Reset credit balance after successful payment.
            this.isCreditPaid = true; // Mark credit as fully paid.
        }     
        return isPaid;
    }

    @Override
    public String getCardType() {
        return cardType.toString();
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getCurrentCrediBalance() {
        return currentCrediBalance;
    }

    public void setCurrentCrediBalance(double currentCrediBalance) {
        this.currentCrediBalance = currentCrediBalance;
    }

    public boolean getIsHasOverdraft() {
        return HasOverdraft;
    }

    public boolean getIsCreditPaid() {
        return isCreditPaid;
    }

    public void setHasOverdraft(boolean hasOverdraft) {
        HasOverdraft = hasOverdraft;
    }

    public void setCreditPaid(boolean isCreditPaid) {
        this.isCreditPaid = isCreditPaid;
    }    

}
