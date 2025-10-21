/*
 * Handles Patient class testing.
 * 
 * Author: Abiodun Magret Oyedele
 * Date: 2024-10-21
 */
public class PatientTest {
    public static void main(String[] args) {
        // Create a patient
        Patient patient = new Patient(1, "John Doe", 30, "555-1234");

        // Access patient properties
        System.out.println("\n");
        System.out.println("_____Patient Properties:______");
        System.out.println(patient.getPatientID());
        System.out.println(patient.getName());
        System.out.println(patient.getAge());
        System.out.println(patient.getPhoneNumber());

        // Display patient information
        System.out.println("\n\n");
        System.out.println("_____Patient Information:______");
        System.out.println(patient);
        System.out.println("\n");
    }
}
