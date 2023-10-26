/**
 * A class representing a circle that implements the GeometricObject interface.
 */
public class Circle implements GeometricObject {

    public static final double PI = 3.14;
    private Point center;
    private double radius;

    /**
     * Constructs a circle with a given center and radius.
     *
     * @param center the center of the circle
     * @param radius the radius of the circle
     */
    public Circle(Point center, double radius) {
        this.radius = radius;
        this.center = center;
    }

    /**
     * Gets the center of the circle.
     *
     * @return the center of the circle
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Sets the center of the circle.
     *
     * @param center the center of the circle
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Gets the radius of the circle.
     *
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     *
     * @param radius the radius of the circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Returns a formatted string representation of the circle.
     *
     * @return a string representation of the circle
     */
    @Override
    public String getInfo() {
        return String.format("Circle[(%.2f,%.2f),r=%.2f]",
                center.getPointX(),
                center.getPointY(),
                radius);
    }

    /**
     * Calculates and returns the area of the circle.
     *
     * @return the area of the circle
     */
    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * Calculates and returns the perimeter of the circle.
     *
     * @return the perimeter of the circle
     */
    public double getPerimeter() {
        return 2 * PI * radius;
    }
}
