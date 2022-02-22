package view.commands;

import data.DataManager;

import java.util.Stack;

import static controller.EmployeesController.createEmployee;

public class AddEmployee extends Scanner {

    public AddEmployee(java.util.Scanner _scanner, Stack<String> _undo, Stack<String> _redo){
        super(_scanner, _undo, _redo);
    }

    @Override
    public DataManager execute(DataManager data){
        pushUndo(undo, data);
        System.out.println("Enter the employee's name");
        String name = scanner.next();

        System.out.println("Enter the employee's address:");
        String address = scanner.next();

        System.out.println("Enter the employee's cpf(id) :");
        String cpf = scanner.next();

        //Category and specifications
        System.out.print("""
                            Enter the employee's category :
                            Hourly 1
                            Salaried 2
                            Commissioned 3
                            """);
        short category = scanner.nextShort();

        double moneyBase = -1;
        double commission = -1;
        if (category == 1) {
            System.out.println("Enter the employee's hour base payment");
            moneyBase = scanner.nextDouble();
        } else if (category == 2) {
            System.out.println("Enter the employee's salary");
            moneyBase = scanner.nextDouble();
        } else if (category == 3) {
            System.out.println("Enter the employee's base salary");
            moneyBase = scanner.nextDouble();
            System.out.println("Enter the employee's commission tax(percentage)" +
                    "Obs it should be less than 1 and bigger then 0.000");
            commission = scanner.nextDouble();
        }
        System.out.println("Select the payment method\n" +
                "1 check by post\n" +
                "2 check in hands\n" +
                "3 bank account deposit");
        short paymentMethod = scanner.nextShort();

        //Syndicate information
        System.out.println("The employee is a syndicate participant?\n" +
                "1 for yes\n" +
                "0 for no");
        short haveSyndicate = scanner.nextShort();
        double tax = -1;
        if (haveSyndicate == 1) {
            System.out.println("enter the syndicalist tax(percentage)\n" +
                    "Obs it should be less than 1 and bigger then 0.000");
            tax = scanner.nextDouble();
        }

        switch (createEmployee(data, name, address, cpf, category, paymentMethod, moneyBase, commission, haveSyndicate, tax)) {
            case 1 -> System.out.println("This employee cpf is already in use");
            case 2 -> System.out.println("The employee's category does not exist");
            case 3 -> System.out.println("The employee's payment method does not exist");
            default -> System.out.println("Employee successfully added");
        }
        return data;
    };
}
