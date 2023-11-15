package Transfer;

import External.*;
import User.User;

public class WalletTransfer implements TransferStrategy{

    private final String phoneNo;
    public WalletTransfer(String receiver) {
        phoneNo = receiver;

    }
    @Override
    public boolean transfer(double amount) {
        WalletAPI endpoint=new WalletAPI();
        return endpoint.deposit(amount,phoneNo);
    }

    @Override
    public void printtrans() {
        System.out.print("WalletTransfer\nReciever : "+phoneNo+"\n");
    }
}
