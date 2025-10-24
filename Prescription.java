import java.time.LocalDate;

/**
 * Represents a prescription in the pharmacy system.
 * Contains a reference to a medication, the patient, and the prescribing doctor.
 * Tracks dosage and quantity prescribed.
 *
 * Author: Brandon Maloney
 * Updated by: Abiodun Magret Oyedele
 * Date: 2025-10-22
 */
public class Prescription {
    private final String id;               
    private Medication medication;   
    private Patient patient;         
    private Doctor doctor;           
    private String dosage;           
    private int prescribedQuantity;  
    private LocalDate prescriptionExpiry;  
    private static int nextID = 1;
    private final int prescriptionID;

    // Constructor
    public Prescription(Patient patient, Doctor doctor, Medication medication, String dosage, int prescribedQuantity) {
        this.prescriptionID = nextID++;
        this.id = "RX" + prescriptionID;
        this.medication = medication;
        this.patient = patient;
        this.doctor = doctor;
        this.dosage = dosage;
        this.prescribedQuantity = prescribedQuantity;
        this.prescriptionExpiry = LocalDate.now().plusYears(1);
    }

    // Getters and Setters
    public String getID() { return id; }

    public Medication getMedication() { return medication; }
    public void setMedication(Medication medication) { this.medication = medication; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }

    public int getPrescribedQuantity() { return prescribedQuantity; }
    public void setPrescribedQuantity(int prescribedQuantity) { this.prescribedQuantity = prescribedQuantity; }

    public LocalDate getPrescriptionExpiry() { return prescriptionExpiry; }
    public void setPrescriptionExpiry(LocalDate prescriptionExpiry) { this.prescriptionExpiry = prescriptionExpiry; }

    @Override
    public String toString() {
        return "Prescription ID = " + id +
            ", Medication = " + (medication != null ? medication.getName() : "N/A") +
            ", Patient = " + (patient != null ? patient.getName() + " (ID=" + patient.getPatientID() + ")" : "N/A") +
            ", Doctor = " + (doctor != null ? doctor.getName() + " (ID=" + doctor.getID() + ")" : "N/A") +
            ", Dosage = " + dosage +
            ", Quantity = " + prescribedQuantity +
            ", Expiry = " + prescriptionExpiry;
    }

}
