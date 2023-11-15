package Bill;

import User.User;

import java.util.Random;

public class ElectBill extends Bill {
    private long Kwatts;

    public ElectBill(String code){
        super( code);
        Random rand= new Random();
        Kwatts=rand.nextLong(100000);
    }


    @Override
    public void PrintBill(){
        System.out.println("Electric Bill");
        System.out.println("Code: "+code);
        System.out.println("Amount: "+amount);
        System.out.println("Usage Watts : "+Kwatts);
    }
}