package Models.timecards;

import java.io.Serializable;
import java.time.LocalDate;

public class Timecard implements Serializable {
    double workedHours;
    LocalDate date;
    public Timecard(double _workedHours, LocalDate _date){
        this.workedHours = _workedHours;
        this.date = _date;
    }

    public Timecard(double _workedHours){
        this.workedHours = _workedHours;
        this.date = LocalDate.now();
    }
}
