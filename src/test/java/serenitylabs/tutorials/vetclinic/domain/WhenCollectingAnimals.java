package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class WhenCollectingAnimals {
    @Test
    public void a_list_of_animals_can_contain_cats_and_dogs() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");
        Dog felix = Dog.called("Felix").ofBreed("Siamese").andOfColour("White");

        List<Animal> animals = new ArrayList<>();
        animals.add(fido);
        animals.add(felix);

        assertThat(animals, hasItems(felix, fido));
    }
}
