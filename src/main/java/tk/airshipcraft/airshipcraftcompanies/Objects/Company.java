package tk.airshipcraft.airshipcraftcompanies.Objects;


import org.bukkit.entity.Player;
import tk.airshipcraft.airshipcraftcompanies.Managers.PayRollManager;

import java.util.List;
import java.util.UUID;

public class Company {

    private String name;
    private double capital;
    private double investment;
    private int employeeCount;
    private Player companyOwner;
    private final UUID COMPANY_ID;
    private double totalInvestment;
    public static Company instance;
    private List<Player> employee;
    private PayRollManager payAmount;

    public Company(String name, double initialInvestment, Player owner, double payAmount, UUID companyId) {
        this.name = name;
        this.investment = initialInvestment;
        this.COMPANY_ID = companyId;
        this.capital = initialInvestment;
        this.totalInvestment = initialInvestment;
        this.employeeCount = 1;
        this.employee.add(owner);
        this.companyOwner = owner;
        this.payAmount = new PayRollManager(payAmount);
        instance = this;
    }

    public String getName() {
        return name;
    }

    public double getCapital() {
        return capital;
    }
    public void addInvestment(double investment) {
        this.totalInvestment += investment;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getInvestment() {
        return investment;
    }
    public double getTotalInvestment() {
        return totalInvestment;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
    public List<Player> getEmployees() {
        return employee;
    }
    public void addEmployee(Player player) {
        employee.add(player);
    }
    public void removeEmployee(Player player) {
        if (employee.contains(player)) {
            employee.remove(player);
        }
    }
    public UUID getCompanyID() {
        return this.COMPANY_ID;
    }
    public Player getCompanyOwner() {return this.companyOwner;}
}

