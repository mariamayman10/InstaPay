package Transfer;

import External.BankAPI;
import User.User;

public class BankTransfer extends Transfer{

    private final String bankAcc;
    public BankTransfer(double Amount, User sender,String receiver) {
        super(Amount, sender);
        bankAcc = receiver;
    }

    @Override
    boolean withdraw() {
        sender.withdraw(amount);
        return true;
    }

    @Override
    boolean sendFunds() {
        BankAPI endpoint=new BankAPI();
        return endpoint.deposit(amount,bankAcc);
    }

    @Override
    public void printtrans() {
        System.out.print("BankpayTransfer\nAmount : "+amount+"\nReciever : "+bankAcc+"\n");
    }
}
