package home.exer2;

import java.util.List;

/**
 * 
 * @author Tzeni
 */

public class Application {

	private int Id;
	private String location;
	private List<Appliance> devices;
	// If true the application has been serviced
	private Boolean checked;
	// Number of pickUp handling the application
	private int pickId;

	public Application(int id, String location, List<Appliance> devices) {
		Id = id;
		this.location = location;
		this.devices = devices;
		checked = false;
		pickId = 0;
	}
//Copy constructor

	public Application(Application app) {
		Id = app.Id;
		location = app.location;

		for (Appliance a : app.getDevices()) {
			devices.add(new Appliance(a));
		}

		checked = app.checked;

		pickId = app.pickId;

	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(PickUp pkup) {
		this.location = pkup.getDisposalPointAddress();
	}

	public List<Appliance> getDevices() {
		return devices;
	}

	public void setDevices(List<Appliance> devices) {
		this.devices = devices;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}

	/*
	 * Computes the total weight of the devices
	 * 
	 * @return
	 */
	public double getTotalWeight() {
		double result = 0;
		for (Appliance a : devices) {
			result += a.getWeight();
		}

		return result;
	}

	/*
	 * Computes the total volume of the devices
	 * 
	 * @return
	 */
	public double getTotalVolume() {
		double result = 0;
		for (Appliance a : devices) {
			result += a.getVolume();
		}
		return result;
	}

	public int getPickId() {
		return pickId;
	}

	public void setPickId(int pickId) {
		this.pickId = pickId;
	}

	

	@Override
	public String toString() {
		String result = Id + "\t" + "\t" + location ;
		for (Appliance a : devices) {
			result += a.stringFormat() +" "+ "\t";
		}

		return result.trim();
	}

}
