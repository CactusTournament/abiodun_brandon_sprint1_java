import java.util.ArrayList;
import java.util.List;

/*
 * Model class representing a patient in the pharmacy system.
 * Stores patient properties (ID, name, age, phoneNumber).
 * This class extends the Person class.
 * 
 * Author: Abiodun Magret Oyedele
 * Date: 2024-10-18
 */
public class Patient extends Person {
    private final int patientID;

    public Patient(int ID, String name, int age, String phoneNumber) {
        super(ID, name, age, phoneNumber);
        this.patientID = ID;
    }

    public int getPatientID() {
        return patientID;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID=" + getID() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }
}
