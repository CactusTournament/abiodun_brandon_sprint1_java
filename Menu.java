/**
 * Menu for the pharmacy system to manage patient drugs and information.
 * 
 * Author: Abiodun Magret Oyedele
 * Updated by: Brandon Maloney
 * Date: 2024-10-23
 */

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        MedicationSystem system = new MedicationSystem();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("\n=====Welcome To The Pharmacy Med Tracking System=====");
            System.out.println("What would you like to do? (Hint: Enter -2 at any prompt to return to the main menu.)");
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

            int option = getValidatedInt(scanner, "Enter choice: ");
            if (option == -2) continue;

            switch (option) {
                case 1 -> addANewPatient(scanner, system);
                case 2 -> addANewDoctor(scanner, system);
                case 3 -> addNewMedicationToPharmacy(scanner, system);
                case 4 -> deleteAPatient(scanner, system);
                case 5 -> deleteADoctor(scanner, system);
                case 6 -> deleteAMedication(scanner, system);
                case 7 -> editAPatient(scanner, system);
                case 8 -> editADoctor(scanner, system);
                case 9 -> editAMedication(scanner, system);
                case 10 -> searchMedicationDoctorPatient(scanner, system);
                case 11 -> acceptPrescription(scanner, system);
                case 12 -> addPatientToDoctor(scanner, system);
                case 13 -> generateFullSystemReport(scanner, system);
                case 14 -> checkExpiredMeds(scanner, system);
                case 15 -> printPrescriptionsForSpecificDoctor(scanner, system);
                case 16 -> printAllPatientsAnnualPrescriptionReport(scanner, system);
                case 17 -> restockMedications(scanner, system);
                case 18 -> {
                    exit = true;
                    System.out.println("Exiting The System! Good Bye!");
                }
                default -> System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    /*
     * Helper method to get a validated integer input from the user.
     * @param scanner the Scanner object for input
     * @param prompt the prompt message to display
     * @return the validated integer input
     */
    private static int getValidatedInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.equals("-2")) return -2;
            try {
                int value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.println("Please enter a number greater than 0.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    /*
     * Helper method to get a validated non-empty string input from the user.
     * @param scanner the Scanner object for input
     * @param prompt the prompt message to display
     * @return the validated string input
     */
    private static String getValidatedString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.equals("-2")) return "-2";
            if (!input.isEmpty()) return input;
            System.out.println("Invalid input. Please enter a non-empty value.");
        }
    }

    /*
     * Restock medications in the pharmacy.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void restockMedications(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Restock Pharmacy Drugs ---");
        String identifier = getValidatedString(scanner, "Enter Medication ID to Restock: ");
        if (identifier.equals("-2")) return;
        int quantityToAdd = getValidatedInt(scanner, "Enter Quantity to Add: ");
        if (quantityToAdd == -2) return;
        system.restockMedications(quantityToAdd);
        System.out.println("\n");
    }

    /*
     * Print annual prescription report for all patients.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void printAllPatientsAnnualPrescriptionReport(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Annual Report For All Patients Prescriptions---");
        system.generateAnnualPrescriptionSummary();
        System.out.println("\n");
    }

    /*
     * Print all prescriptions for a specific doctor.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */ 
    private static void printPrescriptionsForSpecificDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Print All Prescriptions For A Specific Doctor ---");
        String doctorName = getValidatedString(scanner, "Enter Doctor's Name: ");
        if (doctorName.equals("-2")) return;
        system.printPrescriptionsByDoctor(doctorName);
        System.out.println("\n");
    }

    /*
     * Check for expired medications in the pharmacy.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void checkExpiredMeds(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Check For Expired Medications ---");
        system.checkExpiredMedications();
        System.out.println("\n");
    }

    /*
     * Generate a full system report.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void generateFullSystemReport(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Generate Full System Report ---");
        system.generateFullSystemReport();
        System.out.println("\n");
    }

    /*
     * Assign a patient to a doctor.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void addPatientToDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Assign A Patient To A Doctor ---");
        String doctorName = getValidatedString(scanner, "Enter Doctor's Name: ");
        if (doctorName.equals("-2")) return;
        String patientName = getValidatedString(scanner, "Enter Patient's Name: ");
        if (patientName.equals("-2")) return;
        system.addPatientToDoctor(doctorName, patientName);
        System.out.println("\n");
    }

    /*
     * Accept a prescription into the system.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void acceptPrescription(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Accept A Prescription ---");
        String patientName = getValidatedString(scanner, "Enter Patient Name: ");
        if (patientName.equals("-2")) return;
        String doctorName = getValidatedString(scanner, "Enter Doctor Name: ");
        if (doctorName.equals("-2")) return;
        String medicationID = getValidatedString(scanner, "Enter Medication ID: ");
        if (medicationID.equals("-2")) return;
        String dosageInstructions = getValidatedString(scanner, "Enter Dosage Instructions: ");
        if (dosageInstructions.equals("-2")) return;
        int quantityPrescribed = getValidatedInt(scanner, "Enter Quantity Prescribed: ");
        if (quantityPrescribed == -2) return;
        system.acceptPrescription(patientName, doctorName, medicationID, dosageInstructions, quantityPrescribed);
        System.out.println("\n");
    }

    /*
     * Search for a medication, doctor, or patient by name.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void searchMedicationDoctorPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Search For A Medication, Doctor, Or Patient By Name ---");
        String name = getValidatedString(scanner, "Enter Medication, Doctor or Patient's Name To Search: ");
        if (name.equals("-2")) return;
        system.searchAll(name);
        System.out.println("\n");
    }

    /*
     * Edit a medication's information.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void editAMedication(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Edit A Medication's Information ---");
        String identifier = getValidatedString(scanner, "Enter Medication ID or Name to Edit: ");
        if (identifier.equals("-2")) return;
        System.out.print("Enter New Name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Dose (leave blank to keep current): ");
        String newDose = scanner.nextLine();
        System.out.print("Enter New Quantity In Stock (or -1 to keep current): ");
        int newQuantityInStock = getValidatedInt(scanner, "");
        if (newQuantityInStock == -2) return;
        System.out.print("Enter New Expiry Date (YYYY-MM-DD) (leave blank to keep current): ");
        String newExpiryDateStr = scanner.nextLine();
        LocalDate newExpiryDate = null;
        if (!newExpiryDateStr.isEmpty()) {
            try {
                String[] dateParts = newExpiryDateStr.split("-");
                int year = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[2]);
                newExpiryDate = LocalDate.of(year, month, day);
            } catch (NumberFormatException | java.time.DateTimeException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid date format.");
                return;
            }
        }
        system.editMedication(identifier, newName.isEmpty() ? null : newName, newDose.isEmpty() ? null : newDose,
                newQuantityInStock == -1 ? -1 : newQuantityInStock, newExpiryDate);
        System.out.println("\n");
    }

    /*
     * Edit a doctor's information.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void editADoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Edit A Doctor's Information ---");
        String identifier = getValidatedString(scanner, "Enter Doctor's Name to Edit: ");
        if (identifier.equals("-2")) return;
        System.out.print("Enter New Name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Age (or -1 to keep current): ");
        int newAge = getValidatedInt(scanner, "");
        if (newAge == -2) return;
        System.out.print("Enter New Phone Number (leave blank to keep current): ");
        String newPhone = scanner.nextLine();
        System.out.print("Enter New Specialization (leave blank to keep current): ");
        String newSpecialization = scanner.nextLine();
        system.editDoctors(identifier, newName.isEmpty() ? null : newName, newAge == -1 ? -1 : newAge,
                newPhone.isEmpty() ? null : newPhone, newSpecialization.isEmpty() ? null : newSpecialization);
        System.out.println("\n");
    }

    /*
     * Edit a patient's information.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void editAPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Edit A Patient's Information ---");
        String identifier = getValidatedString(scanner, "Enter Patient Name to Edit: ");
        if (identifier.equals("-2")) return;
        System.out.print("Enter New Name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Age (or -1 to keep current): ");
        int newAge = getValidatedInt(scanner, "");
        if (newAge == -2) return;
        System.out.print("Enter New Phone Number (leave blank to keep current): ");
        String newPhone = scanner.nextLine();
        system.editPatients(identifier, newName.isEmpty() ? null : newName, newAge == -1 ? -1 : newAge,
                newPhone.isEmpty() ? null : newPhone);
        System.out.println("\n");
    }

    /*
     * Delete a medication from the pharmacy.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void deleteAMedication(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Delete A Medication From The Pharmacy ---");
        String identifier = getValidatedString(scanner, "Enter Medication ID or Name to Delete: ");
        if (identifier.equals("-2")) return;
        system.removeMedication(identifier);
        System.out.println("\n");
    }

    /*
     * Delete a doctor from the system.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void deleteADoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Delete a Doctor From The System ---");
        String identifier = getValidatedString(scanner, "Enter Doctor ID or Name to Delete: ");
        if (identifier.equals("-2")) return;
        system.removeDoctor(identifier);
        System.out.println("\n");
    }

    /*
     * Delete a patient from the system.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void deleteAPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Delete A Patient From The System ---");
        String identifier = getValidatedString(scanner, "Enter Patient ID or Name to Delete: ");
        if (identifier.equals("-2")) return;
        system.removePatient(identifier);
        System.out.println("\n");
    }

    /*
     * Add a new medication to the pharmacy.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Add A New Medication To The Pharmacy ---");
        String id = getValidatedString(scanner, "Enter Medication ID: ");
        if (id.equals("-2")) return;
        String name = getValidatedString(scanner, "Enter Medication Name: ");
        if (name.equals("-2")) return;
        String dose = getValidatedString(scanner, "Enter Medication Dose: ");
        if (dose.equals("-2")) return;
        int quantityInStock = getValidatedInt(scanner, "Enter Quantity In Stock: ");
        if (quantityInStock == -2) return;
        LocalDate expiryDate = null;
        while (true) {
            String expiryDateStr = getValidatedString(scanner, "Enter Expiry Date (YYYY-MM-DD): ");
            if (expiryDateStr.equals("-2")) return;

            // enforce digits and exact format YYYY-MM-DD
            if (!expiryDateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Invalid format. Please enter the date in YYYY-MM-DD (digits only).");
            continue;
            }

            try {
            String[] dateParts = expiryDateStr.split("-");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            // LocalDate.of will validate month/day ranges (e.g., no Feb 30)
            expiryDate = LocalDate.of(year, month, day);
            break; // valid date -> exit loop
            } catch (NumberFormatException | java.time.DateTimeException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid date. Please ensure the date is a real calendar date (e.g., 2025-02-28).");
            }
        }

        Medication newMedication = new Medication(id, name, dose, quantityInStock, expiryDate);
        system.addMedication(newMedication);
        System.out.println("\n");
    }

    /*
     * Add a new doctor to the system.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void addANewDoctor(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Add a New Doctor ---");
        int id = getValidatedInt(scanner, "Enter Doctor ID: ");
        if (id == -2) return;
        String name = getValidatedString(scanner, "Enter Doctor Name: ");
        if (name.equals("-2")) return;
        int age = getValidatedInt(scanner, "Enter Doctor Age: ");
        if (age == -2) return;
        System.out.println("Enter Doctor Phone Number: ");
        String phoneNumber;

        while (true) {
            phoneNumber = scanner.nextLine().trim();

            if (phoneNumber.equals("-2")) {
                System.out.println("Returning to main menu...");
                return;
            }

            // Remove spaces, dashes, and plus signs before checking
            String digitsOnly = phoneNumber.replaceAll("[^\\d]", "");

            if (digitsOnly.matches("\\d{7,15}")) {
                phoneNumber = digitsOnly; // store the cleaned number
                break;
            } else {
                System.out.println("Invalid phone number. Please enter 7-15 digits (digits only, e.g. 7094443333): ");
            }
        }


        String specialization = getValidatedString(scanner, "Enter Doctor Specialization: ");
        if (specialization.equals("-2")) return;
        Doctor newDoctor = new Doctor(id, name, age, phoneNumber, specialization);
        system.addDoctor(newDoctor);
        System.out.println("\n");
    }

    /*
     * Add a new patient to the system.
     * @param scanner the Scanner object for input
     * @param system the MedicationSystem object
     */
    private static void addANewPatient(Scanner scanner, MedicationSystem system) {
        System.out.println("\n--- Add a New Patient ---");
        int id = getValidatedInt(scanner, "Enter Patient ID: ");
        if (id == -2) return;
        String name = getValidatedString(scanner, "Enter Patient Name: ");
        if (name.equals("-2")) return;
        int age = getValidatedInt(scanner, "Enter Patient Age: ");
        if (age == -2) return;
        System.out.println("Enter Patient Phone Number: ");
        String phoneNumber;

        while (true) {
            phoneNumber = scanner.nextLine().trim();

            if (phoneNumber.equals("-2")) {
                System.out.println("Returning to main menu...");
                return;
            }

            // Remove spaces, dashes, and plus signs before checking
            String digitsOnly = phoneNumber.replaceAll("[^\\d]", "");

            if (digitsOnly.matches("\\d{7,15}")) {
                phoneNumber = digitsOnly; // store the cleaned number
                break;
            } else {
                System.out.println("Invalid phone number. Please enter 7–15 digits (digits only, e.g. 7094443333): ");
            }
        }


        Patient newPatient = new Patient(id, name, age, phoneNumber);
        system.addPatient(newPatient);
        System.out.println("\n");
    }
}
