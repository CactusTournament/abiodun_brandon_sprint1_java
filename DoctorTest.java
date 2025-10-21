public class DoctorTest {
    public static void main(String[] args) {
        // Create a doctor
        Doctor doctor = new Doctor(1, "Dr. Smith", 45, "555-8765", "General Practitioner");

        // Access doctor properties
        System.out.println("_____Doctor Properties:______");
        System.out.println(doctor.getID());
        System.out.println(doctor.getName());
        System.out.println(doctor.getAge());
        System.out.println(doctor.getPhoneNumber());
        System.out.println(doctor.getSpecialization());

        // Display doctor information
        System.out.println("\n\n");
        System.out.println("_____Doctor Information:______");
        System.out.println(doctor);

        // Create patients
        Patient patient1 = new Patient(1, "John Doe", 30, "555-1234");
        Patient patient2 = new Patient(2, "Jane Smith", 25, "555-5678");

        // Add patients to the doctor
        System.out.println("\n\n");
        System.out.println("_____Adding Doctor______");
        doctor.addPatient(patient1);
        doctor.addPatient(patient2);

        // Display doctor's patients
        System.out.println("\n\n");
        System.out.println("Doctor's Patients:");
        for (Patient patient : doctor.getPatients()) {
            System.out.println(patient);
        }
    }
}
