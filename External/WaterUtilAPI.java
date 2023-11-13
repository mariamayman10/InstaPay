package External;
import User.WalletUser;

import java.util.Random;

public class WaterUtilAPI extends UtilAPI{

    @Override
    public String getAccount(String Code) {
        return "WU"+CompanyAcc;
    }
}
