package view.commands;

import data.DataManager;

import java.util.Scanner;

import static controller.EmployeesController.deleteEmployee;

public class RemoveEmployee extends DataScan{
    public RemoveEmployee(DataManager _data, Scanner _scanner){
        super(_data, _scanner);
    }
    @Override
    public void execute() {
        System.out.println("Enter the employee cpf:");
        String input = scanner.next();

        if (deleteEmployee(data, input) == 1) {
            System.out.println("Don't exist any Employee with the described cpf");
        } else {
            System.out.println("Deletion Successfully executed");
        }
    }
}
