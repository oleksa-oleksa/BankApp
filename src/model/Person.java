package src.model;

import java.util.List;
import java.util.UUID;

import src.config.AccountType;

public abstract class Person {
    private final String id; // Unique ID for each person
    private String name;
    private int age;
    private String address;
    private List<BankAccount> bankAccounts;
    private AccountType accountType;


    // Parameterized constructor
    public Person(String name, 
                  int age, 
                  String address,
                  List<BankAccount> bankAccounts,
                  AccountType accountType) {

        this.id = UUID.randomUUID().toString(); // Generate a unique ID
        this.name = name;
        this.age = age;
        this.address = address;
        this.bankAccounts = bankAccounts;
        this.accountType = accountType;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    } 

    public String getId() {
        return id;
    }
    
}