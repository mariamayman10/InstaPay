package Source;


import External.WalletAPI;

public class Wallet {
    private String phoneNo;
    private double balance;

    public Wallet(String phone){
        phoneNo=phone;
        WalletAPI endpoint=new WalletAPI();
        balance =endpoint.getBalance(phoneNo);
    }

    public boolean withdraw(double Amount){
        balance-=Amount;
return true;
    }
    public boolean deposit(double Amount){
       balance+=Amount;
       return true;
    }
    public double checkBalance(){
        return balance;
    }
    public String getPhoneNo(){
        return phoneNo;
    }

}
