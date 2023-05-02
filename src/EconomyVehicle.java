/**
 * EconomyVehicle class
 * @author Aneesh Pamula
 * @since  4/29/2023
 */
public class EconomyVehicle extends Vehicle{

    public EconomyVehicle(String VehicleName) {
        super(VehicleName);
        this.vehicleID = 0;
    }

    public boolean addPassengerToVehicle(Passenger p){
        if (this.currentPassengers.contains(p))
            return false;
        this.currentPassengers.add(p);
        this.passengerNames.add(p.displayName());
        return true;
    }

    // civic [2022-10-08]: [Steven]
    public String getVehicleInfo() {
        String output = this.getVehicleName() + " [" + getDate() + "]: [";
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
