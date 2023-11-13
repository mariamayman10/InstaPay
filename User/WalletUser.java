package User;
import Source.*;
public class WalletUser extends User{
    Wallet wallet;
    @Override
    void deposit(double amount) {

        wallet.deposit(amount, wallet.getPhoneNo());
    }

    @Override
    double getBalance() {
        return wallet.checkBalance();
    }

    @Override
    void withdraw(double amount) {
        wallet.withdraw(amount);
    }
}
