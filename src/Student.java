package src;

public class Student extends Person {
    private String personType = "Student";
    private double accountLimit = 2000.0;

    
    public Student() {
        super(); // Calls the default constructor of the Person class
    }

    // Parameterized constructor
    public Student(String name, 
                    int age, 
                    String iban, 
                    double account_balance,
                    String address) {
        super(name, age, iban, account_balance, address); // Calls the parameterized constructor of the Person class
    }

}

