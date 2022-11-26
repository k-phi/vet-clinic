package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class DogBreeder implements WithBreed, WithColor {
    private String name;
    private String breed;

    private String colour;
    private String food;
    private String toy;

    private static WithBreed aDog() {
        return new DogBreeder();
    }

    public static DogBreeder aLargeDog() {
        return aDog().ofBreed("Labrador");
    }

    public static DogBreeder aSmallDog() {
        return aDog().ofBreed("Poodle");
    }

    public static DogBreeder aGuardDog() {
        return aDog().ofBreed("German shepherd");
    }

    public WithColor called(String name) {
        this.name = name;
        return this;
    }

    public DogBreeder ofBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public DogBreeder ofColour(String colour) {
        this.colour = colour;
        return this;
    }

    public Dog bornOn(LocalDate dateOfBirth) {
        return new Dog(name, dateOfBirth, breed, colour, food, toy);
    }

    public DogBreeder withFavouriteFood(String food) {
        this.food = food;
        return this;
    }

    public DogBreeder withFavouriteToy(String toy) {
        this.toy = toy;
        return this;
    }
}
