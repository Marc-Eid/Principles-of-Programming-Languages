// -----------------------------------------------------
// Assignment (number #1)
// Part: (part 1)
// -----------------------------------------------------

public class Circle extends PrintableObject implements Shape {
    
	private double radius;

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * no arg constructor
     */
    public Circle() {

    }

    /**
     * @param radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.getArea();
    }

    
    /**
     *
     * @param input
     * @return an instantiated Circle
     */
    public static Circle parse(String input) {
// split by comma
        String[] parsedInput = input.split(",");
        double radius = Double.parseDouble(parsedInput[1]);
// instantiate and return new Circle
        return new Circle(radius);
    }

    
    
    /**
     * return the perimeter of circle
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * return the area of circle
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
// return name in ALL_CAPS
        return super.getName();
    }

	@Override
	public double getInRadius() {
		
		return 0;
	}

}
