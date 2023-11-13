package User;
import Source.*;
public class BankUser extends User{
    Bank bankCard;
    public BankUser(String username, String password, String phoneNo, Type type, Bank card) {
        super(username, password,phoneNo, type);
        this.bankCard = card;
    }

    @Override
    public void deposit(double amount) {
        bankCard.deposit(amount, bankCard.getCardNo());
    }

    @Override
    public double getBalance() {
        return bankCard.checkBalance();
    }

    @Override
    public String getSource() {
        return bankCard.getCardNo();
    }

    @Override
    public void withdraw(double amount) {
        bankCard.withdraw(amount, bankCard.getCardNo());
    }


}
