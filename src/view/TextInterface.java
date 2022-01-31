package view;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;
import data.DataManager;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

import static controller.EmployeesController.*;
import static controller.PaymentController.*;
import static controller.StateController.*;

public class TextInterface {
    public static void logicMenu(DataManager data) {
        welcome();
        Stack<String> undo = new Stack<>();
        Stack<String> redo = new Stack<>();

        DataManager example;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String input, cpf, name, address;
        int intInput;
        double doubleInput, commission, tax = -1.0;
        short shortInput, haveSyndicate = -1;
        Employee selectedEmployee = null;
        showFunctionalities();
        while (true) {
            intInput = scanner.nextInt();
            if ((intInput >= 1) && (intInput <= 7) || (intInput >= 10) && (intInput <= 11)) {
                undo.push(storeState(data));
            }
            switch (intInput) {
                case 0:
                    showFunctionalities();
                    break;
                case 1:
                    //basic information
                    System.out.println("Enter the employee's name");
                    name = scanner.next();

                    System.out.println("Enter the employee's address:");
                    address = scanner.next();

                    System.out.println("Enter the employee's cpf(id) :");
                    cpf = scanner.next();

                    //Category and specifications
                    System.out.print("""
                            Enter the employee's category :
                            Hourly 1
                            Salaried 2
                            Commissioned 3
                            """);
                    short category = scanner.nextShort();

                    double moneyBase = -1;
                    commission = -1;
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
                    haveSyndicate = scanner.nextShort();
                    tax = -1;
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
                    break;
                case 2:
                    System.out.println("Enter the employee cpf:");
                    input = scanner.next();

                    if (deleteEmployee(data, input) == 1) {
                        System.out.println("Don't exist any Employee with the described cpf");
                    } else {
                        System.out.println("Deletion Successfully executed");
                    }
                    break;
                case 3:
                    System.out.println("Enter the employee cpf");
                    input = scanner.next();

                    System.out.println("Enter the worked hours");
                    intInput = scanner.nextInt();

                    switch (postTimeCard(data, input, intInput)) {
                        case 1 -> System.out.println("Don't exist any Employee with the described cpf");
                        case 2 -> System.out.println("The select Employee is not an Hourly");
                        case 3 -> System.out.println("The time input should be positive");
                        default -> System.out.println("Time card successfully posted");
                    }
                    break;
                case 4:
                    System.out.println("Enter the employee cpf:");
                    input = scanner.next();

                    System.out.println("Enter the sales value:");
                    doubleInput = scanner.nextDouble();

                    switch (postSalesResult(data, input, doubleInput)) {
                        case 1 -> System.out.println("Don't exist any Employee with the described cpf");
                        case 2 -> System.out.println("The select Employee is not an Commissioned");
                        default -> System.out.println("Sales result successfully posted");
                    }
                    break;
                case 5:// post an additional syndicalist tax
                    System.out.println("enter the employee cpf");
                    input = scanner.next();

                    System.out.println("enter the syndicalist tax");
                    doubleInput = scanner.nextDouble();

                    if (postServiceTax(data, input, doubleInput) == 1) {
                        System.out.println("Don't exist any Employee with the described cpf");
                    } else if(postServiceTax(data, input, doubleInput) == 2){
                        System.out.println("The Employee does not have an syndicate");
                    } else {
                    System.out.println("Service tax successfully posted");
                }
                    break;
                case 6://Update employee

                    //edit basic data
                    System.out.println("enter the employee cpf");
                    input = scanner.next();
                    selectedEmployee = findEmployeeByCpf(data, input);
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
                    commission = -1;
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
                    break;
                case 7:
                    System.out.println("Enter a date" +
                            "Obs: (date format YYYY-MM-D)");
                    input = scanner.next();
                    payroll(data, input);
                    break;
                case 8://undo
                    example = undo(data, undo, redo);
                    if (example == null) {
                        System.out.println("Stack is clear, you cant undo");
                    } else {
                        data = example;
                        System.out.println("Redo successfully applied");
                    }
                    break;
                case 9://redo
                    example = redo(data, undo, redo);
                    if (example == null) {
                        System.out.println("Stack is clear, you cant undo");
                    } else {
                        data = example;
                        System.out.println("Redo successfully applied");
                    }
                    break;
                case 10://change payment schedule
                    System.out.println("enter the employee's cpf");
                    input = scanner.next();
                    for (int i = 0; i < data.paymentSchedules.size(); i++) {
                        System.out.println(i + " - " + data.paymentSchedules.get(i));
                    }
                    System.out.println("Select your payment schedule from 0 to n");
                    shortInput = scanner.nextShort();
                    switch (editEmployeePaymenntSchedule(data, input, shortInput)) {
                        case 1 -> System.out.println("Don't exist any type equals the described");
                        default -> System.out.println("Payment schedule successfully added");
                    }
                    break;
                case 11://to create a new payment schedule
                    System.out.println("enter the new payment schedule" +
                            "(Ex: 'weekly 1' monthly $)");
                    input = scanner.next();

                    switch (addPaymentSchedule(data, input)) {
                        case 1 -> System.out.println("Don't exist any type equals the described");
                        default -> System.out.println("Payment schedule successfully added");
                    }
                    break;
                case 12:
                    System.out.println("   name   |   address   |   cpf   ");
                    for (Employee employee : data.employees) {
                        System.out.println(employee);
                    }
                    System.out.println();
                    break;
                case 13:
                    return;
                default:
                    System.out.println("That option does not exists, to show all possible options type 0");
            }
        }
    }

    public static void showFunctionalities() {
        System.out.print("""
                Functionalities
                0 To see the options
                1 To add an Employee
                2 To remove an Employee
                3 To post a time card
                4 To post a sales result
                5 To post a service tax
                6 To change a Employee's details
                7 To run payroll for today
                8 To undo
                9 To redo
                10 To change the payment schedule
                11 To create a new payment schedule
                12 To See employees data
                13 To exit
                """);
    }

    public static void welcome() {
        System.out.println("""
                __          __  _                            _                      \s
                     \\ \\        / / | |                          | |                     \s
                      \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___                \s
                       \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\               \s
                        \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) |              \s
                         \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/               \s
                      _____                      _ _    _____           _                \s
                     |  __ \\                    | | |  / ____|         | |               \s
                     | |__) |_ _ _   _ _ __ ___ | | | | (___  _   _ ___| |_ ___ _ __ ___ \s
                     |  ___/ _` | | | | '__/ _ \\| | |  \\___ \\| | | / __| __/ _ \\ '_ ` _ \\\s
                     | |  | (_| | |_| | | | (_) | | |  ____) | |_| \\__ \\ ||  __/ | | | | |
                     |_|   \\__,_|\\__, |_|  \\___/|_|_| |_____/ \\__, |___/\\__\\___|_| |_| |_|
                                  __/ |                        __/ |                     \s
                                 |___/                        |___/                      \s""");
    }
}
