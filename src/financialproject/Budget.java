package financialproject;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Budget {
    private double totalBudget;
    private double remainingBudget;
    private List<Expense> expenses;
    private List<Income> incomes;
    
    public Budget() {
        this.totalBudget = 0.0;
        this.remainingBudget = 0.0;
        this.expenses = new ArrayList<>();
        this.incomes = new ArrayList<>();
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
        this.remainingBudget = totalBudget;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public double getRemainingBudget() {
        return remainingBudget;
    }

    public void updateRemainingBudget(double amount) {
        this.remainingBudget -= amount;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void addIncome(Income income) {
        incomes.add(income);
    }
    
    // Add a getConnection() method to return the database connection
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/financialproject_database";
        String username = "root";
        String password = "";
        
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
