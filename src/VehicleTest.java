import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    EconomyVehicle v = new EconomyVehicle("Honda");
    @org.junit.jupiter.api.Test
    void getVehicleName() {//Also includes assert test for Vehicle constructor error
        boolean throwsException = false;
        try{
            EconomyVehicle b = new EconomyVehicle(null);
        }
        catch (IllegalArgumentException e){
            throwsException = true;
        }
        assertTrue(throwsException);
        assertEquals(v.getVehicleName(), "Honda");
    }

    @org.junit.jupiter.api.Test
    void getCurrentPassengers() {
        StandardPassenger a = new StandardPassenger("Aneesh", "abc");
        v.addPassengerToVehicle(a);
        ArrayList<Passenger> pass = v.getCurrentPassengers();
        assertEquals(pass.get(0), a);
    }

    @org.junit.jupiter.api.Test
    void getVehicleID() {
        assertEquals(v.getVehicleID(), 0);
    }

}