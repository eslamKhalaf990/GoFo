public class LogIn {
    private Player player;
    private PlaygroundOwner playgroundOwner;
    private boolean foundInPlayground;
    private boolean foundInPlayer;

    /**
     * Constructor that takes parameters to check if the user is in the system as a playground owner or as a player or not found in the system
     * @param email to pass the email
     * @param password to pass the password
     */
    LogIn(String email, String password)
    {
        for(int i=0;i<Register.getOwnerList().size(); i++)
        {
            if (Register.getOwnerList().get(i).email.equals(email)
                    && Register.getOwnerList().get(i).password.equals(password))
            {
                foundInPlayground = true;
                playgroundOwner = Register.getOwnerList().get(i);
                break;
            }
        }
        if (!foundInPlayground)
        {
            for (int i = 0; i < Register.getPlayerList().size(); i++)
            {
                if (Register.getPlayerList().get(i).email.equals(email)
                        && Register.getPlayerList().get(i).password.equals(password))
                {
                    foundInPlayer = true;
                    player = Register.getPlayerList().get(i);
                    break;
                }
            }
            if (!foundInPlayer)
            {
                System.out.println("Not Found!");
            }
        }
    }

    /**
     *getter for the player
     * @return
     */
    Player getPlayer()
    {
        return player;
    }

    /**
     *getter for the playground owner
     * @return
     */
    PlaygroundOwner getPlaygroundOwner()
    {
        return playgroundOwner;
    }

    /**
     *function to show if it is a player account
     * @return true or false
     */
    boolean isPlayerAccount ()
    {
        return foundInPlayer;
    }

    /**
     *function to show if it is a playground account
     * @return true or false
     */
    boolean isPlaygroundAccount ()
    {
        return foundInPlayground;
    }
}
