package Bill
public class WaterBill extends Bill {
  @Override
  public boolean payBill() {
    System.out.println("Water bill");
    return true;
  }
}
