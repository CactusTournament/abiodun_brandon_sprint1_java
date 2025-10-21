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

        // Creates medicationSysyem instances
        MedicationSystem system = new MedicationSystem();

        // Create patients
        Patient patient1 = new Patient(1, "John Doe", 30, "555-1234");
        Patient patient2 = new Patient(2, "Jane Smith", 25, "555-5678");

        // Add medications 
        Medication med1 = new Medication("M001", "Amoxicillin", "500mg", 30, LocalDate.of(2024, 12, 31));
        Medication med2 = new Medication("M002", "Ibuprofen", "200mg", 50, LocalDate.of(2025, 6, 15));
        Medication med3 = new Medication("M003", "Tramadol", "50mg", 20, LocalDate.of(2025, 3, 31));

        // Create doctors
        Doctor doctor1 = new Doctor(1, "Dr. Smith", 45, "555-8765", "General Practitioner");
        Doctor doctor2 = new Doctor(2, "Dr. Jones", 50, "555-4321", "Cardiologist");


        System.out.println("\n\n");
        system.addMedication(med1);
        system.addMedication(med1); // Should fail (already exists)
        system.editMedication(med1, null, 6, null); 

        System.out.println("\n\n");
        system.addMedication(med3);
        system.addMedication(med2);
        system.removeMedication(med1.getID()); // Using string getID() method
        system.removeMedication("M002"); 
        system.removeMedication("M002");  //Should fail 
        system.removeMedication("M004"); // Should fail (not found)

        System.out.println("\n\n");
        system.addMedication("M004", "Paracetamol", "500mg", 100, LocalDate.of(2025, 12, 31)); // Cannot remove using variable name as not stored
        system.removeMedication("M004"); 

        System.out.println("\n\n");
        system.addMedication(med1);
        system.addMedication(med2);
        system.editMedication("M001", "750mg", 40, LocalDate.of(2025, 8, 31));
        system.editMedication("Ibuprofen", null, 100, null);
        system.editMedication(med2, null, 25, null);

        system.removeMedication("M002"); 
        system.editMedication(med2, null, 25, null); // Should fail (not found)

        System.out.println("\n\n");
        System.out.println("_______Adding patients and doctors to the system:______");
        system.addPatient(patient1);
        system.addPatient(patient2);
        system.addDoctor(doctor1);
        system.addDoctor(doctor2);

        // Add patients to doctors
        System.out.println("\n\n");
        System.out.println("_______Adding patients to doctors:______");
        system.addPatientToDoctor("Dr. Smith", "John Doe");
        system.addPatientToDoctor("Dr. Smith", "Jane Smith");

        // To display doctor info with patients
        System.out.println("\n\n");
        System.out.println("_______Displaying doctor information:______");
        System.out.println(doctor1.toString());
        System.out.println(doctor2.toString());


        // Search for medications
        System.out.println("\n\n");
        System.out.println("_______Searching for medications:______");
        system.searchAll("Aspirin"); // Should not find
        system.searchAll("Tramadol");

        // Search for patients
        System.out.println("\n\n_______Adding and Searching for patients:______");
        system.searchAll("Jane Smith");
        system.searchAll("Joe Dane"); // Should not find

        // Search for doctors
        System.out.println("\n\n");
        System.out.println("_______Searching for doctors:______");
        system.searchAll("Dr. Smith");
        system.searchAll("Dr. Who"); // Should not find

        System.out.println("\n\n");
        System.out.println("_______Accepting prescription:______");
        system.acceptPrescription(patient1.getName(), doctor1.getName(), med1.getID(), "Take once a day", 2);
        system.acceptPrescription("Non Existent Patient", doctor1.getName(), med1.getID(), "Take once a day", 2); // Should fail

        // Display all medications
        system.viewMedications();
    }
}
