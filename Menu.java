/**
 * Menu for the pharmacy system to manage patient drugs and information.
 * 
 * Author: Abiodun Magret Oyedele
 * Date: 2024-10-22
 */

/*
This is an example menu that is set up to show you a way of structuring your project.
this doesnt have all requirements in it please refer to the sprint doc to view all requirements
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
             System.out.println("3: Add A New Medication To The Pharmacy");
             System.out.println("4: Delete a Patient");
            //  System.out.println("5: Print System Report");
            //  System.out.println("5: Check If Meds Are Expired");
            //  System.out.println("6: Process A New Prescription");
            //  System.out.println("7: Print All Scripts For Specific Doctor");
            //  System.out.println("8: Restock the drugs in the pharmacy");
            //  System.out.println("9: print all scripts for specific patient");
             System.out.println("10: Exit");
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
                //  case 4:
                //      printPharmacyReport(system);
                //      break;
                //  case 5:
                //      checkExpiredMeds(system);
                //      break;
                //  case 6:
                //      processANewScript(scanner,system);
                //      break;
                //  case 7:
                //      printScriptsForSpecificDoctor(scanner,system);
                //      break;
                //  case 8:
                //      restockPharmacyDrugs(scanner,system);
                //      break;
                //  case 9:
                //      printAllScriptsForPatientByName(scanner,system);
                //      break;
                 case 10:
                     exit = true;
                     System.out.println("Exiting The System! Good Bye!");
                     break;
                 default:
                     System.out.println("Invalid option");
             }
         }
         scanner.close();
     }
 
    //  private static void printAllScriptsForPatientByName(Scanner scanner, system system) {
 
    //  }
 
    //  private static void restockPharmacyDrugs(Scanner scanner, system system) {
 
    //  }
 
    //  private static void printScriptsForSpecificDoctor(Scanner scanner, system system) {
 
    //  }
 
    //  private static void processANewScript(Scanner scanner, system system) {
 
    //  }
 
    //  private static void checkExpiredMeds(system system) {
 
    //  }
 
    //  private static void printPharmacyReport(system system) {
 
    //  }

    private static void deleteAPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Delete A Patient From The System ---");

        System.out.print("Enter Patient ID or Name to Delete: ");
        String identifier = scanner.nextLine();

        if (identifier.isEmpty()) {
            System.out.println("Invalid input. Please enter a valid patient ID or name.");
            return;
        }

        system.removePatient(identifier);

        // System.out.println("\n");

        // system.removePatient(id);
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
 
