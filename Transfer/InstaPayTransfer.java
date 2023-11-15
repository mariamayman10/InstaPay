package Transfer;

import User.User;

public class InstaPayTransfer implements TransferStrategy{
    private final User receiver;

    public InstaPayTransfer( User receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean transfer(double amount) {
        receiver.deposit(amount);
        //
        return true;
    }



    @Override
    public void printtrans() {
        System.out.print("InstapayTransfer\nReceiver : "+receiver.getUsername());
    }
}
