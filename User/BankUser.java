package User;
import Source.*;
public class BankUser extends User{
    Bank bankCard;
    public BankUser(String username, String password, String name, String phoneNo, Type type, Bank card) {
        super(username, password, name, phoneNo, type);
        this.bankCard = card;
    }

    @Override
    void deposit(double amount) {
        bankCard.deposit(amount, bankCard.getCardNo());
    }

    @Override
    double getBalance() {
        return bankCard.checkBalance();
    }

    @Override
    void withdraw(double amount) {
        bankCard.withdraw(amount, bankCard.getCardNo());
    }
}
