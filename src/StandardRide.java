import java.util.ArrayList;

public class StandardRide implements RideScheduler{

    private final String MISMATCH_MSG =
            "Each passenger should have one vehicle matched.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public StandardRide(){
        vehicles = new ArrayList<Vehicle>();
        passengers = new ArrayList<Passenger>();
        assignments = new ArrayList<String>();
    }


    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }


    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }


    public boolean addPassenger(Passenger p) {
        if(this.passengers.contains(p))
            return false;
        this.passengers.add(p);
        return true;
    }

    public boolean addVehicle(Vehicle v) {
        if(this.vehicles.contains(v))
            return false;
        this.vehicles.add(v);
        return true;
    }

    public void assignPassengerToVehicle() throws OperationDeniedException {
        if(vehicles.size() != passengers.size())
            throw new OperationDeniedException(MISMATCH_MSG);

        //Sort all vehicles by vehicle ID
        ArrayList<Vehicle> economyVehicles = new ArrayList<Vehicle>();
        ArrayList<Vehicle> premiumVehicles = new ArrayList<Vehicle>();
        for(Vehicle v : this.vehicles){
            if(v.getVehicleID() == 1)
                premiumVehicles.add(v);
            else
                economyVehicles.add(v);
        }
        vehicles = new ArrayList<Vehicle>();
        vehicles.addAll(economyVehicles);
        vehicles.addAll(premiumVehicles);

        //Sort all passengers by passengerID
        ArrayList<Passenger> standardPassengers = new ArrayList<Passenger>();
        ArrayList<Passenger> valuePassengers = new ArrayList<Passenger>();
        for(Passenger p : this.passengers){
            if(p.getPassengerID() == 1)
                valuePassengers.add(p);
            else
                standardPassengers.add(p);
        }
        passengers = new ArrayList<Passenger>();
        passengers.addAll(standardPassengers);
        passengers.addAll(valuePassengers);

        //Check if every StandardPassenger has a ride
        if(standardPassengers.size() < economyVehicles.size())
            throw new OperationDeniedException(INVALID_ACTION);

        //Add passengers to vehicles and update assignments
        for(int i = 0; i < this.passengers.size(); i++)
            vehicles.get(i).addPassengerToVehicle(passengers.get(i));
        for(int i = 0; i < this.passengers.size(); i++)
            assignments.add(vehicles.get(i).getVehicleInfo());
    }


    public ArrayList<String> getRecords() {
        return assignments;
    }
}
