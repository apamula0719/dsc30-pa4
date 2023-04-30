import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumVehicleTest {



    @Test
    void addPassengerToVehicle() throws OperationDeniedException {//Also includes exception for constructor
        PremiumVehicle v1 = new PremiumVehicle("merCeDes");
        PremiumVehicle v2 = new PremiumVehicle("FERRARI");
        boolean throwsException = false;
        //Testing exception throwing for constructor
        try {
            PremiumVehicle v3 = new PremiumVehicle("Accord");
        }
        catch (OperationDeniedException e){
            throwsException = true;
        }
        assertTrue(throwsException);
        //Testing general use of this class
        ValuePassenger p1 = new ValuePassenger("A", "something1");
        ValuePassenger p2 = new ValuePassenger("B", "something2");
        assertTrue(v1.addPassengerToVehicle(p1));
        assertFalse(v1.addPassengerToVehicle(p1));
        assertTrue(v2.addPassengerToVehicle(p1));
        assertTrue(v2.addPassengerToVehicle(p2));
        StandardPassenger p3 = new StandardPassenger("C", "something3");
        //Testing exception throwing for this method
        throwsException = false;
        try {
            v2.addPassengerToVehicle(p3);
        }
        catch (OperationDeniedException e){
            throwsException = true;
        }
        assertTrue(throwsException);
    }

    @Test
    void getVehicleInfo() throws OperationDeniedException {
        PremiumVehicle v1 = new PremiumVehicle("merCeDes");
        assertEquals(v1.getVehicleInfo(), "merCeDes (Premium) [2023-04-29]: []");
    }
}