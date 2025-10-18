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

    // Getter 
    public String getSpecialization() {
        return specialization;
    }

    // Setter 
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
                ", patients=" + patients.stream() 
                                        .map(Patient::getName) 
                                        .toList() + 
                '}';
    }
}
