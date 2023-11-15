package Bill;

import User.User;

public class WaterBill extends Bill {
  public WaterBill(double amount, String code,String receiver){
    super(amount, code, receiver);
  }
  @Override
  public boolean payBill() {
    System.out.println("Water bill");
    return true;
  }
  @Override
  public void PrintBill(){
    System.out.println("Water Bill");
    super.PrintBill();
  }
}
