import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardPassengerTest {

    @Test
    void displayName() {
        StandardPassenger p1 = new StandardPassenger("abc", "bcd");
        assertEquals(p1.displayName(), "abc");
    }
}