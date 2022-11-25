package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class WhenWeCreateANewDog {
    @Test
    public void a_new_dog_should_have_a_name() {
        LocalDate THE_FOURTH_OF_JULY = LocalDate.of(2022, 7, 4);
        Dog fido = Dog.called("Fido").ofBreed("Labrador").bornOn(THE_FOURTH_OF_JULY);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals(THE_FOURTH_OF_JULY, fido.getDateOfBirth());
    }
}
