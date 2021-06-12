import java.util.ArrayList;

public class PlaygroundOwner  {

    String name;
    String phone;
    String location;
    String email;
    String password;
    String id;
    Playground playground;
    EWallet eWallet;
    static ArrayList <PlaygroundOwner> ownerList = new ArrayList<>();
    static ArrayList <Object> playgroundList = new ArrayList<>();
    ArrayList <Playground> hisPlaygroundList = new ArrayList<>();

    /**
     * Constructor that takes parameters
     * @param email to pass the email of the owner
     * @param password to pass the password
     * @param name to pass the name
     * @param phone to pass the phone number
     * @param location to pass the location
     * @param id to pass the id of the playground owner
     * @param eWallet
     */
    PlaygroundOwner(String email, String password, String name, String phone, String location, String id, EWallet eWallet){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.eWallet = eWallet;
        this.id = id;
        ownerList.add(this);
    }

    /**
     * a function to add a new playground
     * @param playground
     */
    void addPlayground(Playground playground)
    {

        this.playground = playground;

        playground.setOwner(email);

        playgroundList.add(playground);
        hisPlaygroundList.add(playground);
    }

    /**
     * getter to show a specific playground owner
     * @param index
     * @return
     */
    public static PlaygroundOwner getOwnerList(int index)
    {
        return ownerList.get(index - 1);
    }

    /**
     * getter to show the owners list
     * @return
     */
    public static ArrayList<PlaygroundOwner> getOwnerList()
    {
        return ownerList;
    }

    /**
     * getter to show a specific playground
     * @param index
     * @return
     */
    static Playground getPlaygroundList(int index)
    {
        return (Playground) playgroundList.get(index-1);
    }

    /**
     * getter to shaw the playgrounds list
     * @return
     */
    static ArrayList <Object> getPlaygroundList()
    {
        return  playgroundList;
    }

    /**
     * function to find an owner of a playground by his email
     * @param email
     * @return the owner
     */
    public static PlaygroundOwner findOwnerByEmail(String email)
    {

        for (int i=1; i<=getOwnerList().size(); i++)
        {
            if (getOwnerList(i).email.equals(email))
            {
                return getOwnerList(i);
            }
            System.out.println(false);
        }
        return null;
    }

    /**
     * function to show the playground list of the owner
     * @return
     */
    public ArrayList <Playground> viewHisPlaygroundList(){
        return hisPlaygroundList;
    }

    /**
     *override the function toString in the object class to display the information about the playground owner
     * @return
     */
    @Override
    public String toString(){
        return "\nName: "+name +"\n"+ "Phone: "+phone +"\n"+"Location: "+location+"\n";
    }
}
