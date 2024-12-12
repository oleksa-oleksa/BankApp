package src;

class Person {
    private String name;
    private int age;
    private String iban;
    private double account_balance;
    private double amount;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // The keyword this refers to the current instance of the class (i.e., the object).
        // In a setter method, you're typically receiving a parameter (local variable)
        // that has the same name as an instance variable. To differentiate between
        //  the instance variable (field) and the parameter, you use this.
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

    public double getAccountBalance() {
        return account_balance;
    }

    public void SetAccountBalance(double account_balance) {
        this.account_balance = account_balance;
    } 

    public double getAmount() {
        return amount;
    }

    public void SetAmount(double amount) {
        this.amount = amount;
    } 

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    } 

}