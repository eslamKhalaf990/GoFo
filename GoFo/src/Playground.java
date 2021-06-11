import java.util.ArrayList;

public class Playground {

    private String owner;
    private String name;
    private String location;
    private double price;
    private ArrayList <Integer> availableHours;
    Playground(){}
    Playground(String ownerEmail, String name, String location, ArrayList availableHours, double price){
        this.name = name;
        owner = ownerEmail;
        this.location = location;
        this.price = price;
        this.availableHours = availableHours;
    }
    void setOwner (String owner){
        this.owner = owner;
    }
    void bookAPlayground (int hour){

        int index = availableHours.indexOf(hour);
        availableHours.remove(index);

    }
    @Override
    public String toString() {
        return "\nOwner: "+owner + "\n" + name + ", " + location + ", price: " +price + ", " + availableHours+"\n";
    }

    public String getName() {
        return name ;
    }

    public String getLocation() {
        return location;
    }

    public String getOwner() {
        return owner;
    }

    public double getPrice() {
        return price;
    }
}
