package home.exer2;
/**
 * 
 * @author Tzeni
 */

public class Driver extends Employee {

    public Driver(String name, String position) {
        super(name, position);

    }

    //Copy constructor
    public Driver(Driver d) {
        this(d.getName(), d.getPosition());
    }

    @Override
    public String toString() {
        return "\t" + "\t" + "\t" + "<ΟΝΟΜΑ_ΟΔΗΓΟΥ>" + getName() + "</ΟΝΟΜΑ_ΟΔΗΓΟΥ>" + "\n";

    }

}
