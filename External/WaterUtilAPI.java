package External;
import User.User;

public class WaterUtilAPI extends UtilAPI{
    public WaterUtilAPI(){
        super();
    }

    @Override
    public String getAccount(String Code) {
        return CompanyAcc;
    }
}
