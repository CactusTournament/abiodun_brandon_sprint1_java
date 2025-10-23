import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the medication management system.
 * Handles adding and viewing medications, patients, doctors, and prescriptions.
 * 
 * Author: Brandon Maloney
 * Updated by: Abiodun Magret Oyedele
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
    public void editMedication(String identifier, String newName, String newDosage, Integer newQuantity, LocalDate newExpiryDate) {
        if (identifier == null || identifier.isEmpty()) {
            System.out.println("Invalid medication identifier.");
            return;
        }

        boolean updatedAny = false;

        for (Medication med : medications) {
            if (med.getID().equalsIgnoreCase(identifier) || med.getName().equalsIgnoreCase(identifier)) {
                if (newName != null && !newName.isEmpty()) {
                    med.setName(newName);
                    updatedAny = true;
                }

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
                return;
            }
        }

        System.out.println("No medication found with ID or name: " + identifier);
    }

    // Overload: edit by Medication object
    public void editMedication(Medication medication, String newName, String newDosage, Integer newQuantity, LocalDate newExpiryDate) {
        if (medication == null) {
            System.out.println("Invalid medication reference.");
            return;
        }
        editMedication(medication.getID(), newName, newDosage, newQuantity, newExpiryDate);
    }

    // Search across Medications, Patients, and Doctors by name
    public void searchAll(String keyword) {
        boolean found = false;

        // Search Medications by Name
        for (Medication med: medications) {
            if (med.getName().equalsIgnoreCase(keyword)) {
                System.out.println(med);
                found = true;
            }
        }

        // Search Patients by Name
        for (Patient pat: patients) {
            if (pat.getName().equalsIgnoreCase(keyword)) {
                System.out.println(pat);
                found = true;
            }
        }

        // Search Doctors by Name
        for (Doctor doc: doctors) {
            if (doc.getName().equalsIgnoreCase(keyword)) {
                System.out.println(doc);
                found = true;
            }
        }

        // Not found message
        if (!found) {
            System.out.println("No records found for: " + keyword);
        }
    }

    // Add patient
    public void addPatient(Patient patient) {
        if (patient != null) {
            patients.add(patient);
            System.out.println("Patient added: " + patient.getName());
        }
    }
    
    // Add doctor
    public void addDoctor(Doctor doctor) {
        if (doctor != null) {
            doctors.add(doctor);
            System.out.println("Doctor added: " + doctor.getName());
        }
    }

    // Add patient to doctor's list by names
    public void addPatientToDoctor(String doctorName, String patientName) {
        Doctor doctor = null;
        Patient patient = null;

        for (Doctor doc : doctors) {
            if (doc.getName().equalsIgnoreCase(doctorName)) {
                doctor = doc;
                break;
            }
        }

        for (Patient pat : patients) {
            if (pat.getName().equalsIgnoreCase(patientName)) {
                patient = pat;
                break;
            }
        }

        if (doctor != null && patient != null) {
            doctor.addPatient(patient);
        } else {
            System.out.println("Could not assign patient. Check doctor and patient names.");
        }
    }

    // Accepts a prescription
    public void acceptPrescription(String patientName, String doctorName, String medicationID, String dosage, int prescribedQuantity) {
        // Find patient
        Patient patient = null;
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(patientName)) {
                patient = p;
                break;
            }
        }

        // Find doctor
        Doctor doctor = null;
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(doctorName)) {
                doctor = d;
                break;
            }
        }

        // Find medication
        Medication medication = null;
        for (Medication m : medications) {
            if (m.getID().equalsIgnoreCase(medicationID)) {
                medication = m;
                break;
            }
        }

        // Validate data
        if (patient == null || doctor == null || medication == null) {
            System.out.println("Cannot create prescription. Check patient, doctor, or medication.");
            return;
        }

        if (prescribedQuantity <= 0) {
            System.out.println("Invalid quantity. Must be at least 1.");
            return;
        }

        if (medication.getQuantityInStock() < prescribedQuantity) {
            System.out.println("Insufficient stock for " + medication.getName() + ".");
            return;
        }

        // Create new prescription 
        Prescription prescription = new Prescription(patient, doctor, medication, dosage, prescribedQuantity);
        prescriptions.add(prescription);
        patient.addPrescription(prescription);

        // Update medication stock
        medication.setQuantityInStock(medication.getQuantityInStock() - prescribedQuantity);

        System.out.println("Prescription accepted for patient " +
                patient.getName() + " by Dr. " + doctor.getName() +
                " for medication " + medication.getName() +
                " (Dosage: " + dosage + ", Quantity: " + prescribedQuantity + ").");
    }

    // Method to check and list expired medications 
     public void checkExpiredMedications() {
        System.out.println("\n--- Checking for Expired Medications ---");
        boolean foundExpired = false;
        LocalDate today = LocalDate.now();

        for (Medication med : medications) {
            if (med.getExpiryDate().isBefore(today)) {
                System.out.println("Expired: " + med.getName() + " (ID: " + med.getID() +
                        ", Expired on: " + med.getExpiryDate() + ")");
                foundExpired = true;
            }
        }

        if (!foundExpired) {
            System.out.println("No expired medications found.");
        }
    }


    // Method to restock functionality (random or specific number)
     public void restockMedications(int amount) {
        System.out.println("\n--- Restocking Medications ---");
        Random rand = new Random();

        for (Medication med : medications) {
            int restockAmount = (amount > 0) ? amount : rand.nextInt(20) + 5; // 5–25 random restock
            int newQuantity = med.getQuantityInStock() + restockAmount;
            med.setQuantityInStock(newQuantity);
            System.out.println("Restocked " + med.getName() + " by " + restockAmount +
                    " units. New total: " + newQuantity);
        }
    }

    // Connect MedicationSystem to Prescription and Patient classes
      public void linkPrescriptionsToPatients() {
        System.out.println("\n--- Linking Prescriptions to Patients ---");
        int linkedCount = 0;

        for (Prescription pres : prescriptions) {
            Patient patient = pres.getPatient();
            if (patient != null) {
                patient.addPrescription(pres);
                linkedCount++;
            }
        }

        System.out.println("Linked " + linkedCount + " prescriptions to patients.");
    }

    // Method Prints a list of all prescription’s issued by a specific doctor.
    public void printPrescriptionsByDoctor(String doctorName) {
        boolean found = false;
    
        for (Prescription pres : prescriptions) {
            Doctor doc = pres.getDoctor();
            if (doc != null && doc.getName().equalsIgnoreCase(doctorName)) {
                System.out.println(pres);
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No prescriptions found for Dr. " + doctorName);
        }
    }

    // Edit patients
    public void editPatients(String oldName, String name, Integer age, String phoneNumber) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(oldName)) {
                boolean updated = false;

                if (name != null && !name.isEmpty()) {
                    p.setName(name);
                    updated = true;
                }

                if (age != null && age > 0) {
                    p.setAge(age);
                    updated = true;
                }

                if (phoneNumber != null && !phoneNumber.isEmpty()) {
                    p.setPhoneNumber(phoneNumber);
                    updated = true;
                }

                if (updated) {
                    System.out.println("Updated patient: " + p.getName() + "  age: " + p.getAge() + "  phoneNumber: " + p.getPhoneNumber());
                } else {
                    System.out.println("No updates made for patient: " + oldName);
                }
                return;
            }
        }

        System.out.println("No patient found with name: " + oldName);
    }

    // Overload: Edit patient by Patient object
    public void editPatients(Patient patient, String name, Integer age, String phoneNumber) {
        if (patient == null) {
            System.out.println("Invalid patient reference.");
            return;
        }
        editPatients(patient.getName(), name, age, phoneNumber);
    }

    // Delete patients (ID or name)
    public Patient removePatient(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            System.out.println("Invalid patient identifier.");
            return null;
        }

        for (int i = 0; i < patients.size(); i++) {
            Patient pat = patients.get(i);
            if (String.valueOf(pat.getID()).equalsIgnoreCase(identifier) || pat.getName().equalsIgnoreCase(identifier)) {
                patients.remove(i);
                System.out.println("Removed patient: " + pat.getName() + " (ID: " + pat.getID() + ")");
                return pat;
            }
        }

        System.out.println("No patient found with ID or name: " + identifier);
        return null;
    }

    // Overload: remove by Patient object
    public void removePatient(Patient patient) {
        if (patient == null) {
            System.out.println("Invalid patient reference.");
            return;
        }
        removePatient(String.valueOf(patient.getID()));
    }

    // Edit doctors
    public void editDoctors(String oldName, String name, Integer age, String phoneNumber, String specialization) {
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(oldName)) {
                boolean updated = false;

                if (name != null && !name.isEmpty()) {
                    d.setName(name);
                    updated = true;
                }

                if (age != null && age > 0) {
                    d.setAge(age);
                    updated = true;
                }

                if (phoneNumber != null && !phoneNumber.isEmpty()) {
                    d.setPhoneNumber(phoneNumber);
                    updated = true;
                }

                if (specialization != null && !specialization.isEmpty()) {
                    d.setSpecialization(specialization);
                    updated = true;
                }

                if (updated) {
                    System.out.println("Updated doctor: " + d.getName() + "  age: " + d.getAge() + "  phoneNumber: " + d.getPhoneNumber() + "  specialization: " + d.getSpecialization());
                } else {
                    System.out.println("No updates made for doctor: " + oldName);
                }
                return;
            }
        }

        System.out.println("No doctor found with name: " + oldName);
    }

     // Overload: Edit doctor by doctor object
    public void editDoctors(Doctor doctor, String name, Integer age, String phoneNumber, String specialization) {
        if (doctor == null) {
            System.out.println("Invalid doctor reference.");
            return;
        }
        editDoctors(doctor.getName(), name, age, phoneNumber, specialization);
    }

    // Delete doctors (ID or name)
    public Doctor removeDoctor(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            System.out.println("Invalid doctor identifier.");
            return null;
        }

        for (int i = 0; i < doctors.size(); i++) {
            Doctor doc = doctors.get(i);
            if (String.valueOf(doc.getID()).equalsIgnoreCase(identifier) || doc.getName().equalsIgnoreCase(identifier)) {
                doctors.remove(i);
                System.out.println("Removed doctor: " + doc.getName() + " (ID: " + doc.getID() + ")");
                return doc;
            }
        }

        System.out.println("No doctor found with ID or name: " + identifier);
        return null;
    }

    // Overload: remove by Doctor object
    public void removeDoctor(Doctor doctor) {
        if (doctor == null) {
            System.out.println("Invalid doctor reference.");
            return;
        }
        removeDoctor(String.valueOf(doctor.getID()));
    }

// TODO: Generate medication report for all stored medications
    public void generateMedicationReport() {
        System.out.println("\n--- Medication Report ---");

        if (medications.isEmpty()) {
            System.out.println("No medications available in the system.");
            return;
        }

        LocalDate today = LocalDate.now();

        for (Medication med : medications) {
            boolean isExpired = med.getExpiryDate().isBefore(today);

            System.out.println(
                "ID: " + med.getID() +
                " | Name: " + med.getName() +
                " | Dosage: " + med.getDose() +
                " | Quantity: " + med.getQuantityInStock() +
                " | Expiry: " + med.getExpiryDate() +
                (isExpired ? " (EXPIRED)" : "")
            );
        }
    }

// TODO: Generate a report containing all system data, including drugs, patients, doctors, and prescriptions.
    public void generateFullSystemReport() {
        System.out.println("\n=== FULL SYSTEM REPORT ===");

        // Medications
        System.out.println("--- Medications ---");
        LocalDate today = LocalDate.now();

        for (Medication med : medications) {
            boolean isExpired = med.getExpiryDate().isBefore(today);
            System.out.println(
                "Medication ID = " + med.getID() +
                ", Name = " + med.getName() +
                ", Dose = " + med.getDose() +
                ", Quantity In Stock = " + med.getQuantityInStock() +
                ", Expiry Date = " + med.getExpiryDate() +
                (isExpired ? " (EXPIRED)" : "")
            );
        }
        System.out.println();

        // Patients
        System.out.println("\n--- Patients ---");
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            for (Patient pat : patients) {
                System.out.println("\n");
                System.out.println(pat);
                // Optionally, print their prescriptions
                if (!pat.getPrescriptions().isEmpty()) {
                    System.out.println("\n  Prescriptions:");
                    for (Prescription pres : pat.getPrescriptions()) {
                        System.out.println("    Prescription ID = " + pres.getID() +
                                        ", Medication = " + pres.getMedication().getName() +
                                        ", Dosage = " + pres.getDosage() +
                                        ", Quantity = " + pres.getPrescribedQuantity() +
                                        ", Expiry = " + pres.getPrescriptionExpiry());
                    }
                }
            }
        }

        // Doctors
        System.out.println("\n--- Doctors ---");
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
        } else {
            for (Doctor doc : doctors) {
                System.out.println(doc);
                if (!doc.getPatients().isEmpty()) {
                    System.out.println("\n  Patients:");
                    for (Patient pat : doc.getPatients()) {
                        System.out.println("    " + pat.getName() + " (ID=" + pat.getPatientID() + ")");
                    }
                }
            }
        }

        // Prescriptions
        System.out.println("\n--- Prescriptions ---");
        for (Prescription pres : prescriptions) {
            System.out.println(
                "Prescription ID = " + pres.getID() +
                ", Medication = " + pres.getMedication().getName() +
                ", Patient = " + (pres.getPatient() != null ? pres.getPatient().getName() + " (ID=" + pres.getPatient().getPatientID() + ")" : "N/A") +
                ", Doctor = " + (pres.getDoctor() != null ? pres.getDoctor().getName() + " (ID=" + pres.getDoctor().getID() + ")" : "N/A") +
                ", Dosage = " + pres.getDosage() +
                ", Quantity = " + pres.getPrescribedQuantity() +
                ", Expiry = " + pres.getPrescriptionExpiry()
            );
        }
        System.out.println();


        }
}
