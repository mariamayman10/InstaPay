package Transfer;

import External.BankAPI;
import User.User;

public class BankTransfer extends Transfer{

    private final String bankAcc;
    public BankTransfer( double amount,User sender,String receiver) {
        super(amount,sender);
        this.bankAcc = receiver;
    }

    @Override
    public void printtrans() {
        System.out.print("Bank Transfer\nReceiver : "+bankAcc+"\nAmount : "+amount+"\n");
    }

    @Override
    public void deposit() {
        BankAPI endpoint=new BankAPI();
        endpoint.deposit(amount,bankAcc);
    }
}
