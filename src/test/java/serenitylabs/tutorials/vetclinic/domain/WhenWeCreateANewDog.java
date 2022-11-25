package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class WhenWeCreateANewDog {
    private final static LocalDate THE_FOURTH_OF_JULY = LocalDate.of(2022, 7, 4);

    @Test
    public void a_new_dog_should_have_a_name() {
        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("black")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
        Assert.assertEquals("black", fido.getColour());
    }

    @Test
    public void a_dog_can_have_an_optional_favourite_food() {
        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("black")
                .withFavouriteFood("Pizza")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Pizza", fido.getFavouriteFood());
    }

    @Test
    public void a_dog_can_haven_an_optional_favourite_toy() {
        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColour("black")
                .withFavouriteToy("Ball")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Ball", fido.getFavouriteToy());
    }

}
