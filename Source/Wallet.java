package Source;

import External.WalletAPI;

public class Wallet {
    private String phoneNo;

    public boolean withdraw(double Amount, String senderID){
        WalletAPI endpoint=new WalletAPI();
        return endpoint.withdraw(Amount, senderID);

    }
    public boolean deposit(double Amount, String receiverID){
        WalletAPI endpoint=new WalletAPI();
        return endpoint.deposit(Amount,receiverID);
    }
    public double checkBalance(){
        WalletAPI endpoint=new WalletAPI();
        return endpoint.getBalance(phoneNo);
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
    }
}
