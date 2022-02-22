package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.PaymentController.payroll;

public class RunPayroll extends Scanner {
    public RunPayroll(java.util.Scanner _scanner, Stack<String> _undo, Stack<String> _redo){
        super(_scanner, _undo, _redo);
    }
    @Override
    public DataManager execute(DataManager data) {
        pushUndo(undo, data);
        System.out.println("Enter a date" +
                "Obs: (date format YYYY-MM-D)");
        String input = scanner.next();
        payroll(data, input);
        return data;
    }
}
