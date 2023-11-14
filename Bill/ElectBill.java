package Bill;

import User.User;

public class ElectBill extends Bill {
    public ElectBill(double amount, String code, User receiver){
        super(amount, code, receiver);
    }
    @Override
    public boolean payBill() {
        System.out.println("Elect bill");
        return true;
    }
}