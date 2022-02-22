package view.commands;

import data.DataManager;

import java.util.Scanner;

import static controller.PaymentController.payroll;

public class RunPayroll extends DataScan{
    public RunPayroll(DataManager _data, Scanner _scanner){
        super(_data, _scanner);
    }
    @Override
    public void execute() {
        System.out.println("Enter a date" +
                "Obs: (date format YYYY-MM-D)");
        String input = scanner.next();
        payroll(data, input);
    }
}
