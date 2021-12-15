
// -----------------------------------------------------
// Assignment (number #4)
// Part: (part 1)
// -----------------------------------------------------
/** NamedObject interface **/

public interface NamedObject {
    public default String getName() {
        return this.getClass().getSimpleName();
    }
}
