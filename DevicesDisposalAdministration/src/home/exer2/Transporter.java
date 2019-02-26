package home.exer2;
/**
 * 
 * @author Tzeni
 */

public class Transporter extends Employee {

    public Transporter(String name, String position) {
        super(name, position);
    }

    //Copy constructor
    public Transporter(Transporter ts) {
        this(ts.getName(), ts.getPosition());
    }

    @Override
    public String toString() {
        return "\t" + "\t" + "\t" + "<ΟΝΟΜΑ_ΜΕΤΑΦΟΡΕΑ>" + getName() + "</ΟΝΟΜΑ_ΜΕΤΑΦΟΡΕΑ>" + "\n";

    }

}
