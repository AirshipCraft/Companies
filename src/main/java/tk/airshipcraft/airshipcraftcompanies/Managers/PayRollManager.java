package tk.airshipcraft.airshipcraftcompanies.Managers;

import com.watsonllc.econ.Managers.AccountManager;
import org.bukkit.entity.Player;
import tk.airshipcraft.airshipcraftcompanies.Objects.Company;

public class PayRollManager {
    private double payAmount;
    public PayRollManager(double payAmount) {
        this.payAmount = payAmount;
    }
    public void payEmployees() {
        for (Player player : Company.instance.getEmployees()) {
            AccountManager.instance.setBalance(AccountManager.balance(player) + this.payAmount);
        }
    }
    public void setPayRoll(double payAmount) {
        this.payAmount = payAmount;
    }
}
