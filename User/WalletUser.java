package User;
import Source.*;
public class WalletUser extends User{
    Wallet wallet;
    @Override
    void deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }
    @Override
    void withdraw(double amount) {
        this.setBalance(this.getBalance() - amount);
    }
}
