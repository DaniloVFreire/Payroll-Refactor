package Models.payment;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.UUID;

public class PaymentSchedule implements Serializable {
    private int day;
    private int frequency;
    private int weekDay;

    public PaymentSchedule(int day) {
        this.day = day;
        this.frequency = -1;
        this.weekDay = -1;
    }

    public PaymentSchedule(int frequency, int weekDay) {
        day = -1;
        this.frequency = frequency;
        this.weekDay = weekDay;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public int getDay() {
        return day;
    }

    public int getFrequency() {
        return frequency;
    }
    private String typeOfSchedule(){
        String typeString = "";
        if (day!=-1) {
            if (day == 0) {
                typeString = "monthly, day= last month day";
            } else {
                typeString = "monthly, day= " + day;
            }
        } else if (weekDay!=-1) {
            typeString = "weekly, frequency payment=" +
                    frequency + "week(s)" +
                    ", week day payment=" + DayOfWeek.of(weekDay);

        }
        return typeString;
    }
    private String appendString(){
        return "PaymentSchedule{" + "type=" + typeOfSchedule() + '}';
    }

    @Override
    public String toString() {
        return appendString();
    }
}


