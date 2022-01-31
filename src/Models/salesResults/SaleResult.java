package Models.salesResults;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

public class SaleResult implements Serializable {
    double saleValue;
    LocalDate date;

    public SaleResult(double _saleValue, LocalDate _date){
        this.saleValue = _saleValue;
        this.date = _date;
    }

    public SaleResult(double _saleValue){
        this.saleValue = _saleValue;
        this.date = LocalDate.now();
    }
}
