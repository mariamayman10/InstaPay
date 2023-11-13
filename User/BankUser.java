package User;
import Source.*;
public class BankUser extends User{
    Bank bankCard;
    @Override
    void deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }

    @Override
    void withdraw(double amount) {
        this.setBalance(this.getBalance() + amount);
    }
}
