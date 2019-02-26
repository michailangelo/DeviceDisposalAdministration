package home.exer2;

/**
 * 
 * @author Tzeni
 */

public class Appliance {

	private boolean electrical;
	private String name;

	private double height;
	private double width;
	private double length;

	private double volume;
	private double weight;

	public Appliance() {
		electrical = false;
		height = 0;
		width = 0;
		length = 0;
		weight = 0;
		volume = 0;
	}

	public Appliance(String name, double volume, double weight) {
		this.name = name;
		this.volume = volume;
		this.weight = weight;
	}

	// Copy Constructor
	public Appliance(Appliance app) {
		name = app.name;
		volume = app.volume;
		weight = app.weight;

	}

	public boolean isElectrical() {
		return electrical;
	}

	public void setElectrical(boolean electrical) {
		this.electrical = electrical;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	/**
	 * 
	 * @return String representation of the object
	 */
	public String stringFormat() {

		return " " +"\t"+ "\"" + name + "\"" + "," + volume + "μ3," + weight + "Χγρ" + " ";

	}

	@Override
	public String toString() {

		return "\t" + "\t" + "\t" + "<ΣΥΣΚΕΥΗ>" + "\n" + "\t" + "\t" + "\t" + "\t" + "<ΟΝΟΜΑ>" + name + "</ΟΝΟΜΑ>"
				+ "\n" + "\t" + "\t" + "\t" + "\t" + "<ΒΑΡΟΣ>" + weight + "</ΒΑΡΟΣ>" + "\n" + "\t" + "\t" + "\t" + "\t"
				+ "<ΟΓΚΟΣ>" + volume + "</ΟΓΚΟΣ>" + "\n" + "\t" + "\t" + "\t" + "</ΣΥΣΚΕΥΗ>";

	}

}
