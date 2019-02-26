package home.exer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		// Creating appliances and applications objects
		Appliance appliance1 = new Appliance("ΚΟΥΖΙΝΑ", 1.0, 90.0);
		Appliance appliance2 = new Appliance("ΨΥΓΕΙΟ", 2.0, 60.0);
		Application app1 = new Application(1, "ΧΑΛΑΝΔΡΙ", Arrays.asList(appliance1, appliance2));

		Appliance appliance3 = new Appliance("ΚΑΤΑΨΥΚΤΗΣ", 1.5, 70.0);
		Appliance appliance4 = new Appliance("ΠΛΥΝΤΗΡΙΟ", 1.0, 110.0);
		Application app2 = new Application(2, "ΜΑΡΟΥΣΙ", Arrays.asList(appliance3, appliance4));

		Appliance appliance5 = new Appliance("ΚΟΥΖΙΝΑ", 0.9, 120.0);
		Appliance appliance6 = new Appliance("ΨΥΓΕΙΟ", 1.8, 90.0);
		Application app3 = new Application(3, "ΦΙΛΟΘΕΗ", Arrays.asList(appliance5, appliance6));

		Appliance appliance7 = new Appliance("ΚΑΤΑΨΥΚΤΗΣ", 1.7, 90.0);
		Appliance appliance8 = new Appliance("ΠΛΥΝΤΗΡΙΟ", 1.2, 130.0);
		Application app4 = new Application(4, "ΓΑΛΑΤΣΙ", Arrays.asList(appliance7, appliance8));

		Appliance appliance9 = new Appliance("ΚΟΥΖΙΝΑ", 1.1, 80.0);
		Appliance appliance10 = new Appliance("ΨΥΓΕΙΟ", 2.1, 50.0);
		Application app5 = new Application(5, "ΝΕΑ ΧΑΛΚΗΔΟΝΑ", Arrays.asList(appliance9, appliance10));

		Appliance appliance11 = new Appliance("ΚΑΤΑΨΥΚΤΗΣ", 1.7, 60.0);
		Appliance appliance12 = new Appliance("ΠΛΥΝΤΗΡΙΟ", 1.2, 100.0);
		Application app6 = new Application(6, "ΜΕΤΑΜΟΡΦΩΣΗ", Arrays.asList(appliance11, appliance12));

		// Creating a list to hold the applications objects
		List<Application> applicationList = new ArrayList<>();
		applicationList.add(app1);
		applicationList.add(app2);
		applicationList.add(app3);
		applicationList.add(app4);
		applicationList.add(app5);
		applicationList.add(app6);

		System.out.println(
				"Αριθμός Αίτησης" + "\t" + "Toποθεσία" + "\t" + "Συσκευή 1" + "\t" + "\t" + "\t" + "\t" + "Συσκευή 2");
		for (Application app : applicationList)
			System.out.print(app + "\n");
		System.out.println();

		// Creating Employee objects
		Officer officer1 = new Officer("Γραφείο 1", "Yπάλληλος Γραφείου");
		Driver driver1 = new Driver("Οδηγός 1", "Οδηγός");
		Driver driver2 = new Driver("Oδηγός 2", "Οδηγός");
		Transporter transporter1 = new Transporter("Μεταφορέας 11", "Mεταφορέας");
		Transporter transporter2 = new Transporter("Μεταφορέας 12", "Mεταφορέας");
		Transporter transporter3 = new Transporter("Μεταφορέας 21", "Mεταφορέας");
		Transporter transporter4 = new Transporter("Μεταφορέας 22", "Mεταφορέας");

		// Creating a list to hold the employee objects
		List<Employee> employees = new ArrayList<>();
		employees.add(officer1);
		employees.add(driver1);
		employees.add(driver2);
		employees.add(transporter1);
		employees.add(transporter2);
		employees.add(transporter3);
		employees.add(transporter4);

		System.out.println("Είδος" + "\t" + "\t" + "\t" + "Όνομα");
		for (Employee e : employees)
			System.out.println("" + e.getPosition() + "  " + "\t" + "\t" + e.getName());
		System.out.println();

		// Creating the Vehicle objects
		TransportVehicle trasportVehicle1 = new TransportVehicle("ΦΟΡΤΗΓΟ 1",
				Arrays.asList(driver1, transporter1, transporter2), 5, 500);

		TransportVehicle trasportVehicle2 = new TransportVehicle("ΦΟΡΤΗΓΟ 2",
				Arrays.asList(driver2, transporter3, transporter4), 7, 600);

		System.out.println("Κωδικός Οχήματος" + " Οδηγός" + "\t" + "\t" + "\t" + "Μεταφορέας1" + "\t" + "\t"
				+ "Μεταφορέας2" + "\t" + "Ωφέλιμος χώρος(μ3)" + "\t" +"Ωφέλιμο φορτίο(Κιλά)");
		System.out.println(trasportVehicle1.stringFormat());
		System.out.println(trasportVehicle2.stringFormat());

		// Creating the municipality object
		Municipality athens = new Municipality("Athens", employees,
				(Arrays.asList(new TransportVehicle(trasportVehicle1), new TransportVehicle(trasportVehicle2))));

		// Creating a list to hold the pickup objects
		List<PickUp> pckups = new ArrayList<>();

		// This list holds the pickups that have been serviced and are ready to be
		// removed
		List<Application> toBeRemoved = new ArrayList<>();
		// The disposal number
		int j = 0;

		while (true) {
			if (applicationList.isEmpty()) {
				break;
			}
			// Creating the pickup object and adding it to the list
			pckups.add(athens.createPickUp(officer1, new Date(), ++j, new DisposalPoint("Patisia"), applicationList));
			// Unloading trucks to be ready for the next pickup
			athens.setVehicles(
					Arrays.asList(new TransportVehicle(trasportVehicle1), new TransportVehicle(trasportVehicle2)));
			// The applications that have been serviced are added to the list to be removed
			for (Application app : applicationList) {
				if (app.isChecked()) {
					toBeRemoved.add(app);
				}
			}
			// Deleting the applications that have been serviced
			applicationList.removeAll(toBeRemoved);

		}
		// Creating a ReportDisposal object
		ReportDisposal rd = new ReportDisposal(pckups);

		// Creates and prints the pickup objects to XML file
		rd.printToXML();

	}

}
