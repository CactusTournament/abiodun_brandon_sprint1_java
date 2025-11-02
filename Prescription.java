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

    /*
     * Constructor for the Prescription class.
     * Initializes the prescription with a medication, patient, doctor, dosage, and prescribed quantity.
     * Sets the prescription expiry date to one year from the current date.
     */
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

    /*
     * Getter for the ID of the prescription.
     * @return the ID of the prescription
     */
    public String getID() { return id; }

    /* Getter for the medication of the prescription.
     * @return the medication of the prescription
     */
    public Medication getMedication() { return medication; }

    /* Sets the medication for the prescription.
     * @param medication the new medication for the prescription
     */
    public void setMedication(Medication medication) { this.medication = medication; }

    /* Getter for the patient of the prescription.
     * @return the patient of the prescription
     */
    public Patient getPatient() { return patient; }

    /* Sets the patient for the prescription.
     * @param patient the new patient for the prescription
     */
    public void setPatient(Patient patient) { this.patient = patient; }

    /* Getter for the doctor of the prescription.
     * @return the doctor of the prescription
     */
    public Doctor getDoctor() { return doctor; }

    /* Sets the doctor for the prescription.
     * @param doctor the new doctor for the prescription
     */
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    /* Getter for the dosage of the prescription.
     * @return the dosage of the prescription
     */
    public String getDosage() { return dosage; }

    /* Sets the dosage for the prescription.
     * @param dosage the new dosage for the prescription
     */
    public void setDosage(String dosage) { this.dosage = dosage; }

    /* Getter for the prescribed quantity of the prescription.
     * @return the prescribed quantity of the prescription
     */ 
    public int getPrescribedQuantity() { return prescribedQuantity; }

    /* Sets the prescribed quantity for the prescription.
     * @param prescribedQuantity the new prescribed quantity for the prescription
     */
    public void setPrescribedQuantity(int prescribedQuantity) { this.prescribedQuantity = prescribedQuantity; }

    /* Getter for the prescription expiry date.
     * @return the prescription expiry date
     */
    public LocalDate getPrescriptionExpiry() { return prescriptionExpiry; }

    /* Sets the prescription expiry date.
     * @param prescriptionExpiry the new expiry date for the prescription
     */
    public void setPrescriptionExpiry(LocalDate prescriptionExpiry) { this.prescriptionExpiry = prescriptionExpiry; }

    /* Overrides the toString method to provide a string representation of the prescription.
     * @return string representation of the prescription
     */
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
