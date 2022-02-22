package view.commands;

import Models.employees.Employee;
import data.DataManager;

public class ListEmployees implements Command{

    @Override
    public DataManager execute(DataManager data) {
         System.out.println("   name   |   address   |   cpf   ");
        for (Employee employee : data.employees) {
            System.out.println(employee);
        }
        System.out.println();
        return data;
    }
}
