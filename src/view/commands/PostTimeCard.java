package view.commands;

import data.DataManager;

import java.util.Scanner;

import static controller.EmployeesController.postTimeCard;

public class PostTimeCard extends DataScan{
    public PostTimeCard(DataManager _data, Scanner _scanner){
        super(_data, _scanner);
    }
    @Override
    public void execute() {
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
    }
}
