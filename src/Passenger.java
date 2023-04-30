/*
  Name: Your Name
  PID:  A12345678
 */

/**
 * Passenger Parent Class
 * @author Aneesh Pamula
 * @since  4/29/2023
 */
public abstract class Passenger {

    // instance variables
    protected String username;
    protected String bio;
    protected int passengerID;

    public Passenger(String username, String bio) {
        if(username == null || bio == null)
            throw new IllegalArgumentException();
        this.username = username;
        this.bio = bio;

    }

    public void setBio(String newBio) {
        if(newBio == null)
            throw new IllegalArgumentException();
        this.bio = newBio;
    }

    public String displayBio() {
        return this.bio;
    }

    public Integer getPassengerID() {
        return this.passengerID;
    }

    public abstract String displayName();
}
