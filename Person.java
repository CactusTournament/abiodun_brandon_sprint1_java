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

    /*
    * Constructor for the Person class.
    * Initializes the person with an ID, name, age, and phone number.
    */
    public Person(int ID, String name, int age, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    /*
     * Getter for ID
     * @return ID of the person
     */
    public int getID() {
        return ID;
    }

    /*
     * Getter for name
     * @return name of the person
     */
    public String getName() {
        return name;
    }

    /*
     * Getter for age
     * @return age of the person
     */
    public int getAge() {
        return age;
    }

    /*
     * Getter for phone number
     * @return phone number of the person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /*
     * Setters for name properties
     * @param name        new name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Setter for age
     * @param age new age of the person
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        } else {
            this.age = age;
        }
    }

    /*
     * Setter for phone number
     * @param phoneNumber new phone number of the person
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*
     * Overrides the toString method to provide a string representation of the person.
     * @return string representation of the person
     */
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