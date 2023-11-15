package Transfer;
import User.*;
public abstract class Transfer {
    protected double amount;
    protected User sender;

    Transfer(double amount,User sender) {
        this.amount = amount;
        this.sender = sender ;
    }
    public double getAmount() {
        return amount;
    }

    public boolean transfer(){
        if(checkBalance(this.amount)){
            this.withdraw();
            this.deposit();
            return true;
        }
        else{
            System.out.println("No enough balance...");
            return false;
        }
    }

    protected boolean checkBalance(double amount){
        return sender.getBalance() >= amount;
    }
    abstract void withdraw();
    abstract void deposit();
    public abstract void printtrans();
}
