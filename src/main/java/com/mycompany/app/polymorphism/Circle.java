
public class Circle extends Shape{
    protected double radius;
    public Circle() {
        super();
    }
    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    public Circle(String color, Boolean filled,double Radius ) {
        super(color, filled);
        this.radius = Radius;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", color=" + color + ", filled=" + filled + "]";
    }
}
