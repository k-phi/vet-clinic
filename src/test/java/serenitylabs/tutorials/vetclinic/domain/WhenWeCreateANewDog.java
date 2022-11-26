package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class WhenWeCreateANewDog {
    private final static LocalDate THE_FOURTH_OF_JULY = LocalDate.of(2022, 7, 4);

    @Test
    public void a_new_dog_should_have_a_name() {
        Dog fido = DogBreeder.aLargeDog()
                .called("Fido")
                .ofColour("black")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
        Assert.assertEquals("black", fido.getColour());
    }

    @Test
    public void a_dog_can_have_an_optional_favourite_food() {
        Dog fido = DogBreeder.aSmallDog()
                .called("Spot")
                .ofColour("black")
                .withFavouriteFood("Pizza")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Spot", fido.getName());
        Assert.assertEquals("Poodle", fido.getBreed());
        Assert.assertEquals("Pizza", fido.getFavouriteFood());
    }

    @Test
    public void a_dog_can_haven_an_optional_favourite_toy() {
        Dog fido = DogBreeder.aGuardDog()
                .called("Rex")
                .ofColour("black")
                .withFavouriteToy("Ball")
                .bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Rex", fido.getName());
        Assert.assertEquals("German shepherd", fido.getBreed());
        Assert.assertEquals("Ball", fido.getFavouriteToy());
    }
}
