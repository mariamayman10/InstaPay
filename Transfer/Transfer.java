package Transfer;
import User.*;
public  abstract class Transfer {
    protected double amount;
    protected User sender;


    public Transfer(double amount,User sender) {
        this.amount = amount;
        this.sender = sender ;
    }


    public double getAmount() {
        return amount;
    }

    public boolean transfer(){
        if(checkBalance()){
            withdraw();
            deposit();
            sender.AddTransfer(this);
            return true;
        }
        return false;
    }
public abstract void printtrans();
public void withdraw(){
    sender.withdraw(amount);
}
public abstract void deposit();
public boolean checkBalance(){
    return sender.getBalance()>amount;
}


}
