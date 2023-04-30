/*
  Name: Your Name
  PID:  A12345678
 */
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Vehicle Parent Class
 * @author Aneesh Pamula
 * @since  4/29/2023
 */

public abstract class Vehicle {

    private LocalDate date;
    private final String vehicle;
    protected final ArrayList<Passenger> currentPassengers;
    protected final ArrayList<String> passengerNames;
    protected int vehicleID;

    public Vehicle(String VehicleName) throws IllegalArgumentException {
        this.date = LocalDate.now();
        if (VehicleName == null)
            throw new IllegalArgumentException();
        vehicle = VehicleName;
        currentPassengers = new ArrayList<>();
        passengerNames = new ArrayList<>();
    }

    public LocalDate getDate(){
        return this.date;
    }

    public String getVehicleName(){
        return this.vehicle;
    }

    public ArrayList<Passenger> getCurrentPassengers(){
        return this.currentPassengers;
    }

    public Integer getVehicleID() {
        return this.vehicleID;
    }

    public abstract boolean addPassengerToVehicle(Passenger p)
            throws OperationDeniedException;

    public abstract String getVehicleInfo();
}
