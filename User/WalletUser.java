package User;
import Source.*;
public class WalletUser extends User{
    Wallet wallet;
    @Override
    void deposit(double amount) {

        wallet.deposit(amount, wallet.getPhoneNo());
    }
    public WalletUser(String username, String password, String name, String phoneNo, Type type, Wallet wallet) {
        super(username, password, name, phoneNo, type);
        this.wallet = wallet;
    }
    @Override
    double getBalance() {
        return wallet.checkBalance();
    }

    @Override
    void withdraw(double amount) {
        wallet.withdraw(amount, wallet.getPhoneNo());
    }
}
