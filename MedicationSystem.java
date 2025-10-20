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


    // Add a medication object directly
    public void addMedication(Medication medication) {
        if (medication == null) {
            System.out.println("Cannot add null medication.");
            return;
        }

        // Check for duplicates by ID
        for (Medication existing : medications) {
            if (existing.getID().equalsIgnoreCase(medication.getID())) {
                System.out.println("Medication with ID " + medication.getID() + " already exists.");
                return;
            }
        }

        medications.add(medication);
        System.out.println("Added medication: " + medication.getName());
    }

    // Overload: Add by details (used for Scanner input later)
    public void addMedication(String id, String name, String dosage, int quantity, LocalDate expiryDate) {
        if (id == null || name == null || dosage == null || expiryDate == null) {
            System.out.println("Invalid medication details provided.");
            return;
        }

        Medication newMed = new Medication(id, name, dosage, quantity, expiryDate);
        addMedication(newMed); // Delegate to main method
    }

    // Optional: Add by ID or name (could later load a predefined template)
    public void addMedication(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            System.out.println("Invalid identifier.");
            return;
        }

        // Future placeholder (maybe load from database or predefined catalog)
        System.out.println("Feature not implemented yet: add medication by identifier only (" + identifier + ")");
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




    // Remove by identifier (ID or name)
    public void removeMedication(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            System.out.println("Invalid medication identifier.");
            return;
        }

        for (int i = 0; i < medications.size(); i++) {
            Medication med = medications.get(i);
            if (med.getID().equalsIgnoreCase(identifier) || med.getName().equalsIgnoreCase(identifier)) {
                medications.remove(i);
                System.out.println("Removed medication: " + med.getName() + " (ID: " + med.getID() + ")");
                return;
            }
        }

        System.out.println("No medication found with ID or name: " + identifier);
    }

    // Overload: remove by Medication object
    public void removeMedication(Medication medication) {
        if (medication == null) {
            System.out.println("Invalid medication reference.");
            return;
        }
        removeMedication(medication.getID());
    }

    


    // Edit by identifier or name
    public void editMedication(String identifier, String newDosage, Integer newQuantity, LocalDate newExpiryDate) {
        if (identifier == null || identifier.isEmpty()) {
            System.out.println("Invalid medication identifier.");
            return;
        }

        boolean updatedAny = false;

        for (Medication med : medications) {
            if (med.getID().equalsIgnoreCase(identifier) || med.getName().equalsIgnoreCase(identifier)) {
                if (newDosage != null && !newDosage.isEmpty()) {
                    med.setDose(newDosage);
                    updatedAny = true;
                }
                if (newQuantity != null && newQuantity >= 0) {
                    med.setQuantityInStock(newQuantity);
                    updatedAny = true;
                }
                if (newExpiryDate != null) {
                    med.setExpiryDate(newExpiryDate);
                    updatedAny = true;
                }
                if (updatedAny) {
                    System.out.println("Updated medication: " + med.getName() + " (ID: " + med.getID() + ")");
                }
                return; // only update first match
            }
        }

        System.out.println("No medication found with ID or name: " + identifier);
    }

    // Overload: edit by Medication object
    public void editMedication(Medication medication, String newDosage, Integer newQuantity, LocalDate newExpiryDate) {
        if (medication == null) {
            System.out.println("Invalid medication reference.");
            return;
        }
        editMedication(medication.getID(), newDosage, newQuantity, newExpiryDate);
    }






// TODO: Add search functionality (find by ID or name) 

// TODO: Add method to check and list expired medications 

// TODO: Add restock functionality (random or specific number)

// TODO: Connect MedicationSystem to Prescription and Patient classes

// TODO: Generate medication report for all stored medications

}
