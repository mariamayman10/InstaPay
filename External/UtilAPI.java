package External;

import Bill.Bill;
import User.User;

import java.util.Random;

public abstract class UtilAPI {

    protected String CompanyAcc;
    UtilAPI(){
        Random rand=new Random();
        CompanyAcc= Integer.toString(rand.nextInt(10000));
    }
    public float getAmount(String Code){
        Random rand = new Random();
        return rand.nextFloat(1000);
    }
    abstract public String getAccount(String Code);
    public void BillPayed(Bill bill){
    }
}
