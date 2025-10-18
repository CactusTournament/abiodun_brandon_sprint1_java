import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private final int patientID;
    // private List<Medication> medications;
    // private List<Prescription> prescriptions;

    public Patient(int ID, String name, int age, String phoneNumber) {
        super(ID, name, age, phoneNumber);
        this.patientID = ID;
        // this.medications = new ArrayList<>();
        // this.prescriptions = new ArrayList<>();
    }

    // // Methods to manage medications and prescriptions
    // public void addMedication(Medication medication) {
    //     this.medications.add(medication);
    // }

    // public void removeMedication(Medication medication) {
    //     this.medications.remove(medication);
    // }

    // public void addPrescription(Prescription prescription) {
    //     this.prescriptions.add(prescription);
    // }

    // public void removePrescription(Prescription prescription) {
    //     this.prescriptions.remove(prescription);
    // }

    // // Getters
    // public List<Medication> getMedications() {
    //     return this.medications;
    // }

    // public List<Prescription> getPrescriptions() {
    //     return this.prescriptions;
    // }

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
                // ", medications=" + medications +
                // ", prescriptions=" + prescriptions +
                '}';
    }
}
