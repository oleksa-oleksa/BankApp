public class HelloPlayground {
    /*
     * Every Java program has at least one class. Here, the class name is HelloWorld.
     * public static void main(String[] args): This is the entry point of the program. 
     * Java programs start execution from the main method.
     * Java is case-sensitive.
     * Every statement ends with a semicolon ;
     * Code blocks are enclosed in {}.
     * 
     * Primitive Data Types:
     * byte: 1 byte, range: -128 to 127
     * short: 2 bytes, range: -32,768 to 32,767
     * int: 4 bytes, range: -2^31 to 2^31-1
     * long: 8 bytes, range: -2^63 to 2^63-1
     * float: 4 bytes, decimal numbers (e.g., 3.14f)
     * double: 8 bytes, more precise decimal numbers (e.g., 3.14159)
     * char: 2 bytes, a single character (e.g., 'A')
     * boolean: 1 bit, values are true or false

     */
    public static void main (String[] args) {
        int remainder = 10 % 3;
        int year = 2025;
        double hours = 1.5;
        int days = 5;
        String wish = "I wish to improve my programming skills. ";
        System.out.println("Hello World! Alexandra dives in Java Programming! " + wish + 
        "In next year " + year + " I gonna spend at least " + (hours * days) + 
        " hours per week to reach my goal!");
    }
}