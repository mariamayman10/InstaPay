package InstapayApp;
import Bill.*;
import Source.*;
import Transfer.*;
import User.*;
import External.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;

public class  InstaPay {
    private final WalletAPI walletAPI;
    private BankAPI bankAPI;
    private final AuthenticationService authService;
    private User user;

    public InstaPay(){
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
    public void loadUp(User u) {
        user = u;
        System.out.println("Welcome, " + user.getUsername() + "\nThe phone number " + user.getPhoneNo() + "\nYour Type " + user.getType());
    }
    public void signUpUser() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String phoneRegex = "^[0-9]{11}$";
        System.out.println("Enter The mobile number  : ");
        String phoneNumber = scanner.nextLine();
        while (!phoneNumber.matches(phoneRegex)) {
            System.out.println("Invalid phone number.");
            System.out.println("Enter The mobile number  : ");
            phoneNumber = scanner.nextLine();
        }
        while(!authService.sendOtp(phoneNumber)){
            System.out.println("The OTP is wrong");
        }
        System.out.println("Enter  Username: ");
        String username = scanner.nextLine();
        while(authService.searchUser(username)!=null) {
            System.out.println("Username already exists.");
            System.out.println("Enter  Username: ");
            username = scanner.nextLine();
        }
        System.out.println("Enter Strong password: ");
        String password = scanner.nextLine();
        while(!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
            System.out.println("Weak Password.");
            password = scanner.nextLine();
        }
        User newUser;
        System.out.println("1. Sign-up with wallet number ");
        System.out.println("2. Sign-Up with bank account ");
        int op = scanner.nextInt();
        scanner.nextLine();
        String cardNo;
        Type userType;
        if (op == 1) {
            if(!walletAPI.Exists(phoneNumber)) {
                System.out.println("Invalid wallet account");
            }
            Wallet wallet=new Wallet(phoneNumber, walletAPI.getRandom());
            userType = Type.Wallet;
            newUser = new WalletUser(username, password, phoneNumber, userType, wallet);
            walletAPI.addWallet(wallet);
        }
        else if (op == 2) {
            System.out.println("Enter Your Card bank");
            while (true) {
                cardNo = scanner.nextLine();
                if (cardNo.matches("\\d+")) {
                    break;
                }else {
                System.out.println("Invalid card number. Please enter a card number containing only digits.");
            }
        }
            System.out.println("Enter Your Card expiration date MM/YY format");
            Date date1;
            while (true) {
                String exp = scanner.nextLine();
                try {
                    date1 = new SimpleDateFormat("MM/yy").parse(exp);
                    while (!bankAPI.Exists(cardNo)) {
                        System.out.println("Invalid bank account");
                        System.out.println("Enter Your Card bank");
                        cardNo = scanner.nextLine();
                        System.out.println("Enter Your Card expiration date MM/YY format");
                        exp = scanner.nextLine();
                        date1 = new SimpleDateFormat("MM/yy").parse(exp);
                    }
                    break;
                } catch (ParseException e) {
                    System.out.println("Invalid date format.");
                    System.out.println("Enter Your Card expiration date again");
                }
            }

            Bank card=new Bank(cardNo,date1, bankAPI.getRandom());
            userType = Type.Bank;
            newUser = new BankUser(username, password, phoneNumber, userType, card);
            bankAPI.addCard(card);
        }
        else {
            System.out.println("Invalid Option");
            return;
        }
        authService.addUser(newUser);
        System.out.println("Signed up successfully");
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



        if(billType == 1){
            WaterUtilAPI waterUtilAPI = new WaterUtilAPI();
            Bill waterBill = new WaterBill(code);
            waterBill.setComp(waterUtilAPI);
            user.payBill(waterBill);

        }
        else if(billType == 2){
            GasUtilAPI gasUtilAPI = new GasUtilAPI();
            Bill gasBill = new GasBill( code);
            gasBill.setComp(gasUtilAPI);
            user.payBill(gasBill);

        }
        else if(billType == 3){
            ElectUtilAPI electUtilAPI = new ElectUtilAPI();
            Bill electBill = new ElectBill(code);
            electBill.setComp(electUtilAPI);
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
        System.out.println("Enter amount you want to send: ");
        double amount = scanner.nextDouble();
        if(transferType == 1){
            String username;
            User receiver;
            System.out.println("Enter username of receiver: ");
            scanner.nextLine();
            username = scanner.nextLine();
            receiver = authService.searchUser(username);
            if(receiver == null)
                System.out.println("No such account");
            else{
                Transfer t=new InstaPayTransfer(amount,user,receiver);
                t.transfer();
            }
        }
        else if(transferType == 2){
            String receiver;
            System.out.println("Enter wallet's phone number of receiver: ");
            scanner.nextLine();
            receiver = scanner.nextLine();
            boolean check = walletAPI.Exists(receiver);
            if(!check)
                System.out.println("No such wallet");
            else{
                Transfer t=new WalletTransfer(amount,user,receiver);
                t.transfer();
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
                Transfer t=new BankTransfer(amount,user,receiver);
                t.transfer();
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
                                System.out.println("4. View Transactions");
                                System.out.println("5. Sign Out");
                                int c = 0;
                                try {
                                    c = scanner.nextInt();
                                    switch (c) {
                                        case 1 -> payBill();
                                        case 2 -> transfer();
                                        case 3 -> checkBalance(user);
                                        case 4->{
                                            System.out.println("Transfers");
                                            for(Transfer t:user.getTransfers()){
                                                t.printtrans();
                                            }
                                            System.out.println("Bills");
                                            for(Bill b:user.getBills()){
                                                b.PrintBill();
                                            }
                                            System.out.println("Received Transfers");
                                            for(Transfer t:user.getRecieved()){
                                                t.printtrans();
                                            }

                                        }
                                        case 5 -> {
                                            System.out.println("Signing out.");
                                            user = null;
                                        }
                                        default -> System.out.println("Invalid choice. Please choose a valid option.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid integer.");
                                    scanner.nextLine();
                                }
                                if(c == 5)break;
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
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}