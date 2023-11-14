package Bill;

import User.User;

public class GasBill extends Bill{
    public GasBill(double amount, String code, User receiver){
        super(amount, code, receiver);
    }
    @Override
    public boolean payBill() {
        System.out.println("Gas bill");
        return true;
    }
}
