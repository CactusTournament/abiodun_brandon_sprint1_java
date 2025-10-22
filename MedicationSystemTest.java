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

        system.addMedication("M004", "Paracetamol", "500mg", 100, LocalDate.of(2025, 12, 31)); // Cannot remove using variable name as not stored
        system.removeMedication("M004"); 

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
        system.acceptPrescription(patient1.getName(), doctor1.getName(), med3.getID(), "Take once a day", 2);
        system.acceptPrescription(patient2.getName(), doctor2.getName(), med3.getID(), "Take twice a day", 1);
        system.acceptPrescription("Non Existent Patient", doctor1.getName(), med1.getID(), "Take once a day", 2); // Should fail

        // Display all medications
        system.viewMedications();

        // Test expired medication check 
        System.out.println("\n\n");
        System.out.println("_______Testing expired medication check_______");
        Medication expiredMed = new Medication("M005", "Lisinopril", "10mg", 30, LocalDate.of(2023, 5, 15));
        system.addMedication(expiredMed);
        system.checkExpiredMedications();

        // Test restock functionality 
        System.out.println("\n\n");
        System.out.println("_______Testing restock functionality_______");
        system.restockMedications(15);  // restock each medication by 15 units

        // Test prescription linking to patients 
        System.out.println("\n\n");
        System.out.println("_______Testing prescription linking_______");
        system.linkPrescriptionsToPatients();

        // Print prescriptions for patient to confirm link worked
        patient1.printPrescriptions();

        // Print a list of all prescription’s issued by a specific doctor.
        System.out.println("\n\n");
        System.out.println("_______Printing prescriptions issued by _______");
        final String doctor1Name = doctor1.getName();
        System.out.println("Prescriptions issued by " + doctor1Name + ":");
        system.printPrescriptionsByDoctor(doctor1.getName());
        final String doctor2Name = doctor2.getName();
        System.out.println("\nPrescriptions issued by " + doctor2Name + ":");
        system.printPrescriptionsByDoctor(doctor2.getName());
        System.out.println('\n');
        system.printPrescriptionsByDoctor("Dr. Who"); // Should fail

        // Edit patients
        System.out.println("\n\n");
        System.out.println("_______Editing patient information:______");
        system.editPatients(patient1.getName(), "Johnathan Doe", 31, "555-9999");
        system.editPatients(patient1.getName(), "James Nice", null, "222-2222");
        system.editPatients(patient1.getName(), "null", null, "111-1111");
        system.editPatients(patient1.getName(), "John Doesss", 31, "555-1234");
        system.editPatients(patient1, "John Doe", 31, "555-1234");

        // Remove patients
        // Patient patient2 = new Patient(2, "Jane Smith", 25, "555-5678");
        System.out.println("\n\n");
        System.out.println("_______Removing patient information:______");
        system.removePatient(patient2);
        system.addPatient(patient2);

        // Edit doctors
        System.out.println("\n\n");
        // Doctor doctor1 = new Doctor(1, "Dr. Smith", 45, "555-8765", "General Practitioner");
        System.out.println("_______Editing doctor information:______");
        system.editDoctors(doctor1.getName(), "Dr. John Smith", 46, "555-0000", "Family Medicine");
        system.editDoctors(doctor1.getName(), "Dr. John Smith", null, "555-1111", null);
        system.editDoctors(doctor1.getName(), "null", null, "555-2222", null);
        system.editDoctors(doctor1, "Dr. Smith", 46, "555-8765", "General Practitioner");

        // Remove doctors
        System.out.println("\n\n");
        // Doctor doctor1 = new Doctor(1, "Dr. Smith", 45, "555-8765", "General Practitioner");
        System.out.println("_______Removing doctor information:______");
        system.removeDoctor(doctor1);
        system.addDoctor(doctor1);

    }
}
