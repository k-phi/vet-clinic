package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public class Dog {
    private final String name;
    private final LocalDate dateOfBirth;
    private final String breed;

    public Dog(String name, LocalDate dateOfBirth, String breed) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.breed = breed;
    }

    public static DogBuilder called(String name) {
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

    public static class DogBuilder {
        private final String name;
        private String breed;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDate dateOfBirth) {
            return new Dog(name, dateOfBirth, breed);
        }
    }
}
