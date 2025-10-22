import java.util.ArrayList;
import java.util.List;

/*
 * Model class representing a patient in the pharmacy system.
 * Stores patient properties (ID, name, age, phoneNumber) 
 * and their list of prescriptions.
 * This class extends the Person class.
 * 
 * Author: Abiodun Magret Oyedele
 * Updated by: Brandon Maloney
 * Date: 2025-10-21
 */
public class Patient extends Person {
    private final int patientID;
    private List<Prescription> prescriptions; // Added to track prescriptions

    public Patient(int ID, String name, int age, String phoneNumber) {
        super(ID, name, age, phoneNumber);
        this.patientID = ID;
        this.prescriptions = new ArrayList<>();
    }

    public int getPatientID() {
        return patientID;
    }

    // --- Prescription Management ---

    /** Adds a prescription to the patient’s record. */
    public void addPrescription(Prescription prescription) {
        if (prescription != null) {
            prescriptions.add(prescription);
        }
    }

    /** Returns a list of all prescriptions for this patient. */
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /** Prints all prescriptions for this patient. */
    public void printPrescriptions() {
        System.out.println("\nPrescriptions for " + getName() + ":");
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions found.");
        } else {
            for (Prescription p : prescriptions) {
                System.out.println(p);
            }
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID=" + getID() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", totalPrescriptions=" + prescriptions.size() +
                '}';
    }
}
