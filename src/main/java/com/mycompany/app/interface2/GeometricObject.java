
public interface GeometricObject {

    /**
     * Calculates and returns the area of the geometric object.
     *
     * @return The area of the geometric object.
     */
    double getArea();

    /**
     * Calculates and returns the perimeter of the geometric object.
     *
     * @return The perimeter of the geometric object.
     */
    double getPerimeter();

    /**
     * Returns information about the geometric object as a string.
     *
     * @return A string containing information about the geometric object.
     */
    String getInfo();
}