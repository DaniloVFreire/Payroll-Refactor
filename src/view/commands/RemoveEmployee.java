package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.EmployeesController.deleteEmployee;

public class RemoveEmployee extends Scanner {
    public RemoveEmployee(java.util.Scanner _scanner, Stack<String> _undo, Stack<String> _redo){
        super(_scanner, _undo, _redo);
    }
    @Override
    public DataManager execute(DataManager data) {
        pushUndo(undo, data);
        System.out.println("Enter the employee cpf:");
        String input = scanner.next();

        if (deleteEmployee(data, input) == 1) {
            System.out.println("Don't exist any Employee with the described cpf");
        } else {
            System.out.println("Deletion Successfully executed");
        }
        return data;
    }
}
