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
    boolean withdraw() {
        sender.withdraw(amount);
        return true;
    }

    @Override
    boolean sendFunds() {
        WalletAPI endpoint=new WalletAPI();
        return endpoint.withdraw(amount,phoneNo);
    }
}
