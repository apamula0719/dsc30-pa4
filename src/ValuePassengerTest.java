import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValuePassengerTest {
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