package controller;

import Models.employees.Commissioned;
import Models.employees.Employee;
import Models.employees.Hourly;
import Models.employees.Salaried;
import Models.payment.PaymentSchedule;
import Models.syndicates.Syndicate;
import data.DataManager;

import static controller.PaymentController.findPaymentSchedule;

public class EmployeesController {

    public static short editEmployeePaymenntSchedule(DataManager data, String cpf, short selection){
        cpf = validateAndFormatCpf(cpf);
        Employee selected = findEmployeeByCpf(data, cpf);
        if(selection>=0 && selection<=data.paymentSchedules.size()){
            assert selected != null;
            selected.setPaymentSchedule(data.paymentSchedules.get(selection));
        }
        else {
            return 1;
        }
        return 0;
    }

    public static short updateEmployee(DataManager data, String cpf,String newCpf, String name, String address,
    short paymentMethod,double monetaryBase, double commission, short haveSyndicate, double tax){
        cpf = validateAndFormatCpf(cpf);
        Employee selected = findEmployeeByCpf(data, cpf);
        if (selected == null){
            return 1;
        }
        else{
            if(!newCpf.equals("-1")){
                selected.setCpf(newCpf);
            }
            if(!name.equals("-1")){
                selected.setName(name);
            }
            if(!address.equals("-1")){
                selected.setAddress(address);
            }
            if(paymentMethod >=1 && paymentMethod<=3){

                selected.setPaymentMethod(data.paymentMethods.get(paymentMethod-1));
            }
            if(paymentMethod >=1 && paymentMethod<=3){

                selected.setPaymentMethod(data.paymentMethods.get(paymentMethod-1));
            }

            if (selected instanceof Hourly){
                ((Hourly) selected).setPaymentTax(monetaryBase);
            }
            else if(selected instanceof Salaried){
                ((Salaried) selected).setSalary(monetaryBase);
            }
            if (selected instanceof Commissioned){
                ((Commissioned) selected).setCommissionTax(commission);
            }

            if (haveSyndicate==-1){
                selected.setSyndicate(null);
            }
            else if(selected.getSyndicate() != null&& tax !=-1){
                selected.setSindicalTax(tax);
            }
        }
        return 0;
    }

    public static short postServiceTax(DataManager data, String cpf, double value){
        cpf = validateAndFormatCpf(cpf);
        Employee selected = findEmployeeByCpf(data, cpf);
        if (selected == null){
            return 1;
        }
        else{
            if (selected.getSyndicate() !=null){
                selected.setSindicalTax(value);
            }
            else{
                return 2;
            }
        }
        return 0;
    }

    public static short postSalesResult(DataManager data, String cpf, double value){
        cpf = validateAndFormatCpf(cpf);
        Employee selected = findEmployeeByCpf(data, cpf);
        if (selected == null){
            return 1;
        }
        else{
            if(selected instanceof Commissioned){
                ((Commissioned)selected).postSalesResult(value);
            }
            else {
                return 2;
            }
        }
        return 0;
    }

    public static short postTimeCard(DataManager data, String cpf, int time){
        cpf = validateAndFormatCpf(cpf);
        Employee selected = findEmployeeByCpf(data, cpf);
        if (selected == null){
            return 1;
        }
        else{
            if(selected instanceof Hourly){
                if(((Hourly)selected).postTimeCard(time) == 1){
                    return 3;
                }
            }
            else {
                return 2;
            }
        }
        return 0;
    }

    public static short deleteEmployee(DataManager data, String cpf){
        final String treatedCpf = validateAndFormatCpf(cpf);
        if(findEmployeeByCpf(data, treatedCpf) == null){
            return 1;
        }
        else{
            data.employees.removeIf(employee -> employee.getCpf().equals(treatedCpf));
        }
        return 0;
    }

    public static short createEmployee(DataManager data, String name, String address, String cpf,
                                       short category,short paymentMethod, double monetaryBase, double commission,
                                       short haveSyndicate, double tax){
        cpf = validateAndFormatCpf(cpf);
        PaymentSchedule schedule = null;
        String selectedPaymentMethod;
        if (paymentMethod >=1 && paymentMethod <=3){
            selectedPaymentMethod = data.paymentMethods.get(paymentMethod-1);
        }
        else{
            return 3;
        }
        if(findEmployeeByCpf(data, cpf)==null){
            switch (category){
                case 1:
                    schedule = findPaymentSchedule(data,1, 5);
                    if(haveSyndicate == 1){
                        data.employees.add(new Hourly(name, address, cpf, schedule, selectedPaymentMethod, monetaryBase, new Syndicate(tax)));
                    }
                    else{
                        data.employees.add(new Hourly(name, address, cpf, schedule,selectedPaymentMethod, monetaryBase));
                    }
                    break;
                case 2:
                    schedule = findPaymentSchedule(data, 0);
                    if(haveSyndicate == 1){
                        data.employees.add(new Salaried(name, address, cpf, schedule, selectedPaymentMethod ,monetaryBase,new Syndicate(tax)));
                    }
                    else {
                        data.employees.add(new Salaried(name, address, cpf, schedule, selectedPaymentMethod , monetaryBase));
                    }
                    break;
                case 3:
                    schedule = findPaymentSchedule(data, 1, 5);
                    if(haveSyndicate == 1){
                        data.employees.add(new Commissioned(name, address, cpf, schedule,selectedPaymentMethod ,monetaryBase, commission,new Syndicate(tax)));
                    }
                    else {
                        data.employees.add(new Commissioned(name, address, cpf, schedule,selectedPaymentMethod, monetaryBase, commission));
                    }
                    break;
                default:
                    return 2;
            }
        }
        else{
            return 1;
        }

        return 0;
    }

    public static String validateAndFormatCpf(String cpf){
        String newCpf = cpf.replaceAll(" ", "");
        newCpf = newCpf.replaceAll("\\.", "");
        return newCpf;
    }

    public static Employee findEmployeeByCpf(DataManager data, String cpf){
        cpf = validateAndFormatCpf(cpf);
        for (Employee employee : data.employees) {
            if (employee.getCpf().equals(cpf)) {
                return employee;
            }
        }
        return null;
    }
}
