package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import java.util.HashMap;
import java.util.Map;

public class SalesTaxService {
    private static final Map<ProductCategory, TaxRateCalculator> CALCULATOR_PER_PRODUCT = new HashMap<>();
    private static final TaxRateCalculator ZERO_RATE = (item) -> new TaxRate(0.0, "Zero");
    private static final TaxRateCalculator STANDARD_RATE = (item) -> new TaxRate(0.23, "Standard");
    private static final TaxRateCalculator REDUCED_RATE = (item) -> {
        double rate = (item.getTotal() > 100.0) ? 0.135 : 0.09;
        return new TaxRate(rate, "Reduced");
    };

    static {
        CALCULATOR_PER_PRODUCT.put(ProductCategory.Snacks, REDUCED_RATE);
        CALCULATOR_PER_PRODUCT.put(ProductCategory.SoftDrinks, REDUCED_RATE);
        CALCULATOR_PER_PRODUCT.put(ProductCategory.Books, ZERO_RATE);
        CALCULATOR_PER_PRODUCT.put(ProductCategory.Medicine, ZERO_RATE);
    }

    public SalesTax salesTaxEntryFor(LineItem item) {

        TaxRate applicableTaxRate = taxRateFor(item);

        return SalesTax.atRateOf(applicableTaxRate.getRate())
                .withName(applicableTaxRate.getName())
                .forAnAmountOf(item.getTotal() * applicableTaxRate.getRate());
    }

    private TaxRate taxRateFor(LineItem item) {
        TaxRateCalculator taxRateCalculator = CALCULATOR_PER_PRODUCT
                .getOrDefault(item.getCategory(), STANDARD_RATE);
        return taxRateCalculator.apply(item);
    }
}
