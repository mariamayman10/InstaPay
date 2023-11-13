package Bill;
import User.*;
public abstract class Bill {
    protected double amount;
    protected String code;
    protected User receiver;
    public abstract boolean payBill();
}

