package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.EmployeesController.postSalesResult;

public class PostSalesResult extends Scanner {
    public PostSalesResult(java.util.Scanner _scanner, Stack<String> _undo, Stack<String> _redo){
        super(_scanner, _undo, _redo);
    }

    @Override
    public DataManager execute(DataManager data) {
        pushUndo(undo, data);
        System.out.println("Enter the employee cpf:");
        String input = scanner.next();

        System.out.println("Enter the sales value:");
        double doubleInput = scanner.nextDouble();

        switch (postSalesResult(data, input, doubleInput)) {
            case 1 -> System.out.println("Don't exist any Employee with the described cpf");
            case 2 -> System.out.println("The select Employee is not an Commissioned");
            default -> System.out.println("Sales result successfully posted");
        }
        return data;
    }
}
