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
    - Clicking the run button on your IDE
    - Or using the terminal:
        1. Compile the program: javac Menu.java
        2. Run the program: java Menu
#### 5. Menu Options:
    - When the program starts, you will be provided with menu options. - Click the option corresponding to the action you want to carry out.
#### 6. Input Format:
    - The system uses the Scanner class to take inputs directly from the console.
    - Follow prompts carefully e.g., type doctor names, medication IDs, or quantities as requested.
#### 6. End the program:
    Enter `ctrl D` to terminate the program.

### 1.4 Class Diagram
```
- class Person {
    - int id
    - String name
    - int age
    - String phoneNumber
    + Person(int ID, String name, int age, String phoneNumber)
    + getId()
    + getName()
    + getAge()
    + getPhoneNumber()
    + setId(id)
    + setName(name)
    + setAge(age)
    + setPhoneNumber(phoneNumber)
    + toString()
}

- class Doctor {
    - String specialization    
    - List Patient patients
    + Doctor(int ID, String name, int age, String phoneNumber, String specialization)
    + getSpecialization()
    + setSpecialization(specialization)
    + addPatient(patient)
    + removePatient(patient)
    + getPatients()
    + toString()
}

- class Patient {
    - int patientID`
    - List Prescription prescriptions`
    + Patient(int ID, String name, int age, String phoneNumber)`
    + getPatientID()`
    + addPrescription(pres)`
    + getPrescriptions()`
    + printPrescriptions()`
    + toString()`
}

- class Medication {
    - String id
    - String name
    - String dose
    - int quantityInStock
    - LocalDate expiryDate
    + Medication(String id, String name, String dose, int quantityInStock, LocalDate expiryDate)
    + getId()
    + getName()
    + getDose()
    + getQuantityInStock()
    + getExpiryDate()
    + setId(id)
    + setName(name)
    + setDose(dose)
    + setQuantityInStock(quantity)
    + setExpiryDate(date)
    + toString()
}

class Prescription {
    - String id
    - Doctor doctor
    - Patient patient
    - Medication medication
    - String dosage
    - int prescribedQuantity
    - LocalDate prescriptionExpiry
    - int nextID = 1
    - int prescriptionID
    + Prescription(Patient patient, Doctor doctor, Medication medication, String dosage, int prescribedQuantity)
    + getID()
    + getDoctor()
    + setDoctor()
    + getPatient()
    + setPatient()
    + getMedication()
    + setMedication()
    + getDosage()
    + setDosage()
    + getPrescribedQuantity()
    + setPrescribedQuantity()
    + getPrescriptionExpiry()
    + setPrescriptionExpiry()
    + toString()
}

class MedicationSystem {
    - List Patient patients
    - List Doctor doctors
    - List Medication medications
    - List Prescription prescriptions
    - ChronoLocalDate today
    + MedicationSystem()
    + addMedication(Medication medication)
    + addMedication(String id, String name, String dosage, int quantity, LocalDate expiryDate)
    + addMedication(String identifier)
    + viewMedications()
    + removeMedication(String identifier)
    + removeMedication(Medication medication)
    + editMedication(String identifier, String newName, String newDosage, Integer newQuantity, LocalDate newExpiryDate)
    + editMedication(Medication medication, String newName, String newDosage, Integer newQuantity, LocalDate newExpiryDate)
    + searchAll(String keyword)
    + addPatient(Patient patient)
    + addDoctor(Doctor doctor)
    + addPatientToDoctor(String doctorName, String patientName)
    + acceptPrescription(String patientName, String doctorName, String medicationID, String dosage, int prescribedQuantity)
    + checkExpiredMedications()
    + restockMedications(int amount)
    + linkPrescriptionsToPatients()
    + printPrescriptionsByDoctor(String doctorName)
    + editPatients(String oldName, String name, Integer age, String phoneNumber)
    + editPatients(Patient patient, String name, Integer age, String phoneNumber)
    + removePatient(Patient patient)
    + editDoctors(String oldName, String name, Integer age, String phoneNumber, String specialization)
    + editDoctors(Doctor doctor, String name, Integer age, String phoneNumber, String specialization)
    + removeDoctor(String identifier)
    + removeDoctor(Doctor doctor)
    + generateMedicationReport()
    + generateFullSystemReport()
    + generateAnnualPrescriptionSummary()
}
```

#### Inheritance relationships
- Person inherits from Doctor
- Person inherits from Patient

#### Associations
- One doctor manages many patients
- One patient has many prescriptions
- One prescription is issued by one doctor
- One prescription contains one medication
- One prescription prescribed to one patient
- One medicationsystem manages many doctor
- One medicationsystem manages many patient
- One medicationsystem stores many medication
- One medicationsystem tracks many prescription


### 1.5 Test Files
To ensure that all components of the Pharmacy System work as expected, a set of test files have been provided for each class and the main MedicationSystem.

#### Test File Overview
- **PatientTest.java:**  
  Tests the creation, retrieval, and management of patient information.

- **DoctorTest.java:**  
  Verifies doctor creation, specialization handling, and patient assignment.

- **MedicationTest.java:**  
  Checks medication creation, stock management, and expiration handling.

- **PrescriptionTest.java:**  
  Tests prescription creation, linking between patient, doctor, and medication, and stock reduction.

- **MedicationSystemTest.java:**  
  Ensures overall system integration — adding doctors, patients, medications, and verifying that prescriptions and reports function correctly.

#### How to Run the Tests
1. Open your **IDE** or your **command-line terminal**.  
2. Navigate to each test file.  
3. Run each test file individually using the run 
4. Review the console output. Each test will print messages confirming whether operations succeeded or failed.

> **Note:**  
> These test files validate that all classes and their relationships (such as Doctor–Patient–Prescription) behave correctly and that the overall system performs as intended.


## 2. DEVELOPMENT DOCUMENTATION
### 2.1. Javadocs
All classes, attributes, and methods are documented using **Javadoc comments**, providing clear descriptions of their purpose and usage.
Example:

```
/*
 * Model class representing a patient in the pharmacy system.
 * Stores patient properties (ID, name, age, phoneNumber) 
 * and their list of prescriptions.
 * This class extends the Person class.
 * 
 * Author: Abiodun Magret Oyedele
 * Updated by: Brandon Maloney
 * Date: 2025-10-21
 */

public class Patient extends Person {
    private final int patientID;
    private final List<Prescription> prescriptions;
}
```

### 2.2 Source Code Directory Structure
```
abiodun_brandon_sprint1_java/
    |-- Doctor.java
    |-- DoctorTest.java
    |-- Medication.java
    |-- MedicationTest.java
    |-- MedicationSystem.java
    |-- MedicationSystemTest.java
    |-- Menu.java
    |-- Patient.java
    |-- PatientTest.java
    |-- Person.java
    |-- PersonTest.java
    |-- Prescription.java
    |-- PrescriptionTest.java
    |-- README.md
```

- Each test file contains testing each class independently
- **README.md:** Provides instructions and project overview

### 2.3. Build Process
1. Navigate to the project folder:
    `cd MedicationSystem`
2. Compile all `.java` files:
    `javac *.java`
3. Run the `main` class:
    `java Menu`
> For IDEs like IntelliJ, Eclipse, or VS Code, simply click the run button to compile and execute the program.

### 2.4. Compiler-Time Dependencies
- Java SE Development Kit (JDK 17 or higher)
- No external libraries are required; all functionality uses the Java Standard Library.

### 2.5. Development Standards
- Class names use PascalCase (`MedicationSystem`, `Patient`).
- Method and variable names use camelCase (`addPrescription`, `quantityInStock`).
- Each class is documented with Javadoc comments.
- Input validation is implemented for robust error handling.
- Lists and object references manage entity relationships.

### 2.6. Theoretical Database Design
Even though the system uses in-memory lists, the database could be designed as follows:

#### Entities and Attributes:
- **Patient:** patientID, name, age, phoneNumber.
- **Doctor:** doctorID, name, age, phoneNumber, specialization
- **Medication:** medicationID, name, dose, quantityInStock, expiryDate.
- **Prescription:** prescriptionID, patientID (FK), doctorID (FK), medicationID (FK), dosage, prescribedQuantity, prescriptionExpiry.

#### Entity Relationships:
- One **Doctor** manages many **Patients**.
- One **Patient** can have many **Prescriptions**.
- One **Prescription** is linked to one **Doctor**, one **Patient**, and one **Medication**.
- One **Medication** can appear in many **Prescriptions**.

### 2.7. GitHub Repository
To get the source code:

1. Clone the repository:
`git clone https://github.com/CactusTournament/abiodun_brandon_sprint1_java.git`

2. Navigate to the project directory:
`cd abiodun_brandon_sprint1_java`

3. Compile and run as per the **Build Process** section.

### 8. Testing
Test files are located in the same folder as the source code. Each class has a corresponding test file:
- `MedicationSystemTest.java:` Tests overall system functionalities.
- `PatientTest.java:` Tests patient-related methods.
- `DoctorTest.java:` Tests doctor-related methods
- `MedicationTest.java:` Tests medication-related methods

> Tests use JUnit to validate core functionalities like adding/removing patients, managing prescriptions, and editing medications.