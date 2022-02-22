package Models.syndicates;

import java.io.Serializable;
import java.time.LocalDate;

public class AdditionalTax implements Serializable {
    private LocalDate date;
    private Double value;

    public AdditionalTax(double _value, LocalDate _date) {
        this.date = _date;
        this.value = _value;
    }

    public AdditionalTax(double _value) {
        this.date = LocalDate.now();
        this.value = _value;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    private String appendString() {
        return "\n\t\tAdditionalServiceTax{" + "value=" + value + ", date=" + date + '}';
    }

    @Override
    public String toString() {
        return appendString();
    }
}
