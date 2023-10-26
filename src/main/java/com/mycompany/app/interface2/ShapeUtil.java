import java.util.List;

/**
 * Utility class for working with shapes.
 */
public class ShapeUtil {

    /**
     * Print the information of shapes in a list.
     *
     * @param shapes the list of shapes
     * @return a string representation of shapes
     */
    public String printInfo(List<GeometricObject> shapes) {
        StringBuilder result = new StringBuilder("Circle:\n");
        for (GeometricObject shape : shapes) {
            if (shape instanceof Circle) {
                result.append(shape.getInfo()).append("\n");
            }
        }

        result.append("Triangle:\n");
        for (GeometricObject shape : shapes) {
            if (shape instanceof Triangle) {
                result.append(shape.getInfo()).append("\n");
            }
        }
        return result.toString();
    }
}
