package Transfer;

import External.*;
import User.User;

public class WalletTransfer extends Transfer{

    private final String phoneNo;
    public WalletTransfer(double Amount, User Sender,String receiver) {
        super(Amount, Sender);
        phoneNo = receiver;

    }

    @Override
    void withdraw() {
        sender.withdraw(amount);
    }

    @Override
    void deposit() {
        WalletAPI endpoint=new WalletAPI();
        endpoint.deposit(amount,phoneNo);
    }

    @Override
    public void printtrans() {
        System.out.print("\nWalletTransfer\nAmount : "+amount+"\nReceiver : "+phoneNo+"\n");
    }
}
