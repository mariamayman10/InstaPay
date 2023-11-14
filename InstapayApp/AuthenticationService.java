package InstapayApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
        int otp = random.nextInt(1000);
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
