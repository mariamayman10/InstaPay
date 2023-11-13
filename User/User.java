package User;
import Bill.Bill;
import Transfer.Transfer;

import java.util.ArrayList;

public abstract class User {
    private final String username;
    private final String password;
    private final String name;
    private final String phoneNo;
    private final Type type;
    private ArrayList<Transfer> Transfers;
    private ArrayList<Bill> Bills;
    public User(String username, String password, String name, String phoneNo, Type type) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNo = phoneNo;
        this.type = type;
    }
    public boolean payBill(Bill bill){
        return bill.payBill();
    }
    public boolean transfer(Transfer transfer){
        return transfer.transfer();
    }
    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
    public abstract double getBalance();
    public abstract String getSource();
    public ArrayList<Bill> getBills() {
        return Bills;
    }
    public Type getType() {
        return type;
    }
    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public String getPassword() {
        return password;
    }
}
