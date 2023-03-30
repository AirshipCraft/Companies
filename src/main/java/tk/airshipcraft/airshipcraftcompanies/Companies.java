package tk.airshipcraft.airshipcraftcompanies;

import com.watsonllc.econ.Utils.HashTriple;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import tk.airshipcraft.airshipcraftcompanies.Commands.CreateCompanyCommand;
import tk.airshipcraft.airshipcraftcompanies.Commands.PayRollCommand;
import tk.airshipcraft.airshipcraftcompanies.Managers.PayRollManager;
import tk.airshipcraft.airshipcraftcompanies.Objects.Company;

import java.util.Objects;
import java.util.UUID;


public class Companies extends JavaPlugin {
    public static UUID uuid;
    public static Companies instance;
    public static PayRollManager payManager;

    private static HashTriple<UUID, Company, Player> companies  = new HashTriple<>(null, null, null);
    public Companies () {
        instance = this;
    }

    public void onEnable() {
        Objects.requireNonNull(getCommand("createcompany")).setExecutor(new CreateCompanyCommand());
        Objects.requireNonNull(getCommand("payroll")).setExecutor(new PayRollCommand());
    }

    public void onDisable() {
        // Clean up your plugin here
    }

    public Company createCompany(String name, double initialInvestment, Player owner, double payAmount) {
        uuid = UUID.randomUUID();
        Company company = new Company(name, initialInvestment, owner, payAmount, uuid);
        companies.put(uuid, company, owner);
        payManager = new PayRollManager(15);
        return company;
    }

    public Company getCompany(UUID uuid) {
        return companies.getValue1(uuid);
    }

    public void removeCompany(UUID uuid) {
        companies.remove(uuid);
    }
    public static Companies getInstance() {
        return instance;
    }

}
