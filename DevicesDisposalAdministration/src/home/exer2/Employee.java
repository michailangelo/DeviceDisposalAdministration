package home.exer2;

/**
 * 
 * @author Tzeni
 */
public abstract class Employee {

	private String name;
	// Storing eidikotita
	private String position;

	public Employee(String name, String position) {
		super();
		this.name = name;
		this.position = position;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
	
	

	@Override
	public String toString() {
		return   position + " " + name;
	}

}
