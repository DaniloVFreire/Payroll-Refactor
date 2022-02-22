package view;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;
import data.DataManager;
import view.commands.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

import static controller.EmployeesController.*;
import static controller.PaymentController.*;
import static controller.StateController.*;

public class TextInterface {
    public static void logicMenu(DataManager data) {
        Stack<String> undo = new Stack<>();
        Stack<String> redo = new Stack<>();
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new ShowFunctionalities());
        commands.add(new AddEmployee(data, scanner));
        commands.add(new RemoveEmployee(data, scanner));
        commands.add(new PostTimeCard(data, scanner));
        commands.add(new PostSalesResult(data, scanner));
        commands.add(new PostAdicionalTax(data, scanner));
        commands.add(new UpdateEmployee(data, scanner));
        commands.add(new RunPayroll(data, scanner));
        commands.add(new Undo(data, undo, redo));
        commands.add(new Redo(data, undo, redo));
        commands.add(new ChangePaymentSchedule(data, scanner));
        commands.add(new CreateNewPaymentSchedule(data, scanner));
        commands.add(new ListEmployees(data));

        welcome();
        commands.get(0).execute();

        short commandIndex;
        boolean on = true;
        while(on){
            commandIndex = scanner.nextShort();
            if(commandIndex>=0 && commandIndex<=12){
                if ((commandIndex >= 1) && (commandIndex <= 7) || (commandIndex >= 10) && (commandIndex <= 11)) {
                    undo.push(storeState(data));
                }
                commands.get(commandIndex).execute();
            }
            else if(commandIndex == 13){
                on = false;
                System.out.println("You're welcome, bye!");
            }
            else{
                System.out.println("That option does not exists, to show all possible options type 0");
            }
        }

        DataManager example;


        Employee selectedEmployee = null;

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
