package src.model;

import java.math.BigDecimal;

import src.config.CardType;
import src.exceptions.InsufficientFundsException;
import src.exceptions.CreditLimitExceededException;

public class CreditCard extends Card {
    private final CardType cardType = CardType.CREDIT_CARD;
    private String cardNumber;
    private BankAccount bankAccount;
    private BigDecimal creditLimit;
    private BigDecimal currentCrediBalance;
    private boolean HasOverdraft = false;
    private boolean isCreditPaid = false;

    public CreditCard(String cardNummer,
                      BankAccount bankAccount,
                      Person owner) {
        super(cardNummer, bankAccount);
        this.creditLimit = owner.getAccountType().getCreditLimit();;
        this.currentCrediBalance = new BigDecimal("0.0"); // Balance starts at 0
    }

    private void validateCreditLimit(BigDecimal amount) throws CreditLimitExceededException{
        //if (currentCrediBalance + amount > creditLimit)
        // -1, 0, or 1 as this BigDecimal is numerically less than, equal to, or greater than val.
        if ((currentCrediBalance.add(amount)).compareTo(creditLimit) > 0) {
            throw new CreditLimitExceededException();
        }
    }

    private void validateAccountStatement() throws InsufficientFundsException {
        if (getBankAccount().getAccountBalance().compareTo(currentCrediBalance) > 0) {
            throw new InsufficientFundsException();
        }
    }

    public void makePurchase(BigDecimal amount) throws CreditLimitExceededException{
        validateCreditLimit(amount); // This will throw an exception if validation fails.
        currentCrediBalance = currentCrediBalance.add(amount); // Only executed if validation passes.
    }

    public boolean payOffMontlyCredit() throws InsufficientFundsException {
        boolean isPaid = false;
        if (currentCrediBalance.compareTo(BigDecimal.ZERO) > 0) {
            validateAccountStatement();
            // Attempt to pay off the credit balance through the associated bank account.
            isPaid = getBankAccount().payOffOwnCredit(currentCrediBalance, cardNumber);     
        }  
        if (isPaid) {
            currentCrediBalance = BigDecimal.ZERO; // Reset credit balance after successful payment.
            this.isCreditPaid = true; // Mark credit as fully paid.
        }     
        return isPaid;
    }

    @Override
    public String getCardType() {
        return cardType.toString();
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getCurrentCrediBalance() {
        return currentCrediBalance;
    }

    public void setCurrentCrediBalance(BigDecimal currentCrediBalance) {
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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isHasOverdraft() {
        return HasOverdraft;
    }    

}
