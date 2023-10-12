
public class Square extends Rectangle {
    public Square() {
        super();
    }
    public Square(double side) {
        super(side, side);
    }
    public Square(double side, String color, Boolean filled ) {
        super(side, side, color, filled);
    }
    public double getSide() {
        return width;
    }
    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }
    @Override
    public void setWidth(double width) {
        super.width = width;
    }

    @Override
    public void setLength(double length) {
        super.length = length;
    }

    /**
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Square [side=" + width + ", color=" + color + ", filled=" + filled + "]";
    }


}
