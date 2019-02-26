package home.exer2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tzeni
 */
public class TransportVehicle {

	// Stores Kodikos Oximatos
	private String Id;

	// Stores pliroma
	private List<Employee> crew;
	private double volume;
	private double weight;
	private List<Application> applications;

	// Stores the volume of the pickup
	private double pickupVolume;
	// Stores the weight of the pickup
	private double pickupWeight;

	public TransportVehicle(String id, List<Employee> crew, double volume, double weight) {
		Id = id;

		this.crew = crew;
		this.volume = volume;
		this.weight = weight;
		applications = new ArrayList<>();
		pickupVolume = 0;
		pickupWeight = 0;
	}

	// Copy constructor
	public TransportVehicle(TransportVehicle tv) {
		crew = new ArrayList<>();
		applications = new ArrayList<>();
		Id = tv.Id;

		for (Employee em : tv.getCrew()) {
			if (em.getClass().equals(Driver.class)) {
				crew.add(new Driver((Driver) em));
			}
			if (em.getClass().equals(Transporter.class)) {
				crew.add(new Transporter((Transporter) em));
			}
		}
		volume = tv.volume;
		weight = tv.weight;
		for (Application app : tv.getApplications()) {

			applications.add(new Application(app));
		}
		pickupVolume = tv.pickupVolume;
		pickupWeight = tv.pickupWeight;

	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public List<Employee> getCrew() {
		return crew;
	}

	public void setCrew(List<Employee> crew) {
		this.crew = crew;
	}

	public List<Application> getApplications() {
		return applications;
	}

	/**
	 * Adds the application to the list and updates the volume and weight of the
	 * pickup
	 *
	 * @param app the application to be serviced by the truck
	 */
	public void setApplication(Application app) {

		if (fits(app)) {
			this.applications.add(app);
			pickupVolume += app.getTotalVolume();
			pickupWeight += app.getTotalWeight();
		}
	}

	/**
	 * Checks to see if new devices are fitting to the truck
	 *
	 * @return
	 */
	public boolean fits(Application app) {
		double totalVolume = 0;
		double totalWeight = 0;
		for (Application a : applications) {
			totalVolume += a.getTotalVolume();
			totalWeight += a.getTotalWeight();
		}

		if (totalVolume + app.getTotalVolume() <= volume && totalWeight + app.getTotalWeight() <= weight) {
			return true;
		}

		return false;

	}

	public String stringFormat() {
		String result = Id + " ";
		for (Employee em : crew) {
			result += "\t"+em.getName() + "\t";
		}
		result += volume + "\t"+ "\t" + "\t"  + weight;
		return result;

	}

	@Override
	public String toString() {
		String result = "\t" + "<ΟΧΗΜΑ>" + "\n" + "\t" + "\t" + "<ΟΦΕΛΙΜΟ_ΦΟΡΤΙΟ>" + weight + "</ΟΦΕΛΙΜΟ_ΦΟΡΤΙΟ>" + "\n"
				+ "\t" + "\t" + "<ΟΦΕΛΙΜΟΣ_ΟΓΚΟΣ>" + volume + "</ΟΦΕΛΙΜΟΣ_ΟΓΚΟΣ>" + "\n" + "\t" + "\t"
				+ "<ΟΓΚΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + pickupVolume + "</ΟΓΚΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + "\n" + "\t" + "\t" + "<ΒΑΡΟΣ_ΑΠΚΟΜΙΔΗΣ>"
				+ pickupWeight + "</ΒΑΡΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + "\n" + "\t" + "\t" + "<ΠΛΗΡΩΜΑ>" + "\n";
		for (Employee em : crew) {
			result += em;
		}
		result += "\t" + "\t" + "<ΣΥΣΚΕΥΕΣ>" + "\n";
		for (Application app : applications) {
			for (Appliance a : app.getDevices()) {
				result += a + "\n";
			}
		}
		result += "\t" + "\t" + "</ΣΥΣΚΕΥΕΣ>" + "\n";
		result += "\t" + "</ΟΧΗΜΑ>";
		return result;
	}

}
