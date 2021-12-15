
import java.util.List;
// -----------------------------------------------------
// Assignment (number #1)
// Part: (part 1)
// -----------------------------------------------------
/** Printable interface  **/
public interface Printable {
    
	public void print();

    public static void print(List<Printable> printables) {
        print(printables);
    }
}
