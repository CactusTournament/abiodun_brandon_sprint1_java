import java.util.ArrayList;
import java.util.List;

/**
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
    private final List<Prescription> prescriptions; // Added to track prescriptions

    /**
     * Constructor for the Patient class.
     * Initializes the patient with an ID, name, age, and phone number.
     * Also initializes an empty list of prescriptions.
     * @param ID          Unique identifier for the patient
     * @param name        Name of the patient
     * @param age         Age of the patient
     * @param phoneNumber Phone number of the patient
     */
    public Patient(int ID, String name, int age, String phoneNumber) {
        super(ID, name, age, phoneNumber);
        this.patientID = ID;
        this.prescriptions = new ArrayList<>();
    }

    /**
     * Getter for patient ID
     * @return patient ID
     */
    public int getPatientID() {
        return patientID;
    }

    // --- Prescription Management ---

    /**
     *  Adds a prescription to the patient’s record.
     * @param pres Prescription to be added
    */
    public void addPrescription(Prescription pres) {
        if (pres != null && !prescriptions.contains(pres)) {
            prescriptions.add(pres);
        }
    }


    /**
    * Getter for prescriptions
    * Returns a list of all prescriptions for this patient.
    */
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    /**
    * Prints all prescriptions for this patient.
    */
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

    /*
     * Overrides the toString method to provide a string representation of the patient.
     * @return string representation of the patient
     */
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
