package home.exer2;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Tzeni
 */

public class PickUp {

    private Officer officer;
    private Date disposalDate;
    private Integer disposalNumber;
    private DisposalPoint disposalPoint;
    private List<Application> applications;
    private List<TransportVehicle> transportVehicles;
    //Stores the volume of the pickup
    private double totalVolume;
    //Stores the weight of the pickup
    private double totalWeight;

    public PickUp(Officer officer, Date disposalDate, int disposalNumber, DisposalPoint disposalPoint,
            List<Application> applications, List<TransportVehicle> transportVehicles) {
        this.officer = officer;
        this.disposalDate = disposalDate;
        this.disposalNumber = disposalNumber;
        this.disposalPoint = disposalPoint;
        this.applications = applications;
        this.setTransportVehicles(transportVehicles);
        setTotalWeight();
        setTotalVolume();
        setPickId();
    }

    public String getDisposalPointAddress() {
        return disposalPoint.getAddress();
    }

    public void setDisposalPoint(DisposalPoint disposalPoint) {
        this.disposalPoint = disposalPoint;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    public Date getDisposalDate() {
        return disposalDate;
    }

    public void setDisposalDate(Date disposalDate) {
        this.disposalDate = disposalDate;
    }

    public int getDisposalNumber() {
        return disposalNumber;
    }

    public void setDisposalNumber(int disposalNumber) {
        this.disposalNumber = disposalNumber;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public List<TransportVehicle> getTransportVehicles() {
        return transportVehicles;
    }

    public void setTransportVehicles(List<TransportVehicle> transportVehicles) {
        this.transportVehicles = transportVehicles;

    }

    public DisposalPoint getDisposalPoint() {
        return disposalPoint;
    }

    public double getTotalVolume() {

        return totalVolume;
    }

    /**
     * Computes the volume of the pickup
     */
    private void setTotalVolume() {
        for (Application app : applications) {
            totalVolume += app.getTotalVolume();
        }

    }

    public double getTotalWeight() {

        return totalWeight;
    }

    /**
     * Computes the total weight of the pickup
     */
    private void setTotalWeight() {
        for (Application app : applications) {
            totalWeight += app.getTotalWeight();
        }

    }

    /**
     * Sets the pickup number to the application
     */
    private void setPickId() {
        for (Application app : applications) {
            app.setPickId(disposalNumber);
        }
    }

    @Override
    public String toString() {
        String result = "<ΑΠΟΚΟΜΙΔΗ>" + "\n" + "\t" + "<ΑΡΙΘΜΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + disposalNumber + "</ΑΡΙΘΜΟΣ_ΑΠΟΚΟΜΙΔΗΣ>"
                + "\n" + "\t" + "<ΗΜΕΡΟΜΗΝΙΑ_ΑΠΟΚΟΜΙΔΗΣ>" + disposalDate + "</ΗΜΕΡΟΜΗΝΙΑ _ΑΠΟΚΟΜΙΔΗΣ>" + "\n" + "\t"
                + "<ΟΓΚΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + totalVolume + "</ ΟΓΚΟΣ _ΑΠΟΚΟΜΙΔΗΣ>" + "\n" + "\t" + "<ΒΑΡΟΣ_ΑΠΟΚΟΜΙΔΗΣ>"
                + totalWeight + "</ΒΑΡΟΣ_ΑΠΟΚΟΜΙΔΗΣ>" + "\n";

        for (TransportVehicle trv : transportVehicles) {
            result += trv + "\n";

        }
        result += "</ΑΠΟΚΟΜΙΔΗ>" + "\n";

        return result;
    }

}
