package Transfer;
import User.*;
public abstract class Transfer {
    protected double amount;
    protected User sender;

    Transfer(double Amount,User Sender) {
        amount = Amount;
        sender = Sender ;
    }
    public User getSender() {
        return sender;
    }
    public double getAmount() {
        return amount;
    }

    public boolean transfer(){
        if(checkBalance()){
            withdraw();
            return sendFunds();
        }
        return false;
    }

    protected boolean checkBalance(){
        return sender.getBalance() > amount;
    }
    abstract boolean withdraw();
    abstract boolean sendFunds();
}
