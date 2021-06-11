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

    void deposit(double amount){
        if (amount > 0){
            balance += amount;
        }
    }

    @Override
    public String toString (){
        return "Your Balance: "+balance;
    }
}
