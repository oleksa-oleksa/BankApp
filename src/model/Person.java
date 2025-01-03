package src.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String name;
    private int age;
    private String iban;
    private String address;
    private List<BankAccount> bankAccounts;


    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.bankAccounts = new ArrayList<>();
    }

    // Parameterized constructor
    public Person(String name, 
                  int age, 
                  String iban, 
                  String address,
                  List<BankAccount> bankAccounts) {
        this.name = name;
        this.age = age;
        this.iban = iban;
        this.address = address;
        this.bankAccounts = bankAccounts;
    }

    public void displayInfo() {
        System.out.println(String.format("I am %s, %d years old. My adress is %s.", 
                                                 name, age, address));
    }
    // Abstract method for role-specific information
    public abstract String getRole();

    // Add a bank account to the person
    public void addBankAccount(BankAccount account) {
        bankAccounts.add(account);
    }

    // Get all bank accounts
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
     this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    } 

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    } 

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    } 

}