import java.util.ArrayList;

public class Playground {

    private String owner;
    private String name;
    private String location;
    private double price;
    private ArrayList <Integer> availableHours;

    /**
     * Default constructor
     */
    Playground(){}

    /**
     * Constructor that takes parameters
     * @param ownerEmail to access the email
     * @param name to access the name
     * @param location to access the location
     * @param availableHours to access the available Hours
     * @param price to access the price
     */
    Playground(String ownerEmail, String name, String location, ArrayList availableHours, double price){
        this.name = name;
        owner = ownerEmail;
        this.location = location;
        this.price = price;
        this.availableHours = availableHours;
    }

    /**
     * setter for the owner
     * @param owner to assign the owner because its a private member
     */
    void setOwner (String owner){
        this.owner = owner;
    }

    /**
     * a function to book a playground
     * @param hour to select the amount of time
     */
    void bookAPlayground (int hour){

        int index = availableHours.indexOf(hour);
        availableHours.remove(index);

    }

    /**
     *override the function toString in the object class to display the information about the Playground
     * @return
     */
    @Override
    public String toString()
    {
        return "\nOwner: "+owner + "\n" + name + ", " + location + ", price: " +price + ", " + availableHours+"\n";
    }

    /**
     *getter for the name
     * @return the name
     */
    public String getName() {
        return name ;
    }

    /**
     * getter for the location
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * getter for the owner
     * @return Owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * getter for the price
     * @return the price
     */
    public double getPrice() {
        return price;
    }
}
