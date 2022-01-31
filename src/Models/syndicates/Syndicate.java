package Models.syndicates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Syndicate implements Serializable {
    private UUID SyndicateId;
    private double basetax;
    private ArrayList<AdditionalTax> additionalTaxes;
    public Syndicate(double _baseTax){
        this.SyndicateId = UUID.randomUUID();
        this.basetax = _baseTax;
        additionalTaxes = new ArrayList<>();
    }
    public void setAdditionalTaxes(AdditionalTax additionalTax) {
        this.additionalTaxes.add(additionalTax);
    }
}
