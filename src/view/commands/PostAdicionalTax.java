package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.EmployeesController.postServiceTax;

public class PostAdicionalTax extends Scanner {
    public PostAdicionalTax(java.util.Scanner _scanner, Stack<String> _undo, Stack<String> _redo){
        super(_scanner, _undo, _redo);
    }
    @Override
    public DataManager execute(DataManager data) {
        pushUndo(undo, data);
        System.out.println("enter the employee cpf");
        String input = scanner.next();

        System.out.println("enter the syndicalist tax");
        double doubleInput = scanner.nextDouble();

        if (postServiceTax(data, input, doubleInput) == 1) {
            System.out.println("Don't exist any Employee with the described cpf");
        } else if(postServiceTax(data, input, doubleInput) == 2){
            System.out.println("The Employee does not have an syndicate");
        } else {
            System.out.println("Service tax successfully posted");
        }
        return data;
    }
}
