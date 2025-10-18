import java.time.LocalDate;

public class MedicationTest {
    public static void main(String[] args) {
        // Test medication 
        Medication med = new Medication(
            "M001",
            "Amoxicillin",
            "500mg",
            30,
            LocalDate.of(2024, 12, 31)
        );

        System.out.println("Medication Test");
        System.out.println("Name: " + med.getName());
        System.out.println("Dose: " + med.getDose());
        System.out.println("Quantity: " + med.getQuantityInStock());
        System.out.println("Expiry: " + med.getExpiryDate());
        System.out.println("toString(): " + med.toString());

        med.setQuantityInStock(50);
        med.setDose("250mg");

        // Updated values after setter
        System.out.println("\nAfter update:");
        System.out.println("Updated Dose: " + med.getDose());
        System.out.println("Updated Quantity: " + med.getQuantityInStock());
    }
}