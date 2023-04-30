/*
  Name: Your Name
  PID:  A12345678
 */

/**
 * StandardPassenger Class
 * @author Aneesh Pamula
 * @since  4/29/2023
 */
public class StandardPassenger extends Passenger{

    public StandardPassenger(String username, String bio){
        super(username, bio);
        this.passengerID = 0;
    }

    public String displayName() {
        return this.username;
    }
}
