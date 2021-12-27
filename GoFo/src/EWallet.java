public class EWallet {

    private double balance;

    EWallet (double balance){
        this.balance = balance;
    }

    boolean withDraw(double amount){
        if (balance - amount > 0){
            balance -= amount;
            return true;
        }
        else {
            return false;
        }
    }

    boolean deposit(double amount){
        if (amount > 0){
            balance += amount;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString (){
        return "Your Balance: "+balance;
    }
}
