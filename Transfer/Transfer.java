package Transfer;
import User.*;
public abstract class Transfer {
    protected double amount;
    protected User sender;
    public abstract boolean transfer();
    private boolean checkBalance(double amount){
        return true;
    }
    protected boolean withdraw(){
        return true;
    }
    protected boolean sendFunds(){
        return true;
    }
}
