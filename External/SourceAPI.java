package External;

public interface SourceAPI {
    double getBalance(String Id);
    void  withdraw(float Amount);
    void deposit(float amount,String recieverId);
    boolean Exists(String Id);
    boolean AttachToAccount(String Id);


}
