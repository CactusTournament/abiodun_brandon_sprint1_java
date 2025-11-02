import java.util.ArrayList;
import java.util.List;

/*
 * Model class representing a doctor in the pharmacy system.
 * Stores doctor properties (ID, name, age, phoneNumber, specialization).
 * This class extends the Person class.
 * 
 * Author: Abiodun Magret Oyedele
 * Date: 2024-10-18
 */
public class Doctor extends Person {
    // Attributes
    private String specialization;
    private List<Patient> patients;

    /*
     * Constructor for the Doctor class.
     * Initializes the doctor with an ID, name, age, phone number, and specialization.
     * Also initializes an empty list of patients.
     */
    public Doctor(int ID, String name, int age, String phoneNumber, String specialization) {
        super(ID, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    /*
     * Getter for specialization
     * @return specialization of the doctor
     */
    public String getSpecialization() {
        return specialization;
    }

    /*
     * Setter for specialization
     * @param specialization new specialization of the doctor
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /*
     * Method to add a patient to the doctor's list of patients.
     * @param patient the patient to be added
     */
    public void addPatient(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            System.out.println("Patient " + patient.getName() + " added to Doctor " + getName() + "'s list.");
        } else {
            System.out.println("Patient already assigned to Doctor " + getName() + ".");    
        }
    }

    /*
     * Method to remove a patient from the doctor's list of patients.
     * @param patient the patient to be removed
     */
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    /*
     * Getter for the list of patients
     * @return list of patients assigned to the doctor
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /*
     * Overridden toString method to provide a string representation of the Doctor object.
     * @return string representation of the Doctor
     */
    @Override
    public String toString() {
        return "Doctor{" +
                "ID=" + getID() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", patients=" + patients.stream() // Takes the patients list (which contains Patient objects) // Converts it into a stream (a way to process elements one by one).
                                        .map(Patient::getName) // Calls the getName() method on each Patient — that’s what .map(Patient::getName) means.
                                        .toList() + // Collects all those names into a List of Strings with .toList().
                '}';
    }
}
