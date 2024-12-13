package src.model;

public class Developer extends Person {
    private final Role personRole = Role.DEVELOPER;
    private double accountLimit = 2000.0;

    public Developer() {
        super(); // Calls the default constructor of the Person class
    }

    // Parameterized constructor
    public Developer(String name, 
                    int age, 
                    String iban, 
                    double account_balance,
                    String address) {
        super(name, age, iban, account_balance, address); // Calls the parameterized constructor of the Person class
    }

    @Override
    public void displayInfo() {
        System.out.println(String.format("I am %s %s. Account status is: %.2f, limit is set to %.2f", 
        personRole, getName(), getAccountBalance(), accountLimit));
    }

    @Override
    public String getRole() {
        return personRole.toString();


    }

}

