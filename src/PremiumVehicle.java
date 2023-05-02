/**
 * Premium Vehicle Class
 * @author Aneesh Pamula
 * @since  4/29/2023
 */
public class PremiumVehicle extends Vehicle{

    // Error message to use in OperationDeniedException
    private static final String INVALID_INPUT =
            "The input vehicle is not a premium vehicle.";
    private static final String [] PREMIUM_VEHICLE_BRAND =
            new String[] {"lamborghini", "ferrari", "bmw", "mercedes","audi"};
    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";

    public PremiumVehicle(String VehicleName)
            throws OperationDeniedException {
        super(VehicleName);
        boolean premium = false;
        for(String s : PREMIUM_VEHICLE_BRAND){
            if(s.toLowerCase().equals(VehicleName.toLowerCase())){
                premium = true;
                break;
            }
        }
        if(!premium)
            throw new OperationDeniedException(INVALID_INPUT);
        this.vehicleID = 1;
    }

    public boolean addPassengerToVehicle(Passenger p)
            throws OperationDeniedException {
        if (this.currentPassengers.contains(p))
            return false;
        if(p.getClass() != ValuePassenger.class)
            throw new OperationDeniedException(DENIED_PASSENGER_GROUP);
        this.currentPassengers.add(p);
        this.passengerNames.add(p.displayName());
        return true;

    }

    // bmw01 (Premium) [2022-10-08]: [<Value Passenger> Yunyi]
    public String getVehicleInfo() {
        String output = this.getVehicleName() + " (Premium) [" + getDate() + "]: [";
        for(int i = 0; i < this.passengerNames.size(); i++){
            if(i < passengerNames.size() -1)
                output += passengerNames.get(i) + ", ";
            else
                output += passengerNames.get(i);
        }
        output += "]";
        return output;
    }
}
