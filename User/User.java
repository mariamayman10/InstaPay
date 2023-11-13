package User;
import Bill.Bill;
import Transfer.Transfer;

import java.util.ArrayList;

public abstract class User {
    private String username;
    private String password;
    private String name;
    private String phoneNo;
    private double balance;
    private Type type;
    private ArrayList<Transfer> Transfers;
    private ArrayList<Bill> Bills;
    public boolean payBill(Bill bill){
        return bill.payBill();
    }
    public boolean transfer(Transfer transfer){
        return transfer.transfer();
    }
    abstract void withdraw(double amount);
    abstract void deposit(double amount);
    abstract double getBalance();

    /*public void setBalance(double balance) {
        this.balance = balance;
    }*/

    public ArrayList<Bill> getBills() {
        return Bills;
    }
    public Type getType() {
        return type;
    }
}
