package financialproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FinanceManager extends Application {
    private Budget budget = new Budget();
    
    private TextField expenseNameField;
    private TextField expenseAmountField;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Budget Manager");
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
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
        
        // Add Expense event handling
        addExpenseButton.setOnAction(e -> {
            String name = expenseNameField.getText();
            double amount = Double.parseDouble(expenseAmountField.getText());
            Expense expense = new Expense(name, amount);
            budget.addExpense(expense);
            budget.updateRemainingBudget(amount);
            // You can update the UI or display a message here
        });
        
        // Add more UI elements and event handling for adding incomes
        
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
