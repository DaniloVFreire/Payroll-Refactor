package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.EmployeesController.editEmployeePaymenntSchedule;

public class ChangePaymentSchedule extends Scanner {
    public ChangePaymentSchedule(java.util.Scanner _scanner, Stack<String> _undo, Stack<String> _redo){
        super(_scanner, _undo, _redo);
    }

    @Override
    public DataManager execute(DataManager data) {
        pushUndo(undo, data);
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
        return data;
    }
}
