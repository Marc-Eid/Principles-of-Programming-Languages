import static java.lang.Math.sqrt;

import java.text.Format;

import static java.lang.Math.pow;

public class Rhombus extends PrintableObject implements Shape {

	private double diagonal1;
	private double diagonal2;
	
	//constructor
	public Rhombus() {
		
	}
	
	public Rhombus(double first, double second) {
		this.diagonal1 = first;
		this.diagonal2 = second;
	}
	
	
	
	
	//getters
	public double getFirstDiagonal() {
		return diagonal1;
	}

	public double getSecondDiagonal() {
		return diagonal2;
	}
	
	//setters
	public void setFisrtDiagonal(double num) {
		this.diagonal1 = num;
	}

	public void setSecondDiagonal(double num) {
		this.diagonal2 = num;
	}
	
	
	public String toString() {
		return super.toString() + ", " + getArea();
	}
	
	
	
	@Override
	public double getPerimeter() {
		
		double side =  Math.sqrt( Math.pow(diagonal1/2 , 2)  +  Math.pow(diagonal2/2 , 2)  );
		return side * 4;
	}

	@Override
	public double getArea() {
		return (diagonal1 * diagonal2) / 2;
	}

	public double getInRadius() {
		
		return (diagonal1 * diagonal2) / ( 2 * sqrt( pow(diagonal1,2) + pow(diagonal2,2)));
	}
	
	
	
    public static Rhombus parse(String input) {
// split by comma
        String[] parsedInput = input.split(",");
        double d1 = Double.parseDouble(parsedInput[1]);
        
        double d2;
        if(parsedInput.length < 3)
        	d2 = d1;
        else
        	d2 = Double.parseDouble(parsedInput[2]);
        
        
        
// instantiate and return new Rectangle
        return new Rhombus(d1, d2);
    }
	
	
}
