package External;

import Bill.Bill;
import User.User;

import java.util.Random;

public class UtilAPI {
    private UtilAcc CompanyAcc;
    public float getAmount(String Code){
        Random rand = new Random();
        return rand.nextFloat(1000);
    }
    public User getAccount(String Code){
        return UtilAcc;
    }

    public void BillPayed(Bill bill){
    }
}
