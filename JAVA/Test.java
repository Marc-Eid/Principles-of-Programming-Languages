

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {

	public static void main(String[] args) {

		try (BufferedReader input = new BufferedReader(new FileReader("shapes.txt"))) {
			String line = "";
			ArrayList<Shape> shapes = new ArrayList<>();
			// check line is not null
			while ((line = input.readLine()) != null) {

				String[] rows = line.split(",");
				if (rows.length == 3) {
					// Add to shapes list
					shapes.add(Rectangle.parse(line));

				} else {
					// Add to shapes list
					shapes.add(Circle.parse(line));
				}
			}
			// Compare shape objects, Sort shape by name and area
			Collections.sort(shapes, new Comparator<Shape>() {
				public int compare(Shape shape1, Shape shape2) {
					if (shape1.getName().compareTo(shape2.getName()) > 0) {
						return 1;
					} else if (shape1.getName().compareTo(shape2.getName()) < 0) {
						return -1;
					} else {
						if (shape1.getArea() > shape2.getArea()) {
							return 1;
						} else if (shape1.getArea() < shape2.getArea()) {
							return -1;
						}
						return 0;

					}
				}
			});
			// Iterate shapes
			for (Shape shape : shapes) {
				Printable printable = (Printable) shape;
				// call print method
				printable.print();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

