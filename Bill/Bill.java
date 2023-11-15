package Bill;
import External.UtilAPI;
import User.*;
public abstract class Bill {
    protected double amount;
    protected String code;
    protected String receiver;
    protected UtilAPI Comp;

    public Bill(String code){
        this.code = code;

    }

    public double getAmount(){
        return amount;
    }

    public String getReceiver() {
        return receiver;
    }

    public boolean PayBill(){
        Comp.BillPayed(this);
        return true;
    }
    abstract public void PrintBill();
    public void setComp(UtilAPI api){
        Comp=api;
        amount=api.getAmount(code);
        receiver=api.getAccount(code);
    }
}

