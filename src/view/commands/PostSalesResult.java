package view.commands;

import data.DataManager;

import java.util.Scanner;

import static controller.EmployeesController.postSalesResult;

public class PostSalesResult extends DataScan{
    public PostSalesResult(DataManager _data, Scanner _scanner){
        super(_data, _scanner);
    }

    @Override
    public void execute() {
        System.out.println("Enter the employee cpf:");
        String input = scanner.next();

        System.out.println("Enter the sales value:");
        double doubleInput = scanner.nextDouble();

        switch (postSalesResult(data, input, doubleInput)) {
            case 1 -> System.out.println("Don't exist any Employee with the described cpf");
            case 2 -> System.out.println("The select Employee is not an Commissioned");
            default -> System.out.println("Sales result successfully posted");
        }
    }
}
