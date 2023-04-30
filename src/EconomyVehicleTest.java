import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EconomyVehicleTest {

    EconomyVehicle v1 = new EconomyVehicle("Accord");
    EconomyVehicle v2 = new EconomyVehicle("Civic");
    EconomyVehicle v3 = new EconomyVehicle("");
    @Test
    void addPassengerToVehicle() {
        StandardPassenger p1 = new StandardPassenger("A", "something1");
        assertTrue(v1.addPassengerToVehicle(p1));
        ValuePassenger p2 = new ValuePassenger("B", "something2");
        assertTrue(v1.addPassengerToVehicle(p2));
        assertFalse(v1.addPassengerToVehicle(p1));
    }

    @Test
    void getVehicleInfo() {
        StandardPassenger p1 = new StandardPassenger("A", "something1");
        v1.addPassengerToVehicle(p1);
        ValuePassenger p2 = new ValuePassenger("B", "something2");
        v1.addPassengerToVehicle(p2);
        v2.addPassengerToVehicle(p1);
        assertEquals(v1.getVehicleInfo(), "Accord [2023-04-29]: [A <Value Passenger> B]");
        assertEquals(v2.getVehicleInfo(), "Civic [2023-04-29]: [A]");
        assertEquals(v3.getVehicleInfo(), " [2023-04-29]: []");
    }
}