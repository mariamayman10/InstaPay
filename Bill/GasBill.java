public class GasBill extends Bill{
    @Override
    public boolean payBill() {
        System.out.println("Gas bill");
        return true;
    }
}
