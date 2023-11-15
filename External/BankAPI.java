package External;

import java.util.Random;

public class BankAPI implements SourceAPI{

    @Override
    public double getBalance(String Id) {
        Random rand = new Random();
        return rand.nextDouble(100000);
    }

    @Override
    public boolean withdraw(double amount,String senderID) {
        return true;
    }

    @Override
    public boolean deposit(double amount, String receiverID) {
        return true;
    }

    @Override
    public boolean Exists(String Id) {
        return true;
    }

    @Override
    public void AttachToAccount(String Id) {
        Random rand =new Random();
        System.out.println("OTP is"+rand.nextInt(100000));
    }

    @Override
    public boolean checkOtp(String Otp) {
        return true;
    }
}
