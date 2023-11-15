package InstapayApp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import Source.Bank;
import Source.Wallet;
import User.*;

public class AuthenticationService {
    private final List<User> userList;
    public AuthenticationService() {
        userList = new ArrayList<>();
    }
    public void addUser(User user) {
        userList.add(user);
    }
    public User logIn(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    public boolean sendOtp(String phoneNumber){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int otp = random.nextInt(100, 999);
        System.out.println("OTP sent to " + phoneNumber + ": " + otp);
        System.out.println("Enter The Otp Code :" );
        int OTP =scanner.nextInt();
         return otp == OTP;

    }
    public User searchUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

}
