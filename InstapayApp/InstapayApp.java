package InstapayApp;
import Source.Bank;
import Source.Wallet;
import User.*;
import java.util.Scanner;
import External.*;

class Instapy {
    Type userType;
    Bank cardBank=new Bank();
    Wallet wallet=new Wallet();
    private final WalletAPI api = new WalletAPI();
    private final BankAPI apib = new BankAPI();
    private final AuthenticationService authService = new AuthenticationService();

    private User user;

    public User signInUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        user = authService.logIn(username, password);
        if (user != null) {
            loadUp(user);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
        return user;
    }

    public void loadUp(User users) {
        user = users;
        System.out.println("Welcome, " + user.getUsername() + "\nThe phone number " + user.getPhoneNo()+"\nYour Type "+user.getType());
    }

    public void signUpUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Sign-up with wallet number ");
        System.out.println("2. Sign-Up with bank account ");
        int op = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter The mobile number  : ");
        String phoneNumber = scanner.nextLine();
        if (op == 1) {

            if (!api.Exists(phoneNumber)) {
                System.out.println("Invalid wallet account");
            }
            userType=Type.Wallet;
        } else if (op == 2) {
            System.out.println("Enter Your Card bank");
            String cardNo=scanner.nextLine();
            cardBank.setCardNo(cardNo);

            if (!apib.Exists(cardNo)) {
                System.out.println("Invalid bank account");
            }
            userType=Type.Bank;
        } else {
            System.out.println("Invalid Option");
            return;
        }
        if (authService.sendOtp(phoneNumber)) {
            System.out.println("Enter The User name: ");
            String username = scanner.nextLine();
            user = authService.searchUser(username);
            if (user == null) {
                System.out.println("Enter The Strong password: ");
                String password = scanner.nextLine();
                if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
                    if (userType==Type.Wallet){
                        wallet.setPhoneNo(phoneNumber);
                        User newuser= new WalletUser(username,password,phoneNumber,userType,wallet);
                        authService.addUser(newuser);
                    } else if (userType==Type.Bank) {
                        User newuser= new BankUser(username,password,phoneNumber,userType, cardBank);
                        authService.addUser(newuser);

                    }
                    System.out.println("Sign-up successful");

                } else {
                    System.out.println("Weak Password.");
                }
            } else {
                System.out.println("Username already exists.");
            }
        }else{
            System.out.println("The OTP is wrong");
        }

    }
    public void showSystem() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    signInUser();
                    if (user != null) {
                        while (true) {
                            System.out.println("1. Pay Bill");
                            System.out.println("2. Transfer Money");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Sign Out");
                            int c = scanner.nextInt();
                            switch (c) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:

                                    break;
                                case 4:
                                    System.out.println("Signing out.");
                                    user = null;
                                    return;
                                default:
                                    System.out.println("Invalid choice. Please choose a valid option.");
                            }
                        }
                    }
                    break;
                case 2:
                    signUpUser();
                    break;
                case 3:
                    return;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
class Main {
    public static void main(String[] args) {
        InstapayApp.Instapy instapy = new InstapayApp.Instapy();
        instapy.showSystem();
    }

}
