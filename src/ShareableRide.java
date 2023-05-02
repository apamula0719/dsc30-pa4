import java.util.ArrayList;

public class ShareableRide implements RideScheduler{

    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private final int CARPOOL_LIMIT = 5;

    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public ShareableRide(){
        vehicles = new ArrayList<Vehicle>();
        passengers = new ArrayList<Passenger>();
        assignments = new ArrayList<String>();
    }


    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }


    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }


    public boolean addPassenger(Passenger p) throws OperationDeniedException {
        if(p.getClass() != ValuePassenger.class)
            throw new OperationDeniedException(DENIED_PASSENGER_GROUP);
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
        if(this.vehicles.size()*CARPOOL_LIMIT < this.passengers.size())
            throw new OperationDeniedException(INVALID_ACTION);
        //Add passengers to vehicles
        int j = 0;//Counter for adding passengers
        for(Vehicle v : vehicles){
            if(j == passengers.size())
                break;
            while(v.getCurrentPassengers().size() < 5){
                if(j == passengers.size())
                    break;
                v.addPassengerToVehicle(passengers.get(j));
                j++;
            }
        }
        for(Vehicle v : vehicles)
            assignments.add(v.getVehicleInfo());
    }


    public ArrayList<String> getRecords() {
        return assignments;
    }
}
