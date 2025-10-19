import java.time.LocalDate;

/**
 * Manual test for MedicationSystem class.
 * Demonstrates adding and viewing medications.
 * 
 * Author: Brandon Maloney
 * Date: 2025-10-19
 */
public class MedicationSystemTest {
    public static void main(String[] args) {

        // Create MedicationSystem instance 
        MedicationSystem system = new MedicationSystem();

        // Add medications 
        Medication med1 = new Medication("M001", "Amoxicillin", "500mg", 30, LocalDate.of(2024, 12, 31));
        Medication med2 = new Medication("M002", "Ibuprofen", "200mg", 50, LocalDate.of(2025, 6, 15));

        system.addMedication(med1);
        system.addMedication(med1);
        system.addMedication(med2);

        // Display all medications
        system.viewMedications();
    }
}
