package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

public class SalesTaxService {

    public SalesTax salesTaxEntryFor(LineItem item) {

        TaxRate applicableTaxRate = taxRateFor(item);

        return SalesTax.atRateOf(applicableTaxRate.getRate())
                .withName(applicableTaxRate.getName())
                .forAnAmountOf(item.getTotal() * applicableTaxRate.getRate());
    }

    private TaxRate taxRateFor(LineItem item) {
        TaxRateCalculator taxRateCalculator;
        switch (item.getCategory()) {
            case Books:
            case Medicine:
                taxRateCalculator = new ZeroRateCalculator();
                break;
            case Snacks:
            case SoftDrinks:
                taxRateCalculator = new ReducedRateCalculator();
                break;
            case Toys:
            case PetFood:
                taxRateCalculator = new StandardRateCalculator();
                break;
            default:
                throw new UnknownProductCategoryException("Category [" + item.getCategory() + "] not known.");
        }
        return taxRateCalculator.rateFor(item);
    }
}
