package User;
import Source.*;
public class BankUser extends User{
    Bank bankCard;
    @Override
    void deposit(double amount) {
        bankCard.deposit(amount,bankCard.getCardNo());
    }

    @Override
    double getBalance() {
        return bankCard.checkBalance();
    }

    @Override
    void withdraw(double amount) {
        bankCard.withdraw(amount);
    }
}
