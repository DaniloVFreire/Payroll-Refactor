package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.PaymentController.addPaymentSchedule;

public class CreateNewPaymentSchedule extends Scanner {
    public CreateNewPaymentSchedule(java.util.Scanner _scanner, Stack<String> _undo, Stack<String> _redo){
        super(_scanner, _undo, _redo);
    }
    @Override
    public DataManager execute(DataManager data) {
        pushUndo(undo, data);
        System.out.println("enter the new payment schedule" +
                "(Ex: 'weekly 1' monthly $)");
        String input = scanner.next();

        switch (addPaymentSchedule(data, input)) {
            case 1 -> System.out.println("Don't exist any type equals the described");
            default -> System.out.println("Payment schedule successfully added");
        }
        return data;
    }
}
