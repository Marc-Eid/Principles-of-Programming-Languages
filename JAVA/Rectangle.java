



/**
 * Rectangle class
 */
/**
 * Rectangle class
 */
public class Rectangle extends PrintableObject implements Shape {

    private double side1;
    private double side2;

    /**
     * @return the side1
     */
    public double getSide1() {
        return side1;
    }

    /**
     * @param side1 the side1 to set
     */
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    /**
     * @return the side2
     */
    public double getSide2() {
        return side2;
    }

    /**
     * @param side2 the side2 to set
     */
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    /**
     * no arg constructor
     */
    public Rectangle() {
    }

    /**
     * constructor
     *
     * @param side1
     * @param side2
     */
    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + side1 + ", " + side2;
    }

    /**
     * @param input
     * @return an instantiated rectangle
     */
    public static Rectangle parse(String input) {
// split by comma
        String[] parsedInput = input.split(",");
        double side1 = Double.parseDouble(parsedInput[1]);
        double side2 = Double.parseDouble(parsedInput[2]);
// instantiate and return new Rectangle
        return new Rectangle(side1, side2);
    }

    @Override
    public double getPerimeter() {
        return 2 * (this.side1 + this.side2);
    }

    @Override
    public double getArea() {
        return this.side1 * this.side2;
    }

}
