package view.commands;

import data.DataManager;

public class ShowFunctionalities implements Command{
    @Override
    public DataManager execute(DataManager data){
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
        return data;
    }

}
