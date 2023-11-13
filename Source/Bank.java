package Source;
import java.util.Date;
import External.BankAPI;
public class Bank {
    private String cardNo;
    private Date expDate;
    public boolean withdraw(float Amount){
        BankAPI endpoint=new BankAPI();
       return endpoint.withdraw(Amount);

    }
    public boolean deposit(float Amount,String RecieverID){
        BankAPI endpoint=new BankAPI();
        return endpoint.deposit(Amount,RecieverID);

    }
    

}
