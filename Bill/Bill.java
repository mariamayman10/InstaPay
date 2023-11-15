package Bill;
import User.*;
public abstract class Bill {
    protected double amount;
    protected String code;
    protected String receiver;
    public Bill(double amount, String code, String receiver){
        this.amount = amount;
        this.code = code;
        this.receiver = receiver;
    }
    public abstract boolean payBill();
    public double getAmount(){
        return amount;
    }

    public String getReceiver() {
        return receiver;
    }
    public void PrintBill(){
        System.out.println("Code: "+code);
        System.out.println("Amount: "+amount);
    }
}

