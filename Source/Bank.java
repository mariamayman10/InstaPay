package Source;
import java.util.Date;
import External.BankAPI;
public class Bank {
    private final String cardNo;
    private Date expDate;
    private double balance;

    public Bank(String card, Date date, double balance){
        this.cardNo = card;
        this.expDate = date;
        this.balance = balance;
    }
    public void withdraw(double amount){
        BankAPI endpoint=new BankAPI();
        endpoint.withdraw(amount, cardNo);
    }
    public void deposit(double amount){
        BankAPI endpoint=new BankAPI();
        endpoint.deposit(amount, cardNo);
    }
    public double checkBalance(){
        return balance;
    }
    public String getCardNo(){
        return cardNo;
    }
    public void setBalance(double b){
        balance = b;
    }
}
