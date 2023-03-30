package tk.airshipcraft.airshipcraftcompanies.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.airshipcraft.airshipcraftcompanies.Companies;

import com.watsonllc.econ.Managers.AccountManager;

public class CreateCompanyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player!");
            return true;
        }

        Player player = (Player) sender;
        if (args.length < 1) {
            player.sendMessage("Usage: /createcompany <company_name> <investment> <payroll_amount>");
            return true;
        }
        if (AccountManager.hasEnough(player, 5000)) {
            Companies.getInstance().createCompany(args[0], Double.parseDouble(args[1]), player, Double.parseDouble(args[2]));
            AccountManager.instance.setBalance(Double.parseDouble(args[1]));
            // TODO: store in a database
            player.sendMessage("Created company " + args[0]);
            return true;
        } else {
            player.sendMessage("You need to invest at least 5000 coins");
        }
        return true;
    }

}
