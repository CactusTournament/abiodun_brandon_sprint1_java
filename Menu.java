/**
 * Menu for the pharmacy system to manage patient drugs and information.
 * 
 * Author: Abiodun Magret Oyedele
 * Date: 2024-10-23
 */

import java.util.Scanner;
import java.time.LocalDate;
 
public class Menu {
     public static void main(String[] args) {
         MedicationSystem system = new MedicationSystem();
         boolean exit = false;
 
         Scanner scanner = new Scanner(System.in);
         while (!exit){
            System.out.println("\n=====Welcome To The Pharmacy Med Tracking System=====");
            System.out.println("What would you like to do?");
            System.out.println("1: Add A New Patient");
            System.out.println("2: Add A New Doctor");
            System.out.println("3: Add A New Medication");
            System.out.println("4: Delete a Patient");
            System.out.println("5: Delete a Doctor");
            System.out.println("6: Delete a Medication");
            System.out.println("7: Edit a Patient");
            System.out.println("8: Edit a Doctor");
            System.out.println("9: Edit a Medication");
            System.out.println("10: Search for a Patient Medication, Doctor, or Patient by name");
            System.out.println("11: Accept a Prescription");
            System.out.println("12: Add a Patient to a Doctor");
            System.out.println("13: Generate Full System Report");
            System.out.println("14: Check for Expired Medications");
            System.out.println("15: Print All prescriptions For a Specific Doctor");
            System.out.println("16: Print All Patients Annual Prescription Report");
            System.out.println("17: Restock the drugs in the pharmacy");
            System.out.println("18: Exit");
            System.out.println("\n--- Enter the number corresponding to your choice: ---\n");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                     addANewPatient(scanner, system);
                     break;
                case 2:
                     addANewDoctor(scanner, system);
                     break;
                case 3:
                     addNewMedicationToPharmacy(scanner, system);
                     break;
                case 4:
                    deleteAPatient(scanner, system);
                    break;
                case 5:
                    deleteADoctor(scanner, system);
                    break;
                case 6:
                    deleteAMedication(scanner, system);
                    break;
                case 7:
                    editAPatient(scanner, system);
                    break;
                case 8:
                    editADoctor(scanner, system);
                    break;
                case 9:
                    editAMedication(scanner, system);
                    break;
                case 10:
                    searchMedicationDoctorPatient(scanner, system);
                    break;
                case 11:
                    acceptPrescription(scanner, system);
                    break;
                case 12:
                    addPatientToDoctor(scanner, system);
                    break;
                case 13:
                    generateFullSystemReport(scanner, system);
                    break;
                 case 14:
                    checkExpiredMeds(scanner, system);
                    break;
                 case 15:
                    printPrescriptionsForSpecificDoctor(scanner, system);
                    break;
                case 16:
                    printAllPatientsAnnualPrescriptionReport(scanner, system);
                    break;
                case 17:
                     restockMedications(scanner, system);
                     break;
                 case 18:
                     exit = true;
                     System.out.println("Exiting The System! Good Bye!");
                     break;
                 default:
                     System.out.println("Invalid option");
             }
         }
         scanner.close();
     }

     private static void restockMedications(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Restock Pharmacy Drugs ---");

        System.out.print("Enter Medication ID to Restock: ");
        String identifier = scanner.nextLine();

        if (identifier.isEmpty()) {
            System.out.println("Invalid input. Please enter a valid Medication ID.");
            return;
        }

        System.out.print("Enter Quantity to Add: ");
        int quantityToAdd = scanner.nextInt();
        scanner.nextLine();

        system.restockMedications(quantityToAdd);

        System.out.println("\n");
     }

    private static void printAllPatientsAnnualPrescriptionReport(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Annual Report For All Patients Prescriptions---");

        system.generateAnnualPrescriptionSummary();
        System.out.println("\n");
    }
    
    private static void printPrescriptionsForSpecificDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Print All Prescriptions For A Specific Doctor ---");

        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();

        system.printPrescriptionsByDoctor(doctorName);

        System.out.println("\n");
    }

    private static void checkExpiredMeds(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Check For Expired Medications ---");
        system.checkExpiredMedications();
        System.out.println("\n");
 
     }

     private static void generateFullSystemReport(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Generate Full System Report ---");
        system.generateFullSystemReport();
        System.out.println("\n");
 
     }

     private static void addPatientToDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Assign A Patient To A Doctor ---");

        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter Patient's Name: ");
        String patientName = scanner.nextLine();

        system.addPatientToDoctor(doctorName, patientName);

        System.out.println("\n");
     }

     private static void acceptPrescription(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Accept A Prescription ---");

        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();;
        

        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();;

        System.out.print("Enter Medication ID: ");
        String medicationID = scanner.nextLine();

        System.out.print("Enter Dosage Instructions: ");
        String dosageInstructions = scanner.nextLine();

        System.out.print("Enter Quantity Prescribed: ");
        int quantityPrescribed = scanner.nextInt();
        scanner.nextLine();

        system.acceptPrescription(patientName, doctorName, medicationID, dosageInstructions, quantityPrescribed);

        System.out.println("\n");
     }

     private static void searchMedicationDoctorPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Search For A Medication, Doctor, Or Patient By Name ---");

        System.out.print("Enter Medication, Doctor or Patient's Name To Search: ");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Invalid input. Please enter a valid name.");
            return;
        }

        system.searchAll(name);

        System.out.println("\n");
 
     }

    private static void editAMedication(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Edit A Medication's Information ---");

        System.out.print("Enter Medication ID or Name to Edit: ");
        String identifier = scanner.nextLine();

        if (identifier.isEmpty()) {
            System.out.println("Invalid input. Please enter a valid Medication ID or name.");
            return;
        }

        System.out.print("Enter New Name (leave blank to keep current): ");
        String newName = scanner.nextLine();

        System.out.print("Enter New Dose (leave blank to keep current): ");
        String newDose = scanner.nextLine();

        System.out.print("Enter New Quantity In Stock (or -1 to keep current): ");
        int newQuantityInStock = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Expiry Date (YYYY-MM-DD) (leave blank to keep current): ");
        String newExpiryDateStr = scanner.nextLine();
        LocalDate newExpiryDate = null;
        if (!newExpiryDateStr.isEmpty()) {
            String[] dateParts = newExpiryDateStr.split("-");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            newExpiryDate = LocalDate.of(year, month, day);
        }

        system.editMedication(identifier, newName.isEmpty() ? null : newName, newDose.isEmpty() ? null : newDose, newQuantityInStock == -1 ? -1 : newQuantityInStock, newExpiryDate);

        System.out.println("\n");
    }

    private static void editADoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Edit A Doctor's Information ---");

        System.out.print("Enter Doctor's Name to Edit: ");
        String identifier = scanner.nextLine();

        if (identifier.isEmpty()) {
            System.out.println("Invalid input. Please enter a valid Doctor ID or name.");
            return;
        }

        System.out.print("Enter New Name (leave blank to keep current): ");
        String newName = scanner.nextLine();

        System.out.print("Enter New Age (or -1 to keep current): ");
        int newAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Phone Number (leave blank to keep current): ");
        String newPhone = scanner.nextLine();

        System.out.print("Enter New Specialization (leave blank to keep current): ");
        String newSpecialization = scanner.nextLine();

        system.editDoctors(identifier, newName.isEmpty() ? null : newName, newAge == -1 ? -1 : newAge, newPhone.isEmpty() ? null : newPhone, newSpecialization.isEmpty() ? null : newSpecialization);

        System.out.println("\n");
    }

    private static void editAPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Edit A Patient's Information ---");

        System.out.print("Enter Patient Name to Edit: ");
        String identifier = scanner.nextLine();

        if (identifier.isEmpty()) {
            System.out.println("Invalid input. Please enter a valid patient ID or name.");
            return;
        }

        System.out.print("Enter New Name (leave blank to keep current): ");
        String newName = scanner.nextLine();

        System.out.print("Enter New Age (or -1 to keep current): ");
        int newAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Phone Number (leave blank to keep current): ");
        String newPhone = scanner.nextLine();

        system.editPatients(identifier, newName.isEmpty() ? null : newName, newAge == -1 ? -1 : newAge, newPhone.isEmpty() ? null : newPhone);

        System.out.println("\n");
    }

    private static void deleteAMedication(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Delete A Medication From The Pharmacy ---");

        System.out.print("Enter Medication ID or Name to Delete: ");
        String identifier = scanner.nextLine();

        if (identifier.isEmpty()) {
            System.out.println("Invalid input. Please enter a valid medication ID or name.");
            return;
        }

        system.removeMedication(identifier);

        System.out.println("\n");
    }

    private static void deleteADoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Delete a Doctor From The System ---");

        System.out.print("Enter Doctor ID or Name to Delete: ");
        String identifier = scanner.nextLine();

        if (identifier.isEmpty()) {
            System.out.println("Invalid input. Please enter a valid doctor ID or name.");
            return;
        }

        system.removeDoctor(identifier);

        System.out.println("\n");
    }

    private static void deleteAPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Delete A Patient From The System ---");

        System.out.print("Enter Patient ID or Name to Delete: ");
        String identifier = scanner.nextLine();

        if (identifier.isEmpty()) {
            System.out.println("Invalid input. Please enter a valid patient ID or name.");
            return;
        }

        system.removePatient(identifier);

        System.out.println("\n");
    }
 
     private static void addNewMedicationToPharmacy(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Add A New Medication To The Pharmacy ---");

        System.out.print("Enter Medication ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Medication Dose: ");
        String dose = scanner.nextLine();

        System.out.print("Enter Quantity In Stock: ");
        int quantityInStock = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
        String expiryDateStr = scanner.nextLine();

        System.out.println("\n");
        String[] dateParts = expiryDateStr.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        Medication newMedication = new Medication(id, name, dose, quantityInStock, LocalDate.of(year, month, day));
        system.addMedication(newMedication);
        System.out.println("\n");
     }
 
     private static void addANewDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Add a New Doctor ---");

        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Doctor Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Doctor Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Doctor Specialization: ");
        String specialization = scanner.nextLine();

        System.out.println("\n");
        Doctor newDoctor = new Doctor(id, name, age, phone, specialization);
        system.addDoctor(newDoctor);
        System.out.println("\n");
     }
 
     private static void addANewPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Add a New Patient ---");

        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient Phone Number: ");
        String phone = scanner.nextLine();

        System.out.println("\n");
        Patient newPatient = new Patient(id, name, age, phone);
        system.addPatient(newPatient);
        System.out.println("\n");
     }
 
}
 
