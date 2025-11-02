import java.time.LocalDate;

/**
 * Model class representing a medication in the pharmacy system.
 *
 * Stores medication properties (id, name, dose, quantityInStock, expiryDate).
 * This class is intended for use by prescription classes and inventory/tracking components.
 *
 * Author: Brandon Maloney
 * Updated by: Abiodun Magret Oyedele
 * Date: 2025-10-18
 */
public class Medication {
    private String id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    /**
     * Constructor for the Medication class.
     * Initializes the medication with an ID, name, dose, quantity in stock, and expiry date.
     */
    public Medication(String id, String name, String dose, int quantityInStock, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = expiryDate;
    }

    /**
     * Getter for the ID of the medication.
     * @return the ID of the medication
     */
    public String getID() { return id; }

    /**
     * Sets the ID of the medication.
     * @param id the new ID of the medication
     */
    public void setID(String id) { this.id = id; }

    /**
     * Gets the name of the medication.
     * @return the name of the medication
     */
    public String getName() { return name; }

    /**
     * Sets the name of the medication.
     * @param name the new name of the medication
     */
    public void setName(String name) { this.name = name; }

    /**
     * Getter for the dose of the medication.
     * @return the dose of the medication
     */
    public String getDose() { return dose; }

    /**
     * Sets the dose of the medication.
     * @param dose the new dose of the medication
     */
    public void setDose(String dose) { this.dose = dose; }

    /**
     * Getter for the quantity in stock of the medication.
     * @return the quantity in stock of the medication
     */
    public int getQuantityInStock() { return quantityInStock; }

    /**
     * Sets the quantity in stock of the medication.
     * @param quantityInStock the new quantity in stock of the medication
     */
    public void setQuantityInStock(int quantityInStock) { this.quantityInStock = quantityInStock; }

    /**
     * Getter for the expiry date of the medication.
     * @return the expiry date of the medication
     */
    public LocalDate getExpiryDate() { return expiryDate; }

    /**
     * Sets the expiry date of the medication.
     * @param expiryDate the new expiry date of the medication
     */
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    /*
     * Overridden toString method to provide a string representation of the Medication object.
     * @return string representation of the Medication
     */
    @Override
    public String toString() {
        return "Medication ID = " + id + ", Name = " + name + ", Dose = " + dose + ", Quantity In Stock = " + quantityInStock + ", Expiry Date = " + expiryDate;
    }
}