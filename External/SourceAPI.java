package External;

public interface SourceAPI {
    double getBalance(String Id);
    double getRandom();
    void withdraw(double amount,String SenderId);
    void deposit(double amount,String receiverId);
    boolean Exists(String Id);
    void AttachToAccount(String Id);
    boolean checkOtp(String Otp);
}
