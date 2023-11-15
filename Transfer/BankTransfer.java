package Transfer;

import External.BankAPI;
import External.WalletAPI;
import User.*;

public class BankTransfer extends Transfer{

    private final String bankAcc;
    public BankTransfer(double Amount, User sender,String receiver) {
        super(Amount, sender);
        bankAcc = receiver;
    }

    @Override
    void withdraw() {
        if(sender.getType() == Type.Bank){
            BankAPI endpoint=new BankAPI();
            endpoint.withdraw(amount, sender.getSource());
        }
        else{
            WalletAPI endpoint=new WalletAPI();
            endpoint.withdraw(amount, sender.getSource());
        }
    }

    @Override
    void deposit() {
        BankAPI endpoint=new BankAPI();
        endpoint.deposit(amount,bankAcc);
    }

    @Override
    public void printtrans() {
        System.out.print("\nBank Transfer\nAmount : "+amount+"\nReceiver : "+bankAcc+"\n");
    }
}
