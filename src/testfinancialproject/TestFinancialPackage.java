package testfinancialproject;

import financialproject.Budget;
import financialproject.Expense;
import financialproject.Income;

public class TestFinancialPackage {
    public static void main(String[] args) {
        // Test Budget class
        Budget budget = new Budget();
        budget.setTotalBudget(1000.0);

        // Test Expense class
        Expense expense = new Expense("Groceries", 50.0);
        System.out.println("Expense name: " + expense.getName());
        System.out.println("Expense amount: " + expense.getAmount());

        // Test Income class
        Income income = new Income("Salary", 2000.0);
        System.out.println("Income source: " + income.getSource());
        System.out.println("Income amount: " + income.getAmount());
    }
}
