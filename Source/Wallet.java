package Source;

import External.WalletAPI;

public class Wallet {
    private String phoneNo;

    public boolean withdraw(double Amount){
        WalletAPI endpoint=new WalletAPI();
        return endpoint.withdraw(Amount,phoneNo);

    }
    public boolean deposit(double Amount,String RecieverID){
        WalletAPI endpoint=new WalletAPI();
        return endpoint.deposit(Amount,RecieverID);

    }
    public double checkBalance(){
        WalletAPI endpoint=new WalletAPI();
        return endpoint.getBalance(phoneNo);
    }
    public String getCardNo(){
        return phoneNo;
    }
}
