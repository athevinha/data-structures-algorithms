public class Cylinder extends Circle {
    private double height;

    /**
     * Constructs a Cylinder with default values.
     */
    public Cylinder() {
    }

    /**
     * Constructs a Cylinder with the given height.
     *
     * @param height The height of the Cylinder.
     */
    public Cylinder(double height) {
        this.height = height;
    }

    /**
     * Constructs a Cylinder with the given radius and height.
     *
     * @param radius The radius of the base circle.
     * @param height The height of the Cylinder.
     */
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    /**
     * Constructs a Cylinder with the given radius, height, and color.
     *
     * @param radius The radius of the base circle.
     * @param height The height of the Cylinder.
     * @param color  The color of the Cylinder.
     */
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    /**
     * Gets the height of the Cylinder.
     *
     * @return The height of the Cylinder.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the Cylinder.
     *
     * @param height The height to set.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Calculates and returns the volume of the Cylinder.
     *
     * @return The volume of the Cylinder.
     */
    public double getVolume() {
        return Math.PI * getRadius() * getRadius() * height;
    }

    /**
     * Calculates and returns the total surface area of the Cylinder.
     *
     * @return The total surface area of the Cylinder.
     */
    public double getSurfaceArea() {
        return 2 * Math.PI * getRadius() * (getRadius() + height) + 2 * super.getArea();
    }

    /**
     * Returns a formatted string representation of the Cylinder.
     *
     * @return A string representation of the Cylinder.
     */
    @Override
    public String toString() {
        return "Cylinder[Circle[radius=" + getRadius() + ", color="
                + getColor() + "], height=" + height + "]";
    }
}
