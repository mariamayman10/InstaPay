package External;

public interface SourceAPI {
    double getBalance(String Id);
    boolean withdraw(double Amount,String SenderID);
    boolean deposit(double amount,String receiverId);
    boolean Exists(String Id);
    void AttachToAccount(String Id);
    boolean checkOtp(String Otp);


}
