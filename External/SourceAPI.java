package External;

public interface SourceAPI {
    double getBalance(String Id);
    boolean withdraw(float Amount);
    boolean deposit(float amount,String recieverId);
    boolean Exists(String Id);
    void AttachToAccount(String Id);
    boolean checkOtp(String Otp);


}
