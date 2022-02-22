package data;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;
import Models.payment.PaymentSchedule;
import Models.syndicates.Syndicate;

import java.io.Serializable;
import java.util.ArrayList;

public class DataManager implements Serializable {
    //simulating a "database"
    public ArrayList<Employee> employees;
    public ArrayList<String> paymentMethods;
    public ArrayList<PaymentSchedule> paymentSchedules;

    public DataManager() {
        this.paymentMethods = new ArrayList<>();
        populatePaymentMethodOptions();

        this.paymentSchedules = new ArrayList<>();
        populatePaymentschedulesOptions();

        this.employees = new ArrayList<>();
        populateInicialEmployees();
    }
    private void populatePaymentMethodOptions(){
        this.paymentMethods.add("the check by post");
        this.paymentMethods.add("the check in hands");
        this.paymentMethods.add("bank account deposit");
    }
    private void populatePaymentschedulesOptions(){
        this.paymentSchedules.add(new PaymentSchedule(1, 5));
        this.paymentSchedules.add(new PaymentSchedule(0));
        this.paymentSchedules.add(new PaymentSchedule(2, 5));
    }
    private void populateInicialEmployees(){
        this.employees.add(new Hourly("Horista", "endereco", "1", paymentSchedules.get(0),
                paymentMethods.get(0), 8.5, new Syndicate(1.6)));
        this.employees.add(new Salaried("Assalariado", "endereco", "2", paymentSchedules.get(0),
                paymentMethods.get(0), 1060));
        this.employees.add(new Commissioned("Comissioned", "endereco", "3", paymentSchedules.get(0),
                paymentMethods.get(0), 1060, 0.03));
    }
}
