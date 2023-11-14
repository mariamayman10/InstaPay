package Bill;

import User.User;

public class WaterBill extends Bill {
  public WaterBill(double amount, String code, User receiver){
    super(amount, code, receiver);
  }
  @Override
  public boolean payBill() {
    System.out.println("Water bill");
    return true;
  }
}
