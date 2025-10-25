# Pharmacy System Documentation

## 1. USER DOCUMENTATION

### 1.1 Project Overview
The **Pharmacy System** is a console-based Java application designed to help manage patients and medications informations. It includes several classes representing different entities such as **doctors**, **patients**, **medications**, **prescriptions**, and the overall **medication tracking system**.

### 1.2 Classes Overview
#### 1. Person Class
- **Purpose:** This is the base class for both the Patient and Doctor classes.
- **Attributes:** It contains the following attributes
    + **id:** A unique identifier for each person.
    + **Name:** The name of the person.
    + **Age:** The age of the person.
    + **Phone Number:** The persons contact information.
- **Methods:**
    + `Getter` and `setter` methods of each of the attributes.
    + `toString()` method.

#### 2. Doctor Class (extends `Person Class`)
- **Purpose:** Doctor represents a doctor. This is the base class for both the Patient and Doctor classes.
- **Attributes:** It contains the following attributes
    + **List of patients:** List of patients they are managing.
    + **Specialization:** The specific field of medicine or area of expertise the doctor practices in (e.g., cardiology, pediatrics, neurology).
- **Key Methods:**
    + `Getter` and `Setter` for `Specialization`.
    + `addPatient(Patient patient)`
    + `removePatient(Patient patient)`
    + `getPatients()`
    + `toString()`

#### 3. Patient Class (extends `Person Class`)
- **Purpose:** Patient represents a patient. They represents a patient receiving prescriptions.
- **Attributes:** It contains the following attributes
    + **patientID:** A unique identifier of each patient.
    + **List of medications:** List of medications they are taking
    + **List of prescriptions:** List of prescriptions assigned.
- **Key Methods:**
    + `getPatientID()`
    + `addPrescription(Prescription pres)`
    + `getPrescriptions()`
    + `printPrescriptions()`
    + `toString()`

#### 4. Medication Class
- **Purpose:** It represents a medication.
- **Attributes:** It contains the following attributes
    + **id:** A unique identifier for each medication.
    + **name:** The name of the medication.
    + **dose:** The dosage of the medication.
    + **quantityInStock:** The amount of medication in stock.
    + **expiryDate:** The expiry date of the medication set to be a random date.
- **Methods:**
    +  `Getter` and `setter` methods of each of the attributes.
    +  `toString()` method.

#### 5. Prescription Class
- **Purpose:** It represents a prescription issued by a doctor for a patient
- **Attributes:** It contains the following attributes
    + **id:** A unique identifier for each medication.
    + **doctor:** A reference to the prescribing doctor.
    + **patient:** A reference to the patient.
    + **medication:** A reference to the prescribed medication.
    + **dosage:** The dosage of the medication.
    + **prescribedQuantity:** The quantity of the prescribed medication.
    + **prescriptionExpiry:** The expiry date of the prescription set to a year.
- **Methods:**
    +  `Getter` and `setter` methods of each of the attributes.
    +  `toString()` method.

#### 6. MedicationSystem Class
- **Purpose:** It manages the entire pharmacy system.
- **Attributes:** It contains the following attributes;
    - Lists of patients
    - Lists of medications
    - Lists of doctors
- **Functionalities:** It provides the following methods
    + **`addMedication(Medication medication)`:** Add a medication object directly.
    + **`addMedication(String id, String name, String dosage, int quantity, LocalDate expiryDate)`:** Overload: Add by details (used for Scanner input later).
    + **`addMedication(String identifier)`:** Optional: Add by ID or name (could later load a predefined template).
    + **`viewMedications()`:** Display all medications.
    + **`removeMedication(String identifier)`:** Remove medications by identifier (ID or name).
    + **`removeMedication(Medication medication)`:** Overload: remove by Medication object.
    + **`editMedication(String identifier, String newDosage, Integer newQuantity, LocalDate newExpiryDate)`:** Edit medications by identifier or name.
    + **`editMedication(String identifier, String newDosage, Integer newQuantity, LocalDate newExpiryDate)`:** Overload: edit by Medication object.
    + **`searchAll(String keyword)`:** Search across Medications, Patients, and Doctors by name.
    + **`addPatient(Patient patient)`:** Adds patient.
    + **`addDoctor(Doctor doctor)`:** Adds doctor.
    + **`addPatientToDoctor(String doctorName, String patientName)`:** Add patient to doctor's list by names.
    + **`acceptPrescription(String patientName, String doctorName, String medicationID, String dosage, int prescribedQuantity)`:** Accepts a prescription.
    + **`checkExpiredMedications()`:** Method to check and list expired medications.
    + **`restockMedications(int amount)`:** Method to restock functionality (random or specific number).
    + **`linkPrescriptionsToPatients()`:** Connect MedicationSystem to Prescription and Patient classes.
    + **`printPrescriptionsByDoctor(String doctorName)`:** Method Prints a list of all prescription’s issued by a specific doctor.
    + **`editPatients(String oldName, String name, Integer age, String phoneNumber)`:** Edit patients.
    + **`editPatients(Patient patient, String name, Integer age, String phoneNumber)`:** Overload: Edit patient by Patient object.
    + **`removePatient(String identifier)`:** Delete patients (ID or name).
    + **`removePatient(Patient patient)`:** Overload: remove by Patient object.
    + **`editDoctors(String oldName, String name, Integer age, String phoneNumber, String specialization)`:** Edit doctors.
    + **`editDoctors(Doctor doctor, String name, Integer age, String phoneNumber, String specialization)`:** Overload: Edit doctor by doctor object.
    + **`removeDoctor(String identifier)`:** Delete doctors (ID or name).
    + **`removeDoctor(Doctor doctor)`:** Overload: remove by Doctor object.
    + **`generateMedicationReport()`:** Generate medication report for all stored medications.
    + **`generateFullSystemReport()`:** Generate a report containing all system data, including drugs, patients, doctors, and prescriptions.
    + **`generateAnnualPrescriptionSummary()`:** Generate a report of all the patients' prescriptions for the past year.

### 1.3 How to Use the Application
#### 1. Launch the program:
    Open your terminal or IDE.
#### 2. Git clone the repository:
    `https://github.com/CactusTournament/abiodun_brandon_sprint1_java.git`
#### 3. Navigate to the branch:
    `cd abiodun_brandon_sprint1_java`
#### 4. Run the Main Class File: 
    You can do this by:
    - Clicking the run button on the UI
    - Type `javac menu.java` on the terminal
#### 5. Menu Options:
    - When the program starts, you will be provided with menu options. - Click the option corresponding to the action you want to carry out.
#### 6. Input Format:
    - The system uses the Scanner class to take inputs directly from the console.
    - Follow prompts carefully e.g., type doctor names, medication IDs, or quantities as requested.
#### 6. End the program:
    Enter `ctrl D` to terminate the program.