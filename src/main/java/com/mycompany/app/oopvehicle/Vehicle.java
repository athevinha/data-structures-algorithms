/**
 * A vehicle.
 */
public abstract class Vehicle {
    private String brand;
    private String model;
    private String registrationNumber;
    private Person owner;

    /**
     * Constructs a new Vehicle with the specified brand.
     *
     * @param brand             The brand of the vehicle.
     * @param model             The model of the vehicle.
     * @param registrationNumber The registration number of the vehicle.
     * @param owner             The owner of the vehicle.
     */
    public Vehicle(
            String brand,
            String model,
            String registrationNumber,
            Person owner) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }

    /**
     * Get information about the vehicle.
     *
     * @return A string containing information about the vehicle.
     */
    public abstract String getInfo();

    /**
     * Transfer the ownership of the vehicle to a new owner.
     *
     * @param newOwner The new owner of the vehicle.
     */
    public void transferOwnership(Person newOwner) {
        this.owner = newOwner;
    }

    /**
     * Get the brand of the vehicle.
     *
     * @return The brand of the vehicle.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Set the brand of the vehicle.
     *
     * @param brand The new brand of the vehicle.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get the model of the vehicle.
     *
     * @return The model of the vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Set the model of the vehicle.
     *
     * @param model The new model of the vehicle.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Get the registration number of the vehicle.
     *
     * @return The registration number of the vehicle.
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Set the registration number of the vehicle.
     *
     * @param registrationNumber The new registration number of the vehicle.
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * Get the owner of the vehicle.
     *
     * @return The owner of the vehicle.
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Set the owner of the vehicle.
     *
     * @param owner The new owner of the vehicle.
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
