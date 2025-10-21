/*
 * Handles Person class testing.
 * 
 * Author: Abiodun Magret Oyedele
 * Date: 2024-10-21
 */

public class PersonTest {
    public static void main(String[] args) {
        // Create a person
        Person person = new Person(1, "Alice Johnson", 28, "555-4321");

        // Access person properties
        System.out.println("\n");
        System.out.println("_____Person Properties:______");
        System.out.println(person.getID());
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getPhoneNumber());

        // Modify person properties
        person.setName("Alice Smith");
        person.setAge(29);
        person.setPhoneNumber("555-9876");

        // Display updated person information
        System.out.println("\n\n");
        System.out.println("_____Updated Person Information:______");
        System.out.println(person);
        System.out.println("\n");
    }
}
