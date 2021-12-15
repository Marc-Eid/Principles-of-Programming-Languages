
// -----------------------------------------------------
// Assignment (number #1)
// Part: (part 1)
// -----------------------------------------------------

/** PrintableObject abstract class **/
public abstract class PrintableObject implements NamedObject, Printable {
    /**
     * overridden, returns the object's name by calling getName() method.
     */
    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * prints the text returned by toString() method
     */
    @Override
    public void print() {
        System.out.println(toString());
    }
}