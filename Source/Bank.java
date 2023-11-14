package Source;
import java.util.Date;
import External.BankAPI;
public class Bank {
    private String cardNo;
    private Date expDate;
    public boolean withdraw(double amount, String senderID){
        BankAPI endpoint=new BankAPI();
        return endpoint.withdraw(amount, senderID);

    }
    public boolean deposit(double Amount, String receiverID){
        BankAPI endpoint=new BankAPI();
        return endpoint.deposit(Amount, receiverID);

    }
    public double checkBalance(){
        BankAPI endpoint=new BankAPI();
        return endpoint.getBalance(cardNo);
    }
    public String getCardNo(){
        return cardNo;
    }
    public void setCardNo(String cardNo){
        this.cardNo = cardNo;
    }

}
