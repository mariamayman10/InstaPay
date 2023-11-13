package User;
import Source.*;
public class WalletUser extends User{
    Wallet wallet;

    public WalletUser(String username, String password, String name, String phoneNo, Type type) {
        super(username, password, name, phoneNo, type);
    }

    @Override
    public void deposit(double amount) {

        wallet.deposit(amount, wallet.getPhoneNo());
    }
    public WalletUser(String username, String password, String name, String phoneNo, Type type, Wallet wallet) {
        super(username, password, name, phoneNo, type);
        this.wallet = wallet;
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
        wallet.withdraw(amount, wallet.getPhoneNo());
    }
}
