package financialproject;

import java.util.Date;

public class Income {
    private String source;
    private double amount;
    private String frequency;
    private Date dateReceived;

    public Income(String source, double amount) {
        this.source = source;
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public double getAmount() {
        return amount;
    }
}
