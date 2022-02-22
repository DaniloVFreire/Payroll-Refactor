package view.commands;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;
import data.DataManager;

import java.util.Scanner;

import static controller.EmployeesController.findEmployeeByCpf;
import static controller.EmployeesController.updateEmployee;

public class UpdateEmployee extends DataScan{
    public UpdateEmployee(DataManager _data, Scanner _scanner){
        super(_data, _scanner);
    }

    @Override
    public void execute() {
        short paymentMethod;
        String input, cpf, name, address;
        int intInput;
        double doubleInput, commission = -1, tax = -1.0;
        short shortInput, haveSyndicate = -1;

        System.out.println("enter the employee cpf");
        input = scanner.next();
        Employee selectedEmployee = findEmployeeByCpf(data, input);
        System.out.println("""
                            Do you want to change the employee's cpf?
                            1 for yes
                            0 for no""");
        intInput = scanner.nextInt();

        if (intInput == 1) {
            System.out.println("enter the employee's new cpf");
            cpf = scanner.next();
        } else {
            cpf = "-1";
        }

        System.out.println("""
                            Do you want to change the employee's name?
                            1 for yes
                            0 for no""");
        intInput = scanner.nextInt();
        if (intInput == 1) {
            System.out.println("enter the employee's new name");
            name = scanner.next();
        } else {
            name = "-1";
        }

        System.out.println("""
                            Do you want to change the employee's address?
                            1 for yes
                            0 for no""");
        intInput = scanner.nextInt();
        if (intInput == 1) {
            System.out.println("enter the employee's new address:");
            address = scanner.next();
        } else {
            address = "-1";
        }

        //payment method and payment
        System.out.println("""
                            Do you want to change the employee's payment method?
                            1 for yes
                            0 for no""");
        intInput = scanner.nextInt();

        if (intInput == 1) {
            System.out.println("Select the payment method\n" +
                    "1 check by post\n" +
                    "2 check in hands\n" +
                    "3 bank account deposit");
            paymentMethod = scanner.nextShort();
        } else {
            paymentMethod = -1;
        }
        double monetaryBase = -1;
        if (selectedEmployee instanceof Hourly) {
            System.out.println("""
                                Do you want to change the employee's hour payment?
                                1 for yes
                                0 for no""");
            intInput = scanner.nextInt();
            if (intInput == 1) {
                System.out.println("Enter the new hour payment tax:");
                monetaryBase = scanner.nextDouble();
            } else {
                monetaryBase = -1;
            }
        } else if (selectedEmployee instanceof Salaried) {
            System.out.println("""
                                Do you want to change the employee's Salary?
                                1 for yes
                                0 for no""");
            intInput = scanner.nextInt();
            if (intInput == 1) {
                System.out.println("Enter the new salary:");
                monetaryBase = scanner.nextDouble();
            } else {
                monetaryBase = -1;
            }
        }
        if (selectedEmployee instanceof Commissioned) {
            System.out.println("""
                                Do you want to change the employee's Commission tax?
                                1 for yes
                                0 for no""");
            intInput = scanner.nextInt();
            if (intInput == 1) {
                System.out.println("Enter the new Commission tax:");
                commission = scanner.nextDouble();
            } else {
                commission = -1;
            }
        }
        //syndicate
        assert selectedEmployee != null;
        if (selectedEmployee.getSyndicate() == null) {
            System.out.println("""
                                Do you want to enter a Syndicate?
                                1 for yes
                                0 for no""");
            if (intInput == 1) {
                haveSyndicate = 1;
                System.out.println("Enter the new syndicate tax:");
                tax = scanner.nextDouble();
            } else {
                commission = -1;
            }
        } else {
            System.out.println("""
                                Do you want to leave a Syndicate?
                                1 for yes
                                0 for no""");
            intInput = scanner.nextInt();
            if (intInput == 1) {
                haveSyndicate = -1;
            } else {
                haveSyndicate = 1;

                System.out.println("""
                                    Do you want to change the Syndicate tax?
                                    1 for yes
                                    0 for no""");
                intInput = scanner.nextInt();

                if (intInput == 1) {
                    System.out.println("Enter the new syndicate tax:");
                    tax = scanner.nextDouble();
                } else {
                    tax = -1;
                }
            }
        }
        if (updateEmployee(data, input, cpf, name, address, paymentMethod, monetaryBase, commission, haveSyndicate, tax) == 1) {
            System.out.println("Don't exist any Employee with the described cpf");
        } else {
            System.out.println("Employee successfully updated");
        }
    }

}
