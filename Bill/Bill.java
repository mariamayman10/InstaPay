package Bill;
import External.UtilAPI;
import User.*;
public class Bill {
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
    public void PrintBill(){
        System.out.println("Code: "+code);
        System.out.println("Amount: "+amount);
    }
    public void setComp(UtilAPI api){
        Comp=api;
        amount=api.getAmount(code);
        receiver=api.getAccount(code);
    }
}

