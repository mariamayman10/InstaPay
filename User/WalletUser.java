package User;
import Source.*;
public class WalletUser extends User{
    Wallet wallet;
    public WalletUser(String username, String password, String name, String phoneNo, Type type, Wallet wallet) {
        super(username, password, name, phoneNo, type);
        this.wallet = wallet;
    }
    @Override
    void deposit(double amount) {
        wallet.deposit(amount, this.wallet.getPhoneNo());
    }

    @Override
    double getBalance() {
        return wallet.checkBalance();
    }

    @Override
    void withdraw(double amount) {
        wallet.withdraw(amount, this.wallet.getPhoneNo());
    }
}
