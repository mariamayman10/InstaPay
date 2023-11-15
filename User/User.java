package User;//validation phone no , card bank
import Bill.Bill;
import Transfer.*;
import User.*;
import java.util.ArrayList;

public abstract class User {
    private final String username;
    private final String password;
    private final String phoneNo;
    private Type type;
    private final ArrayList<Transfer> Transfers;

    public ArrayList<Transfer> getRecieved() {
        return Recieved;
    }

    private final ArrayList<Transfer> Recieved;
    private final ArrayList<Bill> Bills;
    public User(String username, String password,String phoneNo, Type type) {
        this.username = username;
        this.password = password;
        this.phoneNo = phoneNo;
        this.type = type;
        this.Transfers = new ArrayList<Transfer>();
        this.Recieved = new ArrayList<Transfer>();
        this.Bills = new ArrayList<Bill>();

    }
    public boolean payBill(Bill bill){
        if(bill.getAmount()<getBalance()){
            WalletTransfer utilTrans = new WalletTransfer(bill.getAmount(),this,bill.getReceiver());
            if(utilTrans.transfer()){
                Bills.add(bill);
                return bill.PayBill();
            }
        }
        return false;
    }

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
    public abstract double getBalance();
    public abstract String getSource();
    public ArrayList<Bill> getBills() {
        return Bills;
    }
    public ArrayList<Transfer> getTransfers(){return Transfers;}
    public Type getType() {
        return type;
    }
    public String getUsername() {
        return username;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public String getPassword() {
        return password;
    }
    public void AddTransfer(Transfer t){
        Transfers.add(t);
    }
    public void ReceiveTransfer(Transfer t){
        Recieved.add(t);
    }
    public void AddBill(Bill b){
        Bills.add(b);
    }
}
