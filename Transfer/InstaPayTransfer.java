package Transfer;

import User.User;

public class InstaPayTransfer extends Transfer{
    private final User receiver;

    public InstaPayTransfer( double amount,User sender,User receiver) {
        super(amount,sender);
        this.receiver = receiver;
    }


    @Override
    public void printtrans() {
        System.out.print("InstapayTransfer\nReceiver : "+receiver.getUsername()+"\nAmount : "+amount+"\n");
    }

    @Override
    public void deposit() {
        receiver.deposit(amount);
        receiver.ReceiveTransfer(this);
    }
}
