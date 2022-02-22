package controller;

import Models.employees.Employee;
import Models.payment.PaymentSchedule;
import data.DataManager;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class PaymentController {

    public static void payroll(DataManager data, String date){
//        LocalDate date1 = LocalDate.parse(date);
        System.out.println("Funcionalidade indisponível");
    }
    public static short addPaymentSchedule(DataManager data, String input){
        String [] inputArray;
        inputArray = input.split(" ");
        if(inputArray[0].equals("monthly")){
            if(inputArray[1].equals("$")){
                data.paymentSchedules.add(new PaymentSchedule(0));
            }
            else{
                data.paymentSchedules.add(new PaymentSchedule(parseInt(inputArray[1])));
            }
        }
        else if(inputArray[0].equals("weekly")){
            data.paymentSchedules.add(new PaymentSchedule(parseInt(inputArray[1]),
                    DayOfWeek.valueOf(inputArray[2].toUpperCase()).getValue()));
        }
        else{
            return 1;
        }
        return 0;
    }

    public static PaymentSchedule findPaymentSchedule(DataManager data, int frequency, int weekday){
        for (PaymentSchedule paymentSchedule : data.paymentSchedules) {
            if (paymentSchedule.getDay() == -1  &&
                    paymentSchedule.getFrequency() == frequency &&
                    paymentSchedule.getWeekDay() == weekday) {
                return paymentSchedule;
            }
        }
        return null;
    }
    public static PaymentSchedule findPaymentSchedule(DataManager data, int day){
        for (PaymentSchedule paymentSchedule : data.paymentSchedules) {
            if (paymentSchedule.getFrequency() == -1 &&
                    paymentSchedule.getWeekDay() == -1 &&
                    paymentSchedule.getDay() == day ) {
                return paymentSchedule;
            }
        }
        return null;
    }
}
