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

    void addPlayground(Playground playground) {

        this.playground = playground;

        playground.setOwner(name);

        playgroundList.add(playground);
    }

    public static PlaygroundOwner getOwnerList(int index) {
        return ownerList.get(index - 1);
    }

    public static ArrayList<PlaygroundOwner> getOwnerList() {
        return ownerList;
    }

    static Playground getPlaygroundList(int index){
        return (Playground) playgroundList.get(index-1);
    }

    static ArrayList <Object> getPlaygroundList(){
        return  playgroundList;
    }

    public static PlaygroundOwner findOwnerByEmail(String email){

        for (int i=1; i<=getOwnerList().size(); i++){
            if (getOwnerList(i).email.equals(email)){
                return getOwnerList(i);
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "\nName: "+name +"\n"+ "Phone: "+phone +"\n"+"Location: "+location+"\n";
    }
}
