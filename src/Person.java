package src;

class Person {
    protected String name;
    protected int age;
    protected String iban;
    protected double account_balance;
    protected String address;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized constructor
    public Person(String name, 
                  int age, 
                  String iban, 
                  double account_balance,
                  String address) {
        this.name = name;
        this.age = age;
        this.iban = iban;
        this.account_balance = account_balance;
        this.address = address;

    }

    public void displayInfo() {
        System.out.println(String.format("I am %s, %d years old. My adress is %s. Account status is: %.2f", 
                                                 name, age, address, account_balance));
    }
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    } 

}