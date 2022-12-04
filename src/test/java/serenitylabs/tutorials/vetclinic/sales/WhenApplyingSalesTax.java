package serenitylabs.tutorials.vetclinic.sales;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

public class WhenApplyingSalesTax {

    private final static double ZERO_PERCENT = 0.00;
    private final static double NINE_PERCENT = 0.09;

    private final static double THIRTEEN_POINT_FIVE_PERCENT = 0.135;

    private final static double TWENTY_THREE_PERCENT = 0.23;

    @Test
    public void crisps_should_be_charged_at_the_reduced_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(1)
                .itemCalled("salt and vinegar crisps")
                .inCategory(Snacks)
                .withAUnitPriceOf(3.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(NINE_PERCENT).withName("Reduced").forAnAmountOf(0.27);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }


    @Test
    public void over_100_euros_of_crisps_is_charged_at_a_higher_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(50)
                .itemCalled("salt and vinegar crisps")
                .inCategory(Snacks)
                .withAUnitPriceOf(3.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(THIRTEEN_POINT_FIVE_PERCENT).withName("Reduced").forAnAmountOf(20.25);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void sprite_should_be_charged_at_the_reduced_rate() {
        // GIVEN
        LineItem sprite = LineItem.forASaleOf(1)
                .itemCalled("sprite")
                .inCategory(SoftDrinks)
                .withAUnitPriceOf(3.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(sprite);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(NINE_PERCENT).withName("Reduced").forAnAmountOf(0.27);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void over_100_euros_of_sprite_is_charged_at_a_higher_rate() {
        // GIVEN
        LineItem sprite = LineItem.forASaleOf(50)
                .itemCalled("sprite")
                .inCategory(SoftDrinks)
                .withAUnitPriceOf(3.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(sprite);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(THIRTEEN_POINT_FIVE_PERCENT).withName("Reduced").forAnAmountOf(20.25);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void travel_guides_are_tax_free() {
        // GIVEN
        LineItem books = LineItem.forASaleOf(20)
                .itemCalled("The New York Guide")
                .inCategory(Books)
                .withAUnitPriceOf(10.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(books);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(ZERO_PERCENT).withName("Zero").forAnAmountOf(0.00);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void pain_killers_are_tax_free() {
        // GIVEN
        LineItem pain_killers = LineItem.forASaleOf(20)
                .itemCalled("Ibuprofen")
                .inCategory(Medicine)
                .withAUnitPriceOf(11.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(pain_killers);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(ZERO_PERCENT).withName("Zero").forAnAmountOf(0.00);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void toys_are_charged_at_the_standard_rate() {
        // GIVEN
        LineItem toys = LineItem.forASaleOf(20)
                .itemCalled("Rubber bone")
                .inCategory(Toys)
                .withAUnitPriceOf(5.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(toys);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(TWENTY_THREE_PERCENT).withName("Standard").forAnAmountOf(23.00);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

    @Test
    public void pet_food_is_charged_at_the_standard_rate() {
        // GIVEN
        LineItem petFood = LineItem.forASaleOf(10)
                .itemCalled("Dog food")
                .inCategory(PetFood)
                .withAUnitPriceOf(7.00);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(petFood);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(TWENTY_THREE_PERCENT).withName("Standard").forAnAmountOf(16.10);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));
    }

}
