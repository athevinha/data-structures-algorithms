/**
 *  a car, a specific type of vehicle.
 */
class Car extends Vehicle {
    private int numberOfDoors;

    /**
     * Constructs a new Car with the specified brand, model, registration number.
     *
     * @param brand             The brand of the car.
     * @param model             The model of the car.
     * @param registrationNumber The registration number of the car.
     * @param owner             The owner of the car.
     * @param numberOfDoors     The number of doors in the car.
     */
    public Car(String brand,
               String model,
               String registrationNumber,
               Person owner,
               int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Get the number of doors in the car.
     *
     * @return The number of doors in the car.
     */
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    /**
     * Set the number of doors in the car.
     *
     * @param numberOfDoors The new number of doors in the car.
     */
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Get information about the car.
     *
     * @return A string containing information about the car.
     */
    @Override
    public String getInfo() {
        return String.format("Car:\n"
                        + "\tBrand: %s\n"
                        + "\tModel: %s\n"
                        + "\tRegistration Number: %s\n"
                        + "\tNumber of Doors: %d\n"
                        + "\tBelongs to %s", getBrand(), getModel(), getRegistrationNumber(),
                numberOfDoors, getOwner());
    }
}
