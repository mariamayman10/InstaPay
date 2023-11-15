package Bill;

public interface BillStrategy {
    boolean payBill();
  double getAmount();
  String getReceiver();
}
