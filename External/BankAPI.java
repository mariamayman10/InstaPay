package External;

import java.util.Random;

public class BankAPI implements SourceAPI{

    @Override
    public double getBalance(String Id) {
        Random rand=new Random();
        return rand.nextDouble(1000);
    }

    @Override
    public void withdraw(float Amount) {

    }

    @Override
    public void deposit(float amount, String recieverId) {

    }

    @Override
    public boolean Exists(String Id) {
        return true;
    }

    @Override
    public boolean AttachToAccount(String Id) {
        Random rand =new Random();
        System.out.println("OTP is"+rand.nextInt(100000));
    }

}
