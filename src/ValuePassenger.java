/*
  Name: Your Name
  PID:  A12345678
 */

/**
 * ValuePassenger class
 * @author Aneesh Pamula
 * @since  4/29/2023
 */
public class ValuePassenger extends Passenger{

    // instance variable
    private String customTitle;

    public ValuePassenger(String username, String bio){
        super(username, bio);
        customTitle = "Value Passenger";
        passengerID = 1;
    }

    public String displayName() {
        return "<" + this.customTitle + "> " + username;
    }

    public void setCustomTitle(String newTitle) {
        this.customTitle = newTitle;
    }
}
