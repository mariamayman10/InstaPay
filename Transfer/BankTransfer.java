package Transfer;

import External.BankAPI;
import User.User;

public class BankTransfer extends Transfer{
    BankTransfer(double Amount, User sender) {
        super(Amount, sender);
    }

    @Override
    boolean checkBalance() {
        BankAPI endpoint=new BankAPI();
        return endpoint.getBalance(sender.getSource()) < amount;
    }

    @Override
    boolean withdraw() {
        BankAPI endpoint=new BankAPI();
        return endpoint.withdraw(amount,sender.getSource());
    }

    @Override
    boolean sendFunds() {
        return false;
    }
}
