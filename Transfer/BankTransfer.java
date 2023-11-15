package Transfer;

import External.BankAPI;
import User.User;

public class BankTransfer implements TransferStrategy{

    private final String bankAcc;
    public BankTransfer(String receiver) {
        bankAcc = receiver;
    }


    @Override
    public boolean transfer(double amount) {
        BankAPI endpoint=new BankAPI();
        return endpoint.deposit(amount,bankAcc);
    }

    @Override
    public void printtrans() {
        System.out.print("Bank Transfer\nReceiver : "+bankAcc+"\n");
    }
}
