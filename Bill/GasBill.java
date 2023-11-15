package Bill;

import User.User;

import java.util.Random;

public class GasBill extends Bill{
    private long CubicMetre ;

    public GasBill(String code){
        super(code);
        Random rand=new Random();
        CubicMetre=rand.nextLong(100000);
    }

    @Override
    public void PrintBill(){
        System.out.println("Gas Bill");
        System.out.println("Code: "+code);
        System.out.println("Amount: "+amount);
        System.out.println("Usage Cubic metre : "+CubicMetre);

    }
}
