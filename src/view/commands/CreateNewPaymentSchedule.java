package view.commands;

import data.DataManager;

import java.util.Scanner;

import static controller.PaymentController.addPaymentSchedule;

public class CreateNewPaymentSchedule extends DataScan{
    public CreateNewPaymentSchedule(DataManager _data, Scanner _scanner){
        super(_data, _scanner);
    }
    @Override
    public void execute() {
        System.out.println("enter the new payment schedule" +
                "(Ex: 'weekly 1' monthly $)");
        String input = scanner.next();

        switch (addPaymentSchedule(data, input)) {
            case 1 -> System.out.println("Don't exist any type equals the described");
            default -> System.out.println("Payment schedule successfully added");
        }
    }
}
