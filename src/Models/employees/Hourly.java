package Models.employees;

import Models.payment.PaymentSchedule;
import Models.salesResults.SaleResult;
import Models.syndicates.Syndicate;
import Models.timecards.Timecard;

import java.util.ArrayList;

public class Hourly extends Employee {
    private double hourCost;
    private ArrayList<Timecard> timecards = new ArrayList<Timecard>();

    public Hourly(String _name, String _address, String _cpf,
                  PaymentSchedule _paymentSchedule, String _paymentMethod, double _hourCost){

        super(_name, _address, _cpf,
                _paymentSchedule, _paymentMethod);
        this.hourCost = _hourCost;
    }
    public Hourly(String _name, String _address, String _cpf,
                  PaymentSchedule _paymentSchedule,String _paymentMethod, double _hourCost
            ,Syndicate _syndicate){

        super(_name, _address, _cpf,
                _paymentSchedule, _paymentMethod,
                _syndicate);
        this.hourCost = _hourCost;
    }

    public short postTimeCard(double workedHours){
        this.timecards.add(new Timecard(workedHours));
        if(workedHours>=0){
            if (workedHours <= 8){
                this.setCalculatedSalary( getCalculatedSalary() + (hourCost * workedHours) );
            }
            else{
                this.setCalculatedSalary( getCalculatedSalary() + (hourCost * 8) );
                this.setCalculatedSalary( getCalculatedSalary() + ( (hourCost * 1.5) * (workedHours - 8) ) );
            }
            this.timecards.add(new Timecard(workedHours));
            return 0;
        }
        else{
            return 1;
        }
    }


    public void setPaymentTax(double hourCost){
        if (Hourly.this.hourCost>0){
            this.hourCost = Hourly.this.hourCost;
        }
    }

    public void pay(){
        System.out.println("The employee " + this.getName() +" has been payed");
    }

    @Override
    public String toString(){
        return super.getName()+ " " + super.getAddress() + " " +super.getCpf();
    }
}
