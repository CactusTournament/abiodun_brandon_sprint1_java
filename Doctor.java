import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    // Attributes
    private String specialization;
    private List<Patient> patients;

    // Constructor
    public Doctor(int ID, String name, int age, String phoneNumber, String specialization) {
        super(ID, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Getter for specialization
    public String getSpecialization() {
        return specialization;
    }

    // Setter for specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Manage patients
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "ID=" + getID() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", patients=" + patients.stream() // Takes the patients list (which contains Patient objects) // Converts it into a stream (a way to process elements one by one).
                                        .map(Patient::getName) // Calls the getName() method on each Patient — that’s what .map(Patient::getName) means.
                                        .toList() + // Collects all those names into a List of Strings with .toList().
                '}';
    }
}
