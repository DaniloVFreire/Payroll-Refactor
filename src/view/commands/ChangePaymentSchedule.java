package view.commands;

import data.DataManager;

import java.util.Scanner;

import static controller.EmployeesController.editEmployeePaymenntSchedule;

public class ChangePaymentSchedule extends DataScan{
    public ChangePaymentSchedule(DataManager _data, Scanner _scanner){
        super(_data, _scanner);
    }

    @Override
    public void execute() {
        System.out.println("enter the employee's cpf");
        String input = scanner.next();
        for (int i = 0; i < data.paymentSchedules.size(); i++) {
            System.out.println(i + " - " + data.paymentSchedules.get(i));
        }
        System.out.println("Select your payment schedule from 0 to n");
        short shortInput = scanner.nextShort();
        switch (editEmployeePaymenntSchedule(data, input, shortInput)) {
            case 1 -> System.out.println("Don't exist any type equals the described");
            default -> System.out.println("Payment schedule successfully added");
        }
    }
}
