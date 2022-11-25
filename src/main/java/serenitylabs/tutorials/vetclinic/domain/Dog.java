package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {
    private final String name;
    private final LocalDate dateOfBirth;
    private final String breed;
    private final String colour;
    private final String favouriteFood;
    private final String favouriteToy;

    private Dog(String name, LocalDate dateOfBirth, String breed, String colour, String favouriteFood,
                String favouriteToy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
        this.colour = colour;
        this.favouriteFood = favouriteFood;
        this.favouriteToy = favouriteToy;
    }

    public static WithBreed called(String name) {
        return new DogBuilder(name);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String getFavouriteToy() {
        return favouriteToy;
    }

    interface WithBreed {
        WithColor ofBreed(String breed);
    }

    interface WithColor {
        DogBuilder ofColour(String colour);
    }

    public static class DogBuilder implements WithBreed, WithColor {
        private final String name;
        private String breed;

        private String colour;
        private String food;
        private String toy;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogBuilder ofColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Dog bornOn(LocalDate dateOfBirth) {
            return new Dog(name, dateOfBirth, breed, colour, food, toy);
        }

        public DogBuilder withFavouriteFood(String food) {
            this.food = food;
            return this;
        }

        public DogBuilder withFavouriteToy(String toy) {
            this.toy = toy;
            return this;
        }
    }
}
