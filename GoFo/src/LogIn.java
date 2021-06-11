public class LogIn {
    private Player player;
    private PlaygroundOwner playgroundOwner;
    private boolean foundInPlayground;
    private boolean foundInPlayer;

    LogIn(String email, String password) {
        for(int i=0;i<(Register.getOwnerList().size() + Register.getPlayerList().size()); i++){
            if (Register.getOwnerList().size()>0 && Register.getOwnerList().get(i).email.equals(email)
                    && Register.getOwnerList().get(i).password.equals(password)){
                foundInPlayground = true;
                playgroundOwner = Register.getOwnerList().get(i);
                break;
            }
            else if(Register.getPlayerList().size()>0 && Register.getPlayerList().get(i).email.equals(email)
                    && Register.getPlayerList().get(i).password.equals(password)) {
                foundInPlayer = true;
                player = Register.getPlayerList().get(i);
                break;
            }
        }
    }
    Player getPlayer(){
        return player;
    }

    PlaygroundOwner getPlaygroundOwner(){
        return playgroundOwner;
    }

    boolean isPlayerAccount (){
        return foundInPlayer;
    }

    boolean isPlaygroundAccount (){
        return foundInPlayground;
    }
}
