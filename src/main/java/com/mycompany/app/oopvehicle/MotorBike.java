/**
 * a motorbike, a specific type of vehicle.
 */
class MotorBike extends Vehicle {
    private boolean hasSidecar;

    /**
     * Constructs a new MotorBike with the specified brand, model.
     *
     * @param brand             The brand of the motorbike.
     * @param model             The model of the motorbike.
     * @param registrationNumber The registration number of the motorbike.
     * @param owner             The owner of the motorbike.
     * @param hasSidecar        Whether the motorbike has a sidecar.
     */
    public MotorBike(String brand,
                     String model,
                     String registrationNumber,
                     Person owner,
                     boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    /**
     * Get information about the motorbike.
     *
     * @return A string containing information about the motorbike.
     */
    @Override
    public String getInfo() {
        return String.format("Motor Bike:\n"
                        + "\tBrand: %s\n"
                        + "\tModel: %s\n"
                        + "\tRegistration Number: %s\n"
                        + "\tHas Side Car: %b\n"
                        + "\tBelongs to %s", getBrand(), getModel(),
                getRegistrationNumber(), hasSidecar, getOwner());
    }

    /**
     * Check if the motorbike has a sidecar.
     *
     * @return true if the motorbike has a sidecar, false otherwise.
     */
    public boolean isHasSidecar() {
        return hasSidecar;
    }

    /**
     * Set whether the motorbike has a sidecar.
     *
     * @param hasSidecar true to indicate the motorbike has a sidecar, false otherwise.
     */
    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
