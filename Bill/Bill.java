package Bill;
import User.*;
public abstract class Bill {
    protected double amount;
    protected String code;
    protected User receiver;
    public Bill(double amount, String code, User receiver){
        this.amount = amount;
        this.code = code;
        this.receiver = receiver;
    }
    public abstract boolean payBill();
}

