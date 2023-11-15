package Transfer;
import User.*;
public abstract class Transfer {
    protected double amount;
    protected User sender;

    Transfer(double amount,User sender) {
        this.amount = amount;
        this.sender = sender ;
    }
    public User getSender() {
        return sender;
    }
    public double getAmount() {
        return amount;
    }

    public boolean transfer(){
        if(checkBalance(this.amount)){
            withdraw();
            return sendFunds();
        }
        else{
            System.out.println("No enough balance...");
            return false;
        }
    }

    protected boolean checkBalance(double amount){
        return sender.getBalance() >= amount;
    }
    abstract boolean withdraw();
    abstract boolean sendFunds();
    public abstract void printtrans();
}
