package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public class ReducedRateCalculator implements TaxRateCalculator {
    @Override
    public TaxRate rateFor(LineItem item) {
        TaxRate taxRate;
        if (item.getTotal() > 100.0) {
            taxRate = new TaxRate(0.135, "Reduced");
        } else {
            taxRate = new TaxRate(0.09, "Reduced");
        }
        return taxRate;
    }
}
