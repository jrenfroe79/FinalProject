package financialproject;

import java.util.ArrayList;
import java.util.List;

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
}
