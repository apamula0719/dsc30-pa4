/*
  Name: Your Name
  PID:  A12345678
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * JUnit Tests
 * @author Aneesh Pamula
 * @since  5/1/2023
 */
public class RideSchedulerApplicationTest {
    ValuePassenger yunyi;
    static LocalDate date = LocalDate.now();



    @BeforeEach
    public void setup() throws OperationDeniedException {
        yunyi = new ValuePassenger("Yunyi", "Tutor");
    }

    @Test
    public void testValuePassengerThrowsIAE() {
        assertThrows(IllegalArgumentException.class, () -> {
            ValuePassenger yunyi = new ValuePassenger("Yunyi", null);
        });
    }
    //Vehicle Tests
    static class VehicleTest {
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
    //Economy Vehicle Tests
    static class EconomyVehicleTest {

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
            assertEquals(v1.getVehicleInfo(), "Accord [" + RideSchedulerApplicationTest.date + "]: [A, <Value Passenger> B]");
            assertEquals(v2.getVehicleInfo(), "Civic [" + RideSchedulerApplicationTest.date + "]: [A]");
            assertEquals(v3.getVehicleInfo(), " [" + RideSchedulerApplicationTest.date + "]: []");
        }
    }

    //Premium Vehicle Tests
    static class PremiumVehicleTest {



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
            assertEquals(v1.getVehicleInfo(), "merCeDes (Premium) [" +
                    RideSchedulerApplicationTest.date +"]: []");
        }
    }

    //Passenger Class Tests
    static class PassengerTest {

        StandardPassenger p1 = new StandardPassenger("A", "something1");
        ValuePassenger p2 = new ValuePassenger("B", "something2");


        @Test
        void setBio() {
            boolean throwsException = false;
            try{
                StandardPassenger p3 = new StandardPassenger("C", null);
            }
            catch(IllegalArgumentException e){
                throwsException = true;
            }
            assertTrue(throwsException);
            throwsException = false;
            try{
                p1.setBio(null);
            }
            catch(IllegalArgumentException e){
                throwsException = true;
            }
            assertTrue(throwsException);
            p1.setBio("somethingNew");
            assertEquals(p1.displayBio(), "somethingNew");

        }

        @Test
        void displayBio() {
            p2.setBio("someNewThing");
            assertEquals(p2.displayBio(), "someNewThing");
        }

        @Test
        void getPassengerID() {
            assertEquals(p1.getPassengerID(), 0);
        }

    }

    //Standard Passenger Tests
    static class StandardPassengerTest {

        @Test
        void displayName() {
            StandardPassenger p1 = new StandardPassenger("abc", "bcd");
            assertEquals(p1.displayName(), "abc");
        }
    }

    //Value Passenger Tests
    static class ValuePassengerTest {
        ValuePassenger p2 = new ValuePassenger("DEF", "I like flowers");
        @Test
        void displayName() {
            assertEquals(p2.displayName(), "<Value Passenger> DEF");
        }

        @Test
        void setCustomTitle() {
            p2.setCustomTitle("The Best");
            assertEquals(p2.displayName(), "<The Best> DEF");
        }
    }

    //Standard Ride Tests
    static class StandardRideTest {
        StandardRide ride = new StandardRide();

        @Test
        void getVehicles() {
            EconomyVehicle v = new EconomyVehicle("Honda");
            ride.addVehicle(v);
            ArrayList<Vehicle> testVehicles = ride.getVehicles();
            assertEquals(testVehicles.get(0), v);
        }

        @Test
        void getPassengers() {
            StandardPassenger p = new StandardPassenger("A", "something1");
            ride.addPassenger(p);
            ArrayList<Passenger> testPassengers = ride.getPassengers();
            assertEquals(testPassengers.get(0), p);
        }

        @Test
        void addPassenger() {
            StandardPassenger p1 = new StandardPassenger("A", "something1");
            ValuePassenger p2 = new ValuePassenger("B", "something2");
            assertTrue(ride.addPassenger(p1));
            assertTrue(ride.addPassenger(p2));
            assertFalse(ride.addPassenger(p1));
        }

        @Test
        void addVehicle() {
            EconomyVehicle v1 = new EconomyVehicle("Accord");
            EconomyVehicle v2 = new EconomyVehicle("Civic");
            assertTrue(ride.addVehicle(v1));
            assertTrue(ride.addVehicle(v2));
            assertFalse(ride.addVehicle(v1));
        }

        @Test
        void assignPassengerToVehicle() throws OperationDeniedException {//Also tests getRecords()
            StandardPassenger p1 = new StandardPassenger("A", "something1");
            ValuePassenger p2 = new ValuePassenger("B", "something2");
            StandardPassenger p3 = new StandardPassenger("C", "something3");

            EconomyVehicle v1 = new EconomyVehicle("Accord");
            PremiumVehicle v2 = new PremiumVehicle("Mercedes");
            EconomyVehicle v3 = new EconomyVehicle("Odyssey");

            ride.addVehicle(v1);
            ride.addPassenger(p1);
            ride.addVehicle(v2);

            boolean throwsException = false;
            try{
                ride.assignPassengerToVehicle();
            }
            catch(OperationDeniedException e){
                throwsException = true;
            }
            assertTrue(throwsException);

            ride.addPassenger(p3);

            throwsException = false;
            try{
                ride.assignPassengerToVehicle();
            }
            catch(OperationDeniedException e){
                throwsException = true;
            }

            ride.addPassenger(p2);
            ride.addVehicle(v3);
            ride.assignPassengerToVehicle();

            ArrayList<String> records = ride.getRecords();
            String stringRecords = "";
            for(String record : records)
                stringRecords += record + "\n";
            assertEquals(stringRecords, "Accord ["+ RideSchedulerApplicationTest.date + "]: [A]\n" +
                    "Odyssey ["+ RideSchedulerApplicationTest.date + "]: [C]\n" +
                    "Mercedes (Premium) ["+ RideSchedulerApplicationTest.date + "]: " +
                    "[<Value Passenger> B]\n");

        }

    }

    static class ShareableRideTest {

        ShareableRide ride = new ShareableRide();
        @Test
        void getVehicles() {
            EconomyVehicle v = new EconomyVehicle("Honda");
            ride.addVehicle(v);
            ArrayList<Vehicle> testVehicles = ride.getVehicles();
            assertEquals(testVehicles.get(0), v);
        }

        @Test
        void getPassengers() throws OperationDeniedException {
            StandardPassenger p1 = new StandardPassenger("A", "something1");
            ValuePassenger p2 = new ValuePassenger("B", "something2");
            boolean throwsException =  false;
            try {
                ride.addPassenger(p1);
            }
            catch(OperationDeniedException e){
                throwsException = true;
            }
            assertTrue(throwsException);
            ride.addPassenger(p2);
            ArrayList<Passenger> testPassengers = ride.getPassengers();
            assertEquals(testPassengers.get(0), p2);
        }

        @Test
        void addPassenger() throws OperationDeniedException {
            StandardPassenger p1 = new StandardPassenger("A", "something1");
            ValuePassenger p2 = new ValuePassenger("B", "something2");
            ValuePassenger p3 = new ValuePassenger("C", "something3");
            boolean throwsException =  false;
            try {
                ride.addPassenger(p1);
            }
            catch(OperationDeniedException e){
                throwsException = true;
            }
            assertTrue(throwsException);
            assertTrue(ride.addPassenger(p2));
            assertFalse(ride.addPassenger(p2));
            assertTrue(ride.addPassenger(p3));
        }

        @Test
        void addVehicle() {
            EconomyVehicle v1 = new EconomyVehicle("Accord");
            EconomyVehicle v2 = new EconomyVehicle("Civic");
            assertTrue(ride.addVehicle(v1));
            assertTrue(ride.addVehicle(v2));
            assertFalse(ride.addVehicle(v1));
        }

        @Test
        void assignPassengerToVehicle() throws OperationDeniedException {//Also tests getRecords
            ValuePassenger p1 = new ValuePassenger("A", "something1");
            ValuePassenger p2 = new ValuePassenger("B", "something2");
            ValuePassenger p3 = new ValuePassenger("C", "something3");
            ValuePassenger p4 = new ValuePassenger("D", "something4");
            ValuePassenger p5 = new ValuePassenger("E", "something5");
            ValuePassenger p6 = new ValuePassenger("F", "something6");

            PremiumVehicle v1 = new PremiumVehicle("Mercedes");
            EconomyVehicle v2 = new EconomyVehicle("Accord");

            ride.addPassenger(p1);
            ride.addPassenger(p2);
            ride.addPassenger(p3);
            ride.addPassenger(p4);
            ride.addPassenger(p5);
            ride.addPassenger(p6);
            ride.addVehicle(v1);

            boolean throwsException = false;
            try{
                ride.assignPassengerToVehicle();
            }
            catch(OperationDeniedException e){
                throwsException = true;
            }
            assertTrue(throwsException);

            ride.addVehicle(v2);

            ride.assignPassengerToVehicle();
            ArrayList<String> records = ride.getRecords();
            String stringRecords = "";
            for(String record : records)
                stringRecords += record + "\n";
            assertEquals(stringRecords, "Mercedes (Premium) ["+ RideSchedulerApplicationTest.date
                    + "]: [<Value Passenger> A, <Value Passenger> B, <Value Passenger> C, " +
                    "<Value Passenger> D, <Value Passenger> E]\nAccord ["+
                    RideSchedulerApplicationTest.date + "]: [<Value Passenger> F]\n");
        }

    }
}
