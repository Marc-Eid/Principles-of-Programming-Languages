import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DriverClass {

	public static <R> void main(String[] args) {
		
		//open the file. 
		try (BufferedReader input = new BufferedReader(new FileReader("shapes.txt"))) {
	           
        	 
        	
        	//get the number of inputs dynamically
			Stream<String> lines = Files.lines(Paths.get("shapes.txt"));

			//convert the stream into an array. 
			String[] shapesString = (String[]) lines.toArray(String[]::new);

			lines.close();
            		
            //make and arraylist of type Shape. store the new objects in it. the arraylist is prefferable since we dont know the real number of objects to
			//be created since there can be a faulty input. 
            ArrayList<Shape> shapes = new ArrayList<Shape>();
            //create the objects based on the name. 
            Arrays.stream(shapesString).forEach(
            		x -> {
            			String[] rows = x.split(",");
            			if(rows.length == 3 && x.split(",")[0].equalsIgnoreCase("rectangle"))
            				shapes.add(Rectangle.parse(x));
            			else if(rows.length == 3 && x.split(",")[0].equalsIgnoreCase("rhombus"))
            				shapes.add(Rhombus.parse(x));
            			else if (rows.length == 2 && x.split(",")[0].equalsIgnoreCase("circle"))
            				shapes.add(Circle.parse(x));
            			else
            				return;
            		}
            		);
            
            //create an array of the same size as the list of objects. then convert this list to the array.
            Shape[] shapess = new Shape[shapes.size()];
            shapes.toArray(shapess);;
          
            
            
            
            
            
            /*
             * here i was trying to convert the stream of objects directly to an array. check what is required. 
             */
            
            
//			Shape[] shapess = (Shape[]) Arrays.stream(shapesString).filter(
//					w ->
//					w.split(",").length == 3 || (w.split(",").length == 2 && w.split(",")[0].equalsIgnoreCase("circle"))
//
//
//					).map(
//							 x -> {
//								String[] rows = x.split(",");
//								if(rows.length == 3 && x.split(",")[0].equalsIgnoreCase("rectangle"))
//									(Shape)	new Rectangle(Double.parseDouble(rows[1]), Double.parseDouble(rows[2]));
//								else if(rows.length == 3 && x.split(",")[0].equalsIgnoreCase("rhombus"))
//									(Shape)	new Rhombus(Double.parseDouble(rows[1]), Double.parseDouble(rows[2]));
//								else 
//									(Shape) new Circle(Double.parseDouble(rows[1]));
//								
//								
//
//
//
//
//							}
//							).toArray();

           
            
            //create a stream of objects. sort the objects with their name and their area. then print them
            System.out.println("Shape Name And Area: ");      
            Arrays.stream(shapess).sorted(Comparator.comparing(Shape::getName).thenComparing(Shape::getArea)).forEach(x ->System.out.printf("%s, %.2f \n",x.getName(), x.getArea()));
            
            System.out.println();
            
            //create a stream of objects and compare them with their perimeter only. then print
            System.out.println("Shape Name And Perimeter:");
            Arrays.stream(shapess).sorted(Comparator.comparing(Shape::getPerimeter)).forEach(x ->System.out.printf("%s, %.2f \n", x.getName(), x.getPerimeter()) );
            
            System.out.println();
            
            System.out.println("Information Summary:");
            
            //create a map. storing the shape name in the key and the area in the value. 
            //merge similar keys together and get their average area. 
            Map<String , Double> area = Arrays.stream(shapess).collect(
            		Collectors.groupingBy( Shape::getName, Collectors.averagingDouble(Shape::getArea))
            		);
            
     
            //create a map. storing the shape name in the key and the perimeter in the value. 
            //merge similar keys together and get their average perimeter. 
            Map<String , Double> perimeter = Arrays.stream(shapess).collect(
            		Collectors.groupingBy( Shape::getName, Collectors.averagingDouble(Shape::getPerimeter))
            		);



            //create a stream of strings from the two previous maps. format the strings. 
            Stream<String> a = area.entrySet().stream().map(x -> String.format("Average area of %s is %.2f\n", x.getKey(), x.getValue()));
            Stream<String> b = perimeter.entrySet().stream().map(  x -> String.format("Average perimeter of %s is %.2f\n", x.getKey(), x.getValue()));

            //concatenate the two previous streams. and order them according to the 3rd word in the string. so that it prints all the information 
            //of each shape consecutively. 
            Stream.concat(a, b).sorted(Comparator.comparing( x -> x.toString().split(" ")[3]    )).forEachOrdered(System.out::print);


            //create a map. storing the shape name in the key and the inradius in the value. 
            //merge similar keys together and get their average inradius. 
            Map<String , Double> inRadius = Arrays.stream(shapess).filter(x -> x.getName().equalsIgnoreCase("rhombus")).collect(
            		Collectors.groupingBy( Shape::getName, Collectors.averagingDouble(Shape::getInRadius))
            		);


            //create a stream of the inradius Map and then print
            inRadius.entrySet().stream().forEachOrdered(
            		x -> System.out.printf( "Average inRadius of %s is %.2f\n", x.getKey(), x.getValue())


            		);


            //////////////////////////////////////////////////
            
            //from the array of objects, create a stream, and get their average areas. 
            Double areaTotAvg = Arrays.stream(shapess).collect(
            		Collectors.averagingDouble(Shape::getArea)
            		
            		
            		);
            
     
            //from the array of objects, create a stream and get their average perimeters
            Double perimeterTotAvg = Arrays.stream(shapess).collect(
            		Collectors.averagingDouble(Shape::getPerimeter)

            		);

        


            System.out.println();
            System.out.println("Total Averages: ");
            System.out.printf("Average area of all shapes is %.2f\n", areaTotAvg);	
            System.out.printf("Average perimeter of all shapes is %.2f\n", perimeterTotAvg );
            
            //the total number of shapes is the size of the array of objects. 
            System.out.println("The total number of shapes is " + shapes.size());
           
            
            
            
            
            
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

	}



}
