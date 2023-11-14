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
        BankAPI endpoint=new BankAPI();
        return endpoint.withdraw(amount,sender.getSource());
    }

    @Override
    boolean sendFunds() {
        BankAPI endpoint=new BankAPI();
        return endpoint.deposit(amount,bankAcc);
    }
}
