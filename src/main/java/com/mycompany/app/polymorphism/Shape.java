public abstract class Shape {
    protected String color;
    protected boolean filled;
    public Shape() {
    }
    public Shape(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();

}
