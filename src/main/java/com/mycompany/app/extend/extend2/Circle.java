/**
 * Represents a Circle, a two-dimensional geometric shape defined by its radius and color.
 */
public class Circle {
    private double radius;
    private String color;
    protected static final double PI = 3.14;

    /**
     * Constructs a Circle with default values.
     */
    public Circle() {
    }

    /**
     * Constructs a Circle with the given radius.
     *
     * @param radius The radius of the Circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructs a Circle with the given radius and color.
     *
     * @param radius The radius of the Circle.
     * @param color The color of the Circle.
     */
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    /**
     * Gets the radius of the Circle.
     *
     * @return The radius of the Circle.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the Circle.
     *
     * @param radius The radius to set.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Gets the color of the Circle.
     *
     * @return The color of the Circle.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the Circle.
     *
     * @param color The color to set.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Calculates and returns the area of the Circle.
     *
     * @return The area of the Circle.
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Returns a formatted string representation of the Circle's area.
     *
     * @return A string representation of the Circle's area.
     */
    @Override
    public String toString() {
        return String.valueOf(this.getArea());
    }
}
