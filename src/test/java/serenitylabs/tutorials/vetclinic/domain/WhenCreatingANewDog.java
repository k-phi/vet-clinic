package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {
    @Test
    public void it_should_have_a_name() throws Exception {
        LocalDateTime birthday = LocalDateTime.now();

        Dog fido = Dog.called("Fido")
                .ofBreed("Poodle")
                .bornOn(birthday);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Poodle", fido.getBreed());
        Assert.assertEquals(birthday, fido.getDateOfBirth());
    }

    @Test
    public void it_should_have_an_optional_favourite_food() throws Exception {
        LocalDateTime birthday = LocalDateTime.now();

        Dog fido = new Dog("Fido", "Poodle", birthday, "Pizza");

        Assert.assertEquals("Pizza", fido.getFavouriteFood());
    }


}
