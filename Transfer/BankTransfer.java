package Transfer;

import External.BankAPI;
import User.User;

public class BankTransfer extends Transfer{

    private String BankAcc;
    BankTransfer(double Amount, User sender,String Reciever) {
        super(Amount, sender);
        BankAcc=Reciever;
    }

    @Override
    boolean checkBalance() {
        return sender.getBalance() > amount;
    }

    @Override
    boolean withdraw() {
        BankAPI endpoint=new BankAPI();
        return endpoint.withdraw(amount,sender.getSource());
    }

    @Override
    boolean sendFunds() {
        BankAPI endpoint=new BankAPI();
        return endpoint.deposit(amount,BankAcc);
    }
}
