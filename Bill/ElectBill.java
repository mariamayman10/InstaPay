package Bill;

import User.User;

public class ElectBill extends Bill {
    public ElectBill(double amount, String code, String receiver){
        super(amount, code, receiver);
    }
    @Override
    public boolean payBill() {
        System.out.println("Elect bill");
        return true;
    }

    @Override
    public void PrintBill(){
        System.out.println("Electric Bill");
        super.PrintBill();
    }
}