package Source;
import java.util.Date;
import External.BankAPI;
public class Bank {
    private String cardNo;
    private Date expDate;
    public boolean withdraw(double Amount){
        BankAPI endpoint=new BankAPI();
       return endpoint.withdraw(Amount,cardNo);

    }
    public boolean deposit(double Amount,String RecieverID){
        BankAPI endpoint=new BankAPI();
        return endpoint.deposit(Amount,RecieverID);

    }
    public double checkBalance(){
        BankAPI endpoint=new BankAPI();
        return endpoint.getBalance(cardNo);
    }
    public String getCardNo(){
        return cardNo;
    }

}
