package Source;
import java.util.Date;
import External.BankAPI;
public class Bank {
    private String cardNo;
    private Date expDate;
    private double balance;

    public Bank(String card, Date date){
        cardNo = card;
        expDate = date;
        BankAPI endpoint=new BankAPI();
        balance =endpoint.getBalance(cardNo);
    }
    public boolean withdraw(double amount){
        balance -= amount;
        return true;
    }
    public boolean deposit(double Amount){
       balance+=Amount;
       return true;
    }
    public double checkBalance(){
        return balance;
    }
    public String getCardNo(){
        return cardNo;
    }


}
