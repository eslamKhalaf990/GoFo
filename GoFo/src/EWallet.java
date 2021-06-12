public class EWallet {

    private double balance;

    /**
     * Constructor that takes parameter
     * @param balance to pass the balance
     */
    EWallet (double balance){
        this.balance = balance;
    }

    /**
     *Boolean function help the user withdraw amount of money and check if its ok to withdraw or not
     * @param amount to check if the amount of money is enough or not
     * @return true or false
     */
    boolean withDraw(double amount){
        if (balance - amount > 0){
            balance -= amount;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Boolean function help the user deposit amount of money and check that he did not but a minus value
     * @param amount to check if the amount that the user want to deposit is positive or not
     * @return true or false
     */
    boolean deposit(double amount){
        if (amount > 0){
            balance += amount;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *override the function toString in the object class to display the current Balance
     * @return the current Balance
     */
    @Override
    public String toString (){
        return "Your Balance: "+balance;
    }
}
