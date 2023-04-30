import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

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