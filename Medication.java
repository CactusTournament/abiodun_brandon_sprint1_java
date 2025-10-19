import java.time.LocalDate;

/**
 * Model class representing a medication in the pharmacy system.
 *
 * Stores medication properties (id, name, dose, quantityInStock, expiryDate).
 * This class is intended for use by prescription classes and inventory/tracking components.
 *
 * Author: Brandon Maloney
 * Date: 2025-10-18
 */
public class Medication {
    private String id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    public Medication(String id, String name, String dose, int quantityInStock, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = expiryDate;
    }

    public String getID() { return id; }
    public void setID(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }

    public int getQuantityInStock() { return quantityInStock; }
    public void setQuantityInStock(int quantityInStock) { this.quantityInStock = quantityInStock; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    @Override
    public String toString() {
        return "Medication ID = " + id + ", Name = " + name + ", Dose = " + dose + ", Quantity In Stock = " + quantityInStock + ", Expiry Date = " + expiryDate;
    }
}