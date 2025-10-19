import java.time.LocalDate;

/**
 * Represents a prescription in the pharmacy system.
 * Contains a reference to a medication, the patient, and the prescribing doctor.
 *
 * Author: Brandon Maloney
 * Date: 2025-10-18
 */
public class Prescription {
    private String id;               
    private Medication medication;   
    private Patient patient;         
    private Doctor doctor;           
    private LocalDate prescriptionExpiry;  

    // Constructor
    public Prescription(String id, Medication medication, Patient patient, Doctor doctor) {
        this.id = id;
        this.medication = medication;
        this.patient = patient;
        this.doctor = doctor;
        this.prescriptionExpiry = LocalDate.now().plusYears(1); 
    }

    // Getters and Setters
    public String getID() { return id; }
    public void setID(String id) { this.id = id; }

    public Medication getMedication() { return medication; }
    public void setMedication(Medication medication) { this.medication = medication; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public LocalDate getPrescriptionExpiry() { return prescriptionExpiry; }
    public void setPrescriptionExpiry(LocalDate prescriptionExpiry) { this.prescriptionExpiry = prescriptionExpiry; }

    @Override
    public String toString() {
        return "Prescription ID = " + id +
            ", Medication = [" + medication + "]" +
            ", Patient = " + (patient != null ? patient.getName() + " (ID=" + patient.getPatientID() + ")" : "N/A") +
            ", Doctor = " + (doctor != null ? doctor.getName() + " (ID=" + doctor.getID() + ")" : "N/A") +
            ", Expiry = " + prescriptionExpiry;
    }
}
