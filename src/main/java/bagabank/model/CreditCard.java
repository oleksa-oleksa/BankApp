package bagabank.model;

import java.math.BigDecimal;

import bagabank.config.CardType;
import bagabank.exceptions.InsufficientFundsException;
import bagabank.exceptions.CreditLimitExceededException;

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
        this.currentCrediBalance = BigDecimal.ZERO; // Balance starts at 0
    }

    private boolean validateCreditLimit(BigDecimal amount) throws CreditLimitExceededException {
        try {
            if ((currentCrediBalance.add(amount)).compareTo(creditLimit) > 0) {
                throw new CreditLimitExceededException();
            }
            return true; // Validation succeeded
        } catch (CreditLimitExceededException e) {
            System.err.println("Validation failed: " + e.getMessage());
            return false; // Validation failed
        }
    }

    private void validateAccountStatement() throws InsufficientFundsException {
        if (getBankAccount().getAccountBalance().compareTo(currentCrediBalance) > 0) {
            throw new InsufficientFundsException();
        }
    }

    public void makePurchase(BigDecimal amount) throws CreditLimitExceededException {
      
        if (validateCreditLimit(amount)) { // This will throw an exception if validation fails.
                currentCrediBalance = currentCrediBalance.add(amount); // Only executed if validation passes.
                System.out.println(String.format("Purchase for %s succedded!", amount));
        }
        else { 
            System.err.println(String.format("Purchase for %s failed!", amount));
        }
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
    

    public BigDecimal getCurrentCrediBalance() {
        return currentCrediBalance;
    }

    public void displayCurrentCrediBalance() {
        if ((currentCrediBalance.compareTo(BigDecimal.ZERO)) == 0) {
            
            System.out.println(String.format("Credit card: %s. Current balance is %s. No credit obligations!", 
                                    getCardNumber(), currentCrediBalance));
        }
        else {
        System.out.println(String.format("Credit card: %s. Current balance is -%s.", 
                                    getCardNumber(), currentCrediBalance));
        }
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
