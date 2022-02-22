package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.EmployeesController.postTimeCard;

public class PostTimeCard extends Scanner {
    public PostTimeCard(java.util.Scanner _scanner, Stack<String> _undo, Stack<String> _redo){
        super(_scanner, _undo, _redo);
    }
    @Override
    public DataManager execute(DataManager data) {
        pushUndo(undo, data);
        System.out.println("Enter the employee cpf");
        String input = scanner.next();

        System.out.println("Enter the worked hours");
        int intInput = scanner.nextInt();

        switch (postTimeCard(data, input, intInput)) {
            case 1 -> System.out.println("Don't exist any Employee with the described cpf");
            case 2 -> System.out.println("The select Employee is not an Hourly");
            case 3 -> System.out.println("The time input should be positive");
            default -> System.out.println("Time card successfully posted");
        }
        return data;
    }
}
