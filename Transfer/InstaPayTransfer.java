package Transfer;

import User.User;

public class InstaPayTransfer extends Transfer{
    private final User receiver;

    public InstaPayTransfer(double Amount, User Sender,User receiver) {
        super(Amount, Sender);
        this.receiver = receiver;
    }

    @Override
    boolean withdraw() {
        sender.withdraw(amount);
        return true;
    }

    @Override
    boolean sendFunds() {
        receiver.deposit(amount);
        return true;
    }
}
