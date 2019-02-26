package home.exer2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tzeni
 */

public class Municipality {

    String name;

    List<Employee> employees;
    List<TransportVehicle> vehicles;

    public Municipality(String name, List<Employee> employees, List<TransportVehicle> vehicles) {
        this.name = name;
        this.employees = employees;
        this.vehicles = vehicles;
    }

    public void setVehicles(List<TransportVehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Filters the application list so only applications that fit the trucks are
     * serviced
     *
     * @param officer
     * @param disposalDate
     * @param disposalNumber
     * @param disposalPoint
     * @param applications
     * @return the pickup object
     */
    public PickUp createPickUp(Officer officer, Date disposalDate, Integer disposalNumber, DisposalPoint disposalPoint,
            List<Application> applications) {

        //Creating a list to hold the applications that fit the trucks
        List<Application> validApplications = new ArrayList<>();
        //Creating a list to hold the trucks that will be used by the pickup
        List<TransportVehicle> vehiclesUsed = new ArrayList<>();
        //Algorithm that computes the applications to fit the trucks
        for (Application app : applications) {
            for (TransportVehicle tv : vehicles) {
                if (tv.fits(app)) {
                    tv.setApplication(app);
                    if (!vehiclesUsed.contains(tv)) {
                        vehiclesUsed.add(tv);
                    }
                    validApplications.add(app);
                    //Setting the application as serviced
                    app.setChecked(true);
                    break;
                }

            }
        }
        //Creating the pickup Object
        PickUp pck = new PickUp(officer, disposalDate, disposalNumber, disposalPoint, validApplications, vehiclesUsed);

        return pck;
    }

    @Override
    public String toString() {
        String employeesList = "";
        for (Employee e : employees) {
            employeesList += e + "\n";
        }
        String vehiclesList = "";
        for (TransportVehicle e : vehicles) {
            vehiclesList += e + "\n";
        }

        return "Είδος  Όνομα" + "\n" + employeesList + "\n"
                + "Kωδικός Οχήματος  Οδηγός Μεταφορέας 1 Μεταφορέας 2 Ωφέλιμος Χώρος(μ3) Ωφέλιμο Φορτίο(Κιλά)" + "\n"
                + vehiclesList;
    }

}
