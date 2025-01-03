package src.model;

import src.config.CreditCardLimit;
import src.config.AccountMinimumBalance;

public class Student extends Person {
    private final Role personRole = Role.STUDENT;
    private double accountMinimumBalance;
    private double creditCardLimit;

    public Student() {
        super(); // Calls the default constructor of the Person class
    }

    // Parameterized constructor
    public Student(String name,
            int age,
            String iban,
            String address) {
        super(name, age, iban, address); // Calls the parameterized constructor of the Person class
        this.accountMinimumBalance = CreditCardLimit.STUDENT_CREDIT_LIMIT; // Default limit
        this.creditCardLimit = AccountMinimumBalance.STUDENT_MINIMUM_BALANCE;
    }

    @Override
    public void displayInfo() {
        System.out.println(String.format("I am %s %s.",
                personRole, getName()));
    }

    @Override
    public String getRole() {
        return personRole.toString();
    }

    public Role getPersonRole() {
        return personRole;
    }

    public double getAccountMinimumBalance() {
        return accountMinimumBalance;
    }

    public void setAccountMinimumBalance(double accountMinimumBalance) {
        this.accountMinimumBalance = accountMinimumBalance;
    }

    public double getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(double creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

}
