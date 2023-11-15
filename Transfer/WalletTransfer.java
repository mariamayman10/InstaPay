package Transfer;

import External.*;
import User.User;

public class WalletTransfer extends Transfer  {

    private final String phoneNo;
    public WalletTransfer( double amount,User sender,String receiver) {
        super(amount,sender);
        this.phoneNo = receiver;
    }

    @Override
    public void deposit() {
        WalletAPI endpoint=new WalletAPI();
        endpoint.deposit(amount,phoneNo);
    }

    @Override
    public void printtrans() {
        System.out.print("WalletTransfer\nReciever : "+phoneNo+"\nAmount : "+amount+"\n");
    }
}
