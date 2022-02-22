package Models.syndicates;

import java.io.Serializable;
import java.time.LocalDate;

public class AdditionalTax implements Serializable {
    private LocalDate date;
    private Double value;

    public AdditionalTax(double _value) {
        this.date = LocalDate.now();
        this.value = _value;
    }

    private String appendString() {
        return "\n\t\tAdditionalServiceTax{" + "value=" + value + ", date=" + date + '}';
    }

    @Override
    public String toString() {
        return appendString();
    }
}
