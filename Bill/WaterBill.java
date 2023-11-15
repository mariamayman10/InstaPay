package Bill;

import User.User;

import java.util.Random;

public class WaterBill extends Bill {
  private long Litres;
  public WaterBill(String code){
    super(code);
    Random rand=new Random();
    Litres=rand.nextLong(1000000);
  }

  @Override
  public void PrintBill(){
    System.out.println("Water Bill");
    System.out.println("Code: "+code);
    System.out.println("Amount: "+amount);
    System.out.println("Usage litres : "+Litres);
  }
}
