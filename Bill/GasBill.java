package Bill;

import User.User;

public class GasBill extends Bill{
    private long CubicMetre ;
    private float gasTax;
    public GasBill(double amount, String code, String receiver){
        super(amount, code, receiver);
    }
    @Override
    public boolean payBill() {
        System.out.println("Gas bill");
        return true;
    }
    @Override
    public void PrintBill(){
        System.out.println("Gas Bill");
        super.PrintBill();
    }
}
