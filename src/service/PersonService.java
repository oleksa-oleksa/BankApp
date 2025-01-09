
package src.service;
import java.util.HashMap;
import java.util.Map;
import src.model.BankAccount;
import src.model.Person;
import src.model.CreditCard;

public class PersonService {
    private Map<String, Person> personMap = new HashMap<>(); // Keyed by Person ID
    private Map<String, BankAccount> accountMap = new HashMap<>(); // Keyed by IBAN
    private Map<String, CreditCard> cardMap = new HashMap<>(); // Keyed by Card Number

    public void registerPerson(Person person) {
        personMap.put(person.getId(), person);
    }

    public void assignBankAccountToPerson(Person person, BankAccount account) {
        person.addBankAccount(account);
        accountMap.put(account.getIban(), account);
    }

    public void assignCardToBankAccount(BankAccount account, CreditCard card) {
        account.addCard(card);
        cardMap.put(card.getCardNumber(), card);
    }

    public Person findOwnerByCardNumber(String cardNumber) {
        CreditCard card = cardMap.get(cardNumber);
        for (Person person : personMap.values()) {
            for (BankAccount account : person.getBankAccounts()) {
                if (account.getCards().contains(card)) {
                    return person;
                }
            }
        }
        return null; // Not found
    }
}
