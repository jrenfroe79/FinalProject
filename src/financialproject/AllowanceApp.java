package financialproject;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class AllowanceApp {
    private Budget budget = new Budget();
    private TextField expenseNameField;
    private TextField expenseAmountField;
    private Connection connection;

    public AllowanceApp() throws SQLException {
        this.connection = budget.getConnection();
    }

    public VBox createLayout() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        Label expenseNameLabel = new Label("Expense Name:");
        GridPane.setConstraints(expenseNameLabel, 0, 0);
        grid.getChildren().add(expenseNameLabel);

        expenseNameField = new TextField();
        GridPane.setConstraints(expenseNameField, 1, 0);
        grid.getChildren().add(expenseNameField);

        Label expenseAmountLabel = new Label("Expense Amount:");
        GridPane.setConstraints(expenseAmountLabel, 0, 1);
        grid.getChildren().add(expenseAmountLabel);

        expenseAmountField = new TextField();
        GridPane.setConstraints(expenseAmountField, 1, 1);
        grid.getChildren().add(expenseAmountField);

        Button addExpenseButton = new Button("Add Expense");
        GridPane.setConstraints(addExpenseButton, 0, 2);
        grid.getChildren().add(addExpenseButton);

        addExpenseButton.setOnAction(e -> {
            String name = expenseNameField.getText();
            double amount = Double.parseDouble(expenseAmountField.getText());
            Expense expense = new Expense(name, amount);
            budget.addExpense(expense);
            budget.updateRemainingBudget(amount);
            addExpenseToDatabase(name, amount);
        });

        layout.getChildren().add(grid);
        return layout;
    }

    public void addExpenseToDatabase(String name, double amount) {
        try {
            String sql = "INSERT INTO expenses (name, amount) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setDouble(2, amount);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Expense added successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        AllowanceApp allowanceApp = new AllowanceApp();
        VBox layout = allowanceApp.createLayout();
        
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Allowance App");
        
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
}
