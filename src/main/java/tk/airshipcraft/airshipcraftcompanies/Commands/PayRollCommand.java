package tk.airshipcraft.airshipcraftcompanies.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import tk.airshipcraft.airshipcraftcompanies.Companies;

public class PayRollCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("payroll")) {
            if (args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Usage: /payroll <pay|set> [value]");
                return true;
            }
            switch (args[0].toLowerCase()) {
                case "pay":
                    // Execute the payEmployees() method here
                    Companies.instance.payManager.payEmployees();
                    sender.sendMessage(ChatColor.GREEN + "Payroll processed successfully.");
                    break;
                case "set":
                    if (args.length < 2) {
                        sender.sendMessage(ChatColor.RED + "Usage: /payroll set <value>");
                        return true;
                    }
                    double payAmount;
                    try {
                        payAmount = Double.parseDouble(args[1]);
                    } catch (NumberFormatException e) {
                        sender.sendMessage(ChatColor.RED + "Invalid value. Must be a decimal number.");
                        return true;
                    }
                    // Execute the setPayRoll() method here
                    Companies.instance.payManager.setPayRoll(payAmount);
                    sender.sendMessage(ChatColor.GREEN + "Payroll amount set to " + payAmount + ".");
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Unknown subcommand. Usage: /payroll <pay|set> [value]");
                    break;
            }
            return true;
        }
        return false;
    }

}
