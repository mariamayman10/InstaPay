package Transfer;

import User.User;

public class InstaPayTransfer extends Transfer{
    private final User receiver;

    public InstaPayTransfer(double Amount, User Sender,User receiver) {
        super(Amount, Sender);
        this.receiver = receiver;
    }

    @Override
    void withdraw() {
        sender.withdraw(amount);
    }

    @Override
    void deposit() {
        receiver.deposit(amount);
        receiver.AddReceiver(this);
    }

    @Override
    public void printtrans() {
        System.out.print("InstaPay Transfer\nAmount : "+amount+"\nReciever : "+receiver.getUsername());
    }
}
