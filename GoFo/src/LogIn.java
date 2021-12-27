public class LogIn {
    private Player player;
    private PlaygroundOwner playgroundOwner;
    private boolean foundInPlayground;
    private boolean foundInPlayer;

    LogIn(String email, String password) {
        for(int i=0;i<Register.getOwnerList().size(); i++){
            if (Register.getOwnerList().get(i).email.equals(email)
                    && Register.getOwnerList().get(i).password.equals(password)){
                foundInPlayground = true;
                playgroundOwner = Register.getOwnerList().get(i);
                break;
            }
        }
        if (!foundInPlayground) {
            for (int i = 0; i < Register.getPlayerList().size(); i++) {
                if (Register.getPlayerList().get(i).email.equals(email)
                        && Register.getPlayerList().get(i).password.equals(password)) {
                    foundInPlayer = true;
                    player = Register.getPlayerList().get(i);
                    break;
                }
            }
            if (!foundInPlayer){
                System.out.println("Not Found!");
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
