import java.util.ArrayList;

public class Register{
    static ArrayList <Player> playerList = new <Player>ArrayList <Player>();
    static ArrayList <PlaygroundOwner> ownerList = new <PlaygroundOwner>ArrayList <PlaygroundOwner>();

    Register(PlaygroundOwner owner) {
        ownerList.add(owner);
    }

    Register(Player player) {
        playerList.add(player);
    }

    static ArrayList <PlaygroundOwner> getOwnerList(){
        return ownerList;
    }

    static ArrayList <Player> getPlayerList(){
        return playerList;
    }
}
