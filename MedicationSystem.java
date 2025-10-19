import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the medication management system.
 * Handles adding and viewing medications, patients, doctors, and prescriptions.
 * 
 * Author: Brandon Maloney
 * Date: 2025-10-19
 */
public class MedicationSystem {

    // Make lists private 
    private List<Medication> medications;
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Prescription> prescriptions;

    // Constructor
    public MedicationSystem() {
        medications = new ArrayList<>();
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        prescriptions = new ArrayList<>();
    }

    // Add a medication to the system
    public void addMedication(Medication medication) {
        if (medication != null) {
            medications.add(medication);
            System.out.println("Added medication: " + medication.getName());
        }
    }

    // Display all medications
    public void viewMedications() {
        System.out.println("\n--- Medication List ---");
        if (medications.isEmpty()) {
            System.out.println("No medications found.");
        } else {
            for (Medication med : medications) {
                System.out.println(med);
            }
        }
    }

    // Test 
    public static void main(String[] args) {
        MedicationSystem system = new MedicationSystem();

        system.addMedication(new Medication("M001", "Amoxicillin", "500mg", 30, LocalDate.of(2024, 12, 31)));
        system.addMedication(new Medication("M002", "Ibuprofen", "200mg", 50, LocalDate.of(2025, 6, 15)));

        system.viewMedications();
    }

// TODO: Implement method to remove a medication by ID or name

// TODO: Implement method to edit medication details (dose, quantity, etc.)

// TODO: Add search functionality (find by ID or name)

// TODO: Add method to check and list expired medications

// TODO: Add restock functionality (random or specific number)

// TODO: Connect MedicationSystem to Prescription and Patient classes

// TODO: Generate medication report for all stored medications

}
