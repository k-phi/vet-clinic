package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import java.util.HashMap;
import java.util.Map;

public class SalesTaxService {

    private static final Map<ProductCategory, TaxRateCalculator> CALCULATOR_PER_PRODUCT = new HashMap<>();

    static {
        CALCULATOR_PER_PRODUCT.put(ProductCategory.Snacks, new ReducedRateCalculator());
        CALCULATOR_PER_PRODUCT.put(ProductCategory.SoftDrinks, new ReducedRateCalculator());
        CALCULATOR_PER_PRODUCT.put(ProductCategory.Books, new ZeroRateCalculator());
        CALCULATOR_PER_PRODUCT.put(ProductCategory.Medicine, new ZeroRateCalculator());
    }

    public SalesTax salesTaxEntryFor(LineItem item) {

        TaxRate applicableTaxRate = taxRateFor(item);

        return SalesTax.atRateOf(applicableTaxRate.getRate())
                .withName(applicableTaxRate.getName())
                .forAnAmountOf(item.getTotal() * applicableTaxRate.getRate());
    }

    private TaxRate taxRateFor(LineItem item) {
        TaxRateCalculator taxRateCalculator = CALCULATOR_PER_PRODUCT
                .getOrDefault(item.getCategory(), new StandardRateCalculator());
        return taxRateCalculator.rateFor(item);
    }
}
