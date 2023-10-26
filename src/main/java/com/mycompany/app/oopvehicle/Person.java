
import java.util.ArrayList;
import java.util.List;

/**
 * A person who can own vehicles.
 */
class Person {
    private String name;
    private String address;
    private List<Vehicle> vehicleList = new ArrayList<>();

    /**
     * Constructs a new Person with the specified name and address.
     *
     * @param name    The name of the person.
     * @param address The address of the person.
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Get information about the vehicles owned by the person.
     *
     * @return A string containing information about the person's vehicles.
     */
    public String getVehiclesInfo() {
        if (vehicleList.isEmpty()) {
            return name + " has no vehicle!";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(" has:\n\n");
            for (Vehicle vehicle : vehicleList) {
                sb.append(vehicle.getInfo()).append("\n");
            }
            return sb.toString();
        }
    }

    /**
     * Get the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the person.
     *
     * @param name The new name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the address of the person.
     *
     * @return The address of the person.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the person.
     *
     * @param address The new address of the person.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Add a vehicle to the list of vehicles owned by the person.
     *
     * @param vehicle The vehicle to be added.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    /**
     * Remove a vehicle from the list of vehicles owned by the person.
     *
     * @param registrationNumber The registration number of the vehicle to be removed.
     */
    public void removeVehicle(String registrationNumber) {
        vehicleList.removeIf(vehicle -> vehicle.getRegistrationNumber().equals(registrationNumber));
    }

    /**
     * Get a string representation of the person's name and address.
     *
     * @return A string containing the person's name and address.
     */
    @Override
    public String toString() {
        return name + " - " + address;
    }
}
