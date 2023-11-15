package External;

import Source.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class WalletAPI implements SourceAPI{
    static List<Wallet> wallets = new ArrayList<>();

    @Override
    public double getRandom() {
        Random rand = new Random();
        return rand.nextDouble(100000);
    }

    @Override
    public double getBalance(String Id) {
        for (Wallet wallet : wallets) {
            if (Objects.equals(wallet.getPhoneNo(), Id)) return wallet.checkBalance();
        }
        return 0;
    }

    @Override
    public void withdraw(double amount,String senderID) {
        for (Wallet wallet : wallets) {
            if (wallet.getPhoneNo().equals(senderID)) {
                wallet.setBalance(wallet.checkBalance() - amount);
            }
        }
    }

    @Override
    public boolean deposit(double amount, String receiverID) {
        for (Wallet wallet : wallets) {
            if (wallet.getPhoneNo().equals(receiverID)) {
                wallet.setBalance(wallet.checkBalance() + amount);
            }
        }
        return false;
    }

    @Override
    public boolean Exists(String Id) {
        return true;
    }
    public void addWallet(Wallet w){
        wallets.add(w);
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
