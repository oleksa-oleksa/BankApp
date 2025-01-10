package bagabank.model;

import bagabank.config.AccountType;
import bagabank.exceptions.CreditLimitExceededException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    private CreditCard creditCard;

    @BeforeEach
    void setUp() {
        // Setting up the test environment
        BankAccount bankAccount = new BankAccount("DE12345678901234567890", BigDecimal.TEN, AccountType.DEFAULT);
        Person person = new Person("Alice", 25, "Berliner Strasse 12", AccountType.DEFAULT);
        creditCard = new CreditCard("1234 5678 9101 1121", bankAccount, person);
    }

    @Test
    void testValidateCreditLimit_Success() throws CreditLimitExceededException {
        creditCard.setCurrentCrediBalance(new BigDecimal("500.00")); // Initial balance
        creditCard.setCreditLimit(new BigDecimal("2000.00")); // Set credit limit
    
        // Validation should succeed
        boolean result = creditCard.validateCreditLimit(new BigDecimal("1000.00"));
        assertTrue(result, "Expected validation to succeed for amount within credit limit");
        }

    @Test
    void testValidateCreditLimit_Failure() throws CreditLimitExceededException {
        creditCard.setCurrentCrediBalance(new BigDecimal("1500.00")); // Initial balance
        creditCard.setCreditLimit(new BigDecimal("2000.00")); // Set credit limit

        // Validation should fail
        boolean result = creditCard.validateCreditLimit(new BigDecimal("600.00"));
        assertFalse(result, "Expected validation to fail for amount exceeding credit limit");
    }

    @Test
    void testMakePurchase_Success() throws CreditLimitExceededException {
        creditCard.setCurrentCrediBalance(new BigDecimal("500.00")); // Initial balance
        creditCard.setCreditLimit(new BigDecimal("2000.00")); // Set credit limit

        // Attempt a purchase within the credit limit
        creditCard.makePurchase(new BigDecimal("1000.00"));

        // Verify the balance is updated
        assertEquals(new BigDecimal("1500.00"), creditCard.getCurrentCrediBalance(), "Balance should be updated after a successful purchase");
 
    }

    @Test
    void testMakePurchase_Failure() throws CreditLimitExceededException {
        creditCard.setCurrentCrediBalance(new BigDecimal("1500.00")); // Initial balance
        creditCard.setCreditLimit(new BigDecimal("2000.00")); // Set credit limit
    
        // Attempt a purchase exceeding the credit limit
        creditCard.makePurchase(new BigDecimal("600.00"));
    
        // Verify the balance is not updated
        assertEquals(new BigDecimal("1500.00"), creditCard.getCurrentCrediBalance(), "Balance should not be updated after a failed purchase");    
    }
}
