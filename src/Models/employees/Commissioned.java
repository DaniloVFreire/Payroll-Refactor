package Models.employees;

import Models.payment.PaymentSchedule;
import Models.salesResults.SaleResult;
import Models.syndicates.Syndicate;

import java.util.ArrayList;

public class Commissioned extends Salaried {
    private double commissionTax;
    private ArrayList<SaleResult> salesResult = new ArrayList<SaleResult>();
    public Commissioned(String _name, String _address, String _cpf,
                        PaymentSchedule _paymentSchedule,String _paymentMethod,
                        double _salary, double _commissionTax,
                        Syndicate _syndicate){

        super(_name, _address, _cpf, _paymentSchedule, _paymentMethod,  _salary, _syndicate);
        this.commissionTax = _commissionTax;
    }
    public Commissioned(String _name, String _address, String _cpf,
                        PaymentSchedule _paymentSchedule ,String _paymentMethod,
                        double _salary, double _commissionTax){
        this(_name, _address, _cpf, _paymentSchedule, _paymentMethod, _salary, _commissionTax, null);
    }

    public void setCommissionTax(double commissionTax) {
        this.commissionTax = commissionTax;
    }

    public void pay(){
        System.out.println("The employee " + this.getName() +" has been payed");
    }
    public void postSalesResult(double saleValue){
        salesResult.add(new SaleResult(saleValue));
    }
    @Override
    public String toString(){
        return super.getName()+ " " + super.getAddress() + " " +super.getCpf();
    }
}
