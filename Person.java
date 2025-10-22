/*
 * This class represents a Person with attributes such as ID, name, age, and phone number.
 * It provides constructors, getters, setters, and a toString method for easy representation.
 * 
 * Author: Abiodun Magret Oyedele
 * Date: 2024-10-18
 */
public class Person {
    // Attributes
    private final int ID;
    private String name;
    private int age;
    private String phoneNumber;

    // Constructor
    public Person(int ID, String name, int age, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        } else {
            this.age = age;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString method
    @Override
    public String toString() {
        return "Person{" +
                "ID=" + this.ID +
                ", name='" + this.name + '\'' +
                ", age=" + this.age +
                ", phoneNumber='" + this.phoneNumber + '\'' +
                '}';
    }
}