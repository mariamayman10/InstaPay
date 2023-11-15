package User;
import Source.*;
public class WalletUser extends User{
    Wallet wallet;

    public WalletUser(String username, String password, String phoneNo, Type type, Wallet wallet) {
        super(username, password, phoneNo, type);
        this.wallet = wallet;
    }

    @Override
    public void deposit(double amount) {

        wallet.deposit(amount);
    }
    @Override
    public double getBalance() {
        return wallet.checkBalance();
    }

    @Override
    public String getSource() {
        return wallet.getPhoneNo();
    }

    @Override
    public void withdraw(double amount) {
        wallet.withdraw(amount);
    }
}
