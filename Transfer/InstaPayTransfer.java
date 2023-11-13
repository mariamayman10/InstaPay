package Transfer;

import User.User;

public class InstaPayTransfer extends Transfer{
    private User Reciever;

    InstaPayTransfer(double Amount, User Sender,User reciever) {
        super(Amount, Sender);
        Reciever=reciever;
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
        Reciever.deposit(amount);
        return true;
    }
}
