package Bill;

public class ElectBill extends Bill {
    @Override
    public boolean payBill() {
        System.out.println("Elect bill");
        return true;
    }
}