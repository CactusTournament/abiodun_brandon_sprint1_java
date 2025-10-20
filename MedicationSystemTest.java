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
        Medication med3 = new Medication("M003", "Tramadol", "50mg", 20, LocalDate.of(2025, 3, 31));

        system.addMedication(med1);
        system.addMedication(med1); // Should fail (already exists)
        system.editMedication(med1, null, 6, null); 

        system.addMedication(med3);
        system.addMedication(med2);
        system.removeMedication(med1.getID()); // Using string getID() method
        system.removeMedication("M002"); 
        system.removeMedication("M002");  //Should fail 
        system.removeMedication("M004"); // Should fail (not found)

        system.addMedication("M004", "Paracetamol", "500mg", 100, LocalDate.of(2025, 12, 31)); // Cannot remove using variable name as not stored
        system.removeMedication("M004"); 

        system.addMedication(med1);
        system.addMedication(med2);
        system.editMedication("M001", "750mg", 40, LocalDate.of(2025, 8, 31));
        system.editMedication("Ibuprofen", null, 100, null);
        system.editMedication(med2, null, 25, null);

        system.removeMedication("M002"); 
        system.editMedication(med2, null, 25, null); // Should fail (not found)





        // Display all medications
        system.viewMedications();
    }
}
