package External;

import Source.Bank;
import Source.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class BankAPI implements SourceAPI{
    static List<Bank> cards = new ArrayList<>();

    @Override
    public double getRandom() {
        Random rand = new Random();
        return rand.nextDouble(100000);
    }

    @Override
    public double getBalance(String Id) {
        for (Bank card : cards) {
            if (Objects.equals(card.getCardNo(), Id)) return card.checkBalance();
        }
        return 0;
    }

    @Override
    public void withdraw(double amount,String senderID) {
        for (Bank card : cards) {
            if (card.getCardNo().equals(senderID)) {
                card.setBalance(card.checkBalance() - amount);
            }
        }
    }

    @Override
    public void deposit(double amount, String receiverID) {
        for (Bank card : cards) {
            if (card.getCardNo().equals(receiverID)) {
                card.setBalance(card.checkBalance() + amount);
            }
        }
    }

    @Override
    public boolean Exists(String Id) {
        return true;
    }
    public void addCard(Bank bankcard){
        cards.add(bankcard);
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
