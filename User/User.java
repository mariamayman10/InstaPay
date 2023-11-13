package User;
import Bill.*;
import Transfer.*;
public abstract class User {
    private String username;
    private String password;
    private String name;
    private String phoneNo;
    private double balance;
    private Type type;
    private Transfer[] transfers;
    private Bill[] bills;
    public boolean payBill(Bill bill){
        return bill.payBill();
    }
    public boolean transfer(Transfer transfer){
        return transfer.transfer();
    }
    abstract void withdraw(double amount);
    abstract void deposit(double amount);
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bill[] getBills() {
        return bills;
    }
    public Type getType() {
        return type;
    }
}
