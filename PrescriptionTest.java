import java.time.LocalDate;

/**
 * Description: Manual test for the Prescription class using Person-based Patient and Doctor.
 * Author: Brandon Maloney
 * Date: 2025-10-18
 */
public class PrescriptionTest {
    public static void main(String[] args) {
        // Create sample medication
        Medication med = new Medication(
                "M001",
                "Amoxicillin",
                "500mg",
                30,
                LocalDate.of(2024, 12, 31)
        );

        // Create patient and doctor
        Patient patient = new Patient(1, "John Doe", 35, "555-1234");
        Doctor doctor = new Doctor(1, "Dr. Smith", 45, "555-5678", "General Practitioner");
        doctor.addPatient(patient);

        // Create prescription
        Prescription prescription = new Prescription(
                "PR001",
                med,
                patient,
                doctor
        );

        // Display details
        System.out.println("Prescription Test");
        System.out.println("-----------------");
        System.out.println("Medication: " + med);
        System.out.println("Patient: " + patient);
        System.out.println("Doctor: " + doctor);
        System.out.println("Prescription Expiry: " + prescription.getPrescriptionExpiry());

        // Display full prescription
        System.out.println("\nPrescription toString():");
        System.out.println(prescription);

        // Update medication details
        med.setDose("250mg");
        med.setQuantityInStock(50);

        // Display updated info
        System.out.println("\nAfter Medication Update:");
        System.out.println("Updated Dose: " + med.getDose());
        System.out.println("Updated Quantity: " + med.getQuantityInStock());
    }
}
