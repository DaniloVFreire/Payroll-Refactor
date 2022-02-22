package Models.employees;

import Models.payment.PaymentSchedule;
import Models.syndicates.AdditionalTax;
import Models.syndicates.Syndicate;

import java.io.Serializable;
import java.util.UUID;

public abstract class Employee implements Serializable {
    private final UUID id;
    private String name;
    private String address;
    private String cpf;
    private double calculatedSalary;

    private Syndicate syndicate;
    protected String paymentMethod;
    private PaymentSchedule paymentSchedule;

    public Employee(String _name, String _address, String _cpf,
                    PaymentSchedule _paymentSchedule,String _paymentMethod,
                    Syndicate _syndicate){
        this.id = UUID.randomUUID();
        this.name = _name;
        this.address = _address;
        this.cpf = _cpf;
        this.paymentSchedule = _paymentSchedule;
        this.syndicate = _syndicate;
        this.paymentMethod = _paymentMethod;
        calculatedSalary = 0;
    }

    public Syndicate getSyndicate() {
        return syndicate;
    }
    public String getCpf() {
        return cpf;
    }
    public String getName() {
        return name;
    }

    public double getCalculatedSalary() {
        return calculatedSalary;
    }

    public void setCalculatedSalary(double _calculatedSalary) {
        this.calculatedSalary =  _calculatedSalary;
    }

    public void setSindicalTax(double sindicalTax) {
        if (sindicalTax >= 0){
            this.syndicate.setAdditionalTaxes(new AdditionalTax(sindicalTax));
        }
        else{
            System.out.println("The tax should be a positive number");
        }
    }

    public void setSyndicate(Syndicate syndicate) {
        this.syndicate = syndicate;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public String appendString(){
        return " < "+this.name+ " " + this.address + " " +this.cpf+ " > ";
    }

    @Override
    public String toString(){
        return appendString();
    }

    public abstract void pay();
}
