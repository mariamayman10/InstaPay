package Transfer;
import User.*;
public  class Transfer {
    protected double amount;
    protected User sender;
    private TransferStrategy ts;

    public Transfer(double amount,User sender) {
        this.amount = amount;
        this.sender = sender ;
    }
    public double getAmount() {
        return amount;
    }

    public boolean transfer(){
        if(sender.getBalance()>amount){
            sender.withdraw(amount);
            return ts.transfer(amount);
        }
        else{
            System.out.println("No enough balance...");
            return false;
        }
    }

    public void SetTransferStrategy(TransferStrategy strategy){
        ts=strategy;
    }
    public void printtrans(){
        ts.printtrans();
        System.out.println("Amount : "+amount);
    }
}
