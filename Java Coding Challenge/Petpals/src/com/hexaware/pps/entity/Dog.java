package com.hexaware.pps.entity;

public class Dog extends Pets {
    private String dogBreed;

    public Dog(String name, int age, String breed, String dogBreed) {
        super(name, age, breed);
        this.dogBreed = dogBreed;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    @Override
    public String toString() {
        return super.toString() + ", DogBreed=" + dogBreed;
    }
}
