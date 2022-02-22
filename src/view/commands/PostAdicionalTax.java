package view.commands;

import data.DataManager;

import java.util.Scanner;

import static controller.EmployeesController.postServiceTax;

public class PostAdicionalTax extends DataScan{
    public PostAdicionalTax(DataManager _data, Scanner _scanner){
        super(_data, _scanner);
    }
    @Override
    public void execute() {
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
    }
}
