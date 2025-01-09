package src.app;

import src.model.Person;
import src.model.BankAccount;
import src.model.CreditCard;
import src.service.PersonService;

import java.math.BigDecimal;

import src.config.AccountType;
import src.exceptions.CreditLimitExceededException;

public class Main {
    public static void main(String[] args) throws CreditLimitExceededException {
        // Initialize objects
        Person person = new Person("Alice", 25, "Berliner Strasse 12", AccountType.DEFAULT);
        BankAccount bankAccount = new BankAccount("DE12345678901234567890", BigDecimal.TEN, AccountType.DEFAULT);
        CreditCard card = new CreditCard("4293 1891 0000 0008", bankAccount, person);

        // Using services for business logic
        PersonService personService = new PersonService();
        personService.registerPerson(person);
        personService.assignBankAccountToPerson(person, bankAccount);
        personService.assignCardToBankAccount(bankAccount, card);

        // Create relationships
        bankAccount.setOwner(person);
        person.addBankAccount(bankAccount);

        // Display person details
        System.out.println("Person ID: " + person.getId());
        System.out.println("Account Balance: " + bankAccount.getAccountBalance());

        card.makePurchase(new BigDecimal("1000.00"));
        
        card.makePurchase(new BigDecimal("1200.00"));   
    }        
}
