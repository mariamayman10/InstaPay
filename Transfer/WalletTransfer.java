package Transfer;

import External.BankAPI;
import External.WalletAPI;
import User.User;

public class WalletTransfer extends Transfer{

    private String PhoneNum;
    WalletTransfer(double Amount, User Sender,String Reciever) {
        super(Amount, Sender);
        PhoneNum=Reciever;

    }

    @Override
    boolean checkBalance() {
        return sender.getBalance()>amount;
    }

    @Override
    boolean withdraw() {
        sender.withdraw(amount);
        return true;
    }

    @Override
    boolean sendFunds() {
        WalletAPI endpoint=new WalletAPI();
        return endpoint.withdraw(amount,sender.getSource());
    }
}
