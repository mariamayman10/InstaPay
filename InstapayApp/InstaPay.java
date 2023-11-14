package InstapayApp;
import Bill.*;
import Source.*;
import Transfer.*;
import User.*;
import java.util.Scanner;
import External.*;
import java.util.InputMismatchException;
public class InstaPay {
    private final Bank cardBank;
    private final Wallet wallet;
    private final WalletAPI walletAPI;
    private final BankAPI bankAPI;
    private final AuthenticationService authService;
    private User user;

    public InstaPay(){
        cardBank = new Bank();
        wallet = new Wallet();
        bankAPI = new BankAPI();
        walletAPI = new WalletAPI();
        authService = new AuthenticationService();
    }
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
        System.out.println("Welcome, " + user.getUsername() + "\nThe phone number " + user.getPhoneNo() + "\nYour Type " + user.getType());
    }

    public void signUpUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Sign-up with wallet number ");
        System.out.println("2. Sign-Up with bank account ");
        int op = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter The mobile number  : ");
        String phoneNumber = scanner.nextLine();
        String cardNo;
        Type userType;
        if (op == 1) {
            if (!walletAPI.Exists(phoneNumber)) {
                System.out.println("Invalid wallet account");
            }
            wallet.setPhoneNo(phoneNumber);
            userType = Type.Wallet;
        }
        else if (op == 2) {
            System.out.println("Enter Your Card bank");
            cardNo = scanner.nextLine();
            if (!bankAPI.Exists(cardNo)) {
                System.out.println("Invalid bank account");
                return;
            }
            cardBank.setCardNo(cardNo);
            userType = Type.Bank;
        } else {
            System.out.println("Invalid Option");
            return;
        }
        if (authService.sendOtp(phoneNumber)) {
            System.out.println("Enter The Username: ");
            String username = scanner.nextLine();
            user = authService.searchUser(username);
            if (user == null) {
                System.out.println("Enter The Strong password: ");
                String password = scanner.nextLine();
                if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
                    User newUser;
                    if (userType == Type.Wallet) {

                        newUser = new WalletUser(username, password, phoneNumber, userType, wallet);
                    } else{
                        newUser = new BankUser(username, password, phoneNumber, userType, cardBank);
                    }
                    authService.addUser(newUser);
                    System.out.println("Sign-up successful");
                } else {
                    System.out.println("Weak Password.");
                }
            } else {
                System.out.println("Username already exists.");
            }
        } else {
            System.out.println("The OTP is wrong");
        }

    }

    public void checkBalance(User user) {
        System.out.println("Your Balance " + user.getBalance());

    }
    public void payBill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select bill type to pay:");
        System.out.println("1. Water Bill");
        System.out.println("2. Gas Bill");
        System.out.println("3. Electric Bill");
        int billType = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the code: ");
        String code = scanner.nextLine();

        double amount;
        User receiver;
        if(billType == 1){
            WaterUtilAPI waterUtilAPI = new WaterUtilAPI();
            amount = waterUtilAPI.getAmount(code);
            receiver = waterUtilAPI.getAccount(code);
            Bill waterBill = new WaterBill(amount, code, receiver);
            user.payBill(waterBill);
        }
        else if(billType == 2){
            GasUtilAPI gasUtilAPI = new GasUtilAPI();
            amount = gasUtilAPI.getAmount(code);
            receiver = gasUtilAPI.getAccount(code);
            Bill gasBill = new GasBill(amount, code, receiver);
            user.payBill(gasBill);
        }
        else if(billType == 3){
            ElectUtilAPI electUtilAPI = new ElectUtilAPI();
            amount = electUtilAPI.getAmount(code);
            receiver = electUtilAPI.getAccount(code);
            Bill electBill = new ElectBill(amount, code, receiver);
            user.payBill(electBill);
        }
        else{
            System.out.println("Invalid Choice");
        }
    }
    public void transfer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select transfer type:");
        System.out.println("1. Transfer to InstaPay Account");
        System.out.println("2. Transfer to wallet");
        if(user.getType() == Type.Bank){
            System.out.println("3. Transfer to bank");
        }
        int transferType = scanner.nextInt();
        scanner.nextLine();

        double amount;
        if(transferType == 1){
            String username;
            User receiver;
            System.out.println("Enter username of receiver: ");
            username = scanner.nextLine();
            receiver = authService.searchUser(username);
            if(receiver == null)
                System.out.println("No such an account");
            else{
                System.out.println("Enter amount you want to send: ");
                amount = scanner.nextDouble();
                Transfer instaPayTransfer = new InstaPayTransfer(amount, user, receiver);
               user.transfer(instaPayTransfer);
            }
        }
        else if(transferType == 2){
            String receiver;
            System.out.println("Enter wallet's phone number of receiver: ");
            receiver = scanner.nextLine();
            boolean check = walletAPI.Exists(receiver);
            if(!check)
                System.out.println("No such a wallet");
            else{
                System.out.println("Enter amount you want to send: ");
                amount = scanner.nextDouble();
                Transfer walletTransfer = new WalletTransfer(amount, user, receiver);
                user.transfer(walletTransfer);
            }
        }
        else if(transferType == 3 && user.getType() == Type.Bank){
            String receiver;
            System.out.println("Enter bank's card number of receiver: ");
            receiver = scanner.nextLine();
            boolean check = bankAPI.Exists(receiver);
            if(!check)
                System.out.println("No such a bank account");
            else{
                System.out.println("Enter amount you want to send: ");
                amount = scanner.nextDouble();
                Transfer bankTransfer = new BankTransfer(amount, user, receiver);
                user.transfer(bankTransfer);
            }
        }
        else{
            System.out.println("Invalid Choice");
        }
    }
    public void showSystem() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Sign In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        user = signInUser();
                        if (user != null) {
                            while (true) {
                                System.out.println("1. Pay Bill");
                                System.out.println("2. Transfer Money");
                                System.out.println("3. Check Balance");
                                System.out.println("4. Sign Out");
                                int c;
                                try {
                                    c = scanner.nextInt();
                                    switch (c) {
                                        case 1 -> payBill();
                                        case 2 -> transfer();
                                        case 3 -> checkBalance(user);
                                        case 4 -> {
                                            System.out.println("Signing out.");
                                            user = null;
                                            return;
                                        }
                                        default -> System.out.println("Invalid choice. Please choose a valid option.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid integer.");
                                    scanner.nextLine();
                                }
                            }
                        }
                    }
                    case 2 -> signUpUser();
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please choose a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }
}