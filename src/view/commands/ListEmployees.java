package view.commands;

import Models.employees.Employee;
import data.DataManager;

public class ListEmployees implements Command{
    DataManager data;
    public ListEmployees(DataManager _data){
        this.data = _data;
    }


    @Override
    public void execute() {
        System.out.println("   name   |   address   |   cpf   ");
        for (Employee employee : data.employees) {
            System.out.println(employee);
        }
        System.out.println();
    }
}
