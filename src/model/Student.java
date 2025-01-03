package src.model;

import src.config.CreditCardLimit;

public class Student extends Person {
    private final Role personRole = Role.STUDENT;
    private double accountLimit;

    public Student() {
        super(); // Calls the default constructor of the Person class
    }

    // Parameterized constructor
    public Student(String name,
            int age,
            String iban,
            double account_balance,
            String address) {
        super(name, age, iban, address); // Calls the parameterized constructor of the Person class
        this.accountLimit = CreditCardLimit.STUDENT_ACCOUNT_LIMIT; // Default limit
    }

    @Override
    public void displayInfo() {
        System.out.println(String.format("I am %s %s. Limit is set to %.2f",
                personRole, getName(), accountLimit));
    }

    @Override
    public String getRole() {
        return personRole.toString();
    }

    public double getAccountLimit() {
        return accountLimit;
    }

    public void increaseAccountLimit(double newLimit) {
        if (newLimit > accountLimit) {
            this.accountLimit = newLimit;
        } else {
            System.out.println("New limit must be higher than the current limit.");
        }
    }

    public void decreaseAccountLimit(double newLimit) {
        if (newLimit < accountLimit) {
            this.accountLimit = newLimit;
        } else {
            System.out.println("New limit must be lower than the current limit.");
        }
    }

}
