package Models.employees;

import Models.payment.PaymentSchedule;
import Models.syndicates.Syndicate;

public class Salaried extends Employee {
    private double salary;

    public Salaried(String _name, String _address, String _cpf, PaymentSchedule _paymentSchedule ,String _paymentMethod, double _salary){
        this(_name, _address, _cpf, _paymentSchedule, _paymentMethod,_salary, null);
    }

    public Salaried(String _name, String _address, String _cpf, PaymentSchedule _paymentSchedule ,String _paymentMethod, double _salary, Syndicate _syndicate){
        super(_name, _address, _cpf, _paymentSchedule, _paymentMethod,_syndicate);
        salary = _salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void salaryDefinition(double _salary){
        this.salary = _salary;
    }

    public void pay(){
        System.out.println("The employee " + this.getName() +" has been payed in: R$" + salary);
    }

}
