package financialproject;

import java.util.Date;

public class Expense {
    private String name;
    private double amount;
    private String category;
    private Date date;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}
