import java.util.ArrayList;

public class Player {
    String name;
    String phone;
    String location;
    String email;
    String password;
    String id;
    EWallet eWallet;
    static ArrayList <Object> playerList = new ArrayList<>();
    static ArrayList <String> bookedPlaygrounds = new ArrayList<>();

    Player(String email, String password, String name, String phone, String location, String id, EWallet eWallet){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.eWallet = eWallet;
        this.id = id;
        playerList.add(this);
    }

    boolean bookAPlayground (int choice, int index, EWallet eWallet, String email){
        PlaygroundOwner playOwner = PlaygroundOwner.findOwnerByEmail(email);

        if (playOwner != null){
            System.out.println(playOwner.eWallet.deposit(PlaygroundOwner.getPlaygroundList(index).getPrice()));
        }
        if (playOwner == null){
            System.out.println("Not Found!");
        }

        PlaygroundOwner.getPlaygroundList(index).bookAPlayground(choice);

        if(eWallet.withDraw(PlaygroundOwner.getPlaygroundList(index).getPrice())){

            String infoOfBookedPlayground = "\nname Of Playground: "+PlaygroundOwner.getPlaygroundList(index).getName() +", Location: " +
                    PlaygroundOwner.getPlaygroundList(index).getLocation() + ", " +
                    PlaygroundOwner.getPlaygroundList(index).getOwner() + "Hour: "+choice + "\n";

            bookedPlaygrounds.add(infoOfBookedPlayground);

            return true;
        }
        else {
            return false;
        }

    }
    public EWallet getEWallet() {
        return eWallet;
    }
    ArrayList <String> getBooked(){
        return bookedPlaygrounds;
    }
    ArrayList<Object> getPlayerList(){
        return playerList;
    }

    @Override
    public String toString(){
        return "\n"+"Name: "+name +"\n"+ "Phone: "+phone +"\n"+"Location: "+location+"\n";
    }
}

