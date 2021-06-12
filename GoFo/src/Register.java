import java.util.ArrayList;

public class Register
{
    static ArrayList <Player> playerList = new <Player>ArrayList <Player>();
    static ArrayList <PlaygroundOwner> ownerList = new <PlaygroundOwner>ArrayList <PlaygroundOwner>();

    /**
     * Constructor that takes parameter
     * @param owner
     */
    Register(PlaygroundOwner owner)
    {
        ownerList.add(owner);
    }

    /**
     * overloaded constructor that takes parameter
     * @param player
     */
    Register(Player player)
    {
        playerList.add(player);
    }

    /**
     * getter for the playground owner list
     * @return a list of a playground owners
     */
    static ArrayList <PlaygroundOwner> getOwnerList()
    {
        return ownerList;
    }

    /**
     * getter for the Player list
     * @return a list of players
     */
    static ArrayList <Player> getPlayerList()
    {
        return playerList;
    }
}
