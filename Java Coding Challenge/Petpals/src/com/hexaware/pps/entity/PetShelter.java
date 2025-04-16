package com.hexaware.pps.entity;

import java.util.ArrayList;
import java.util.List;

public class PetShelter {
    private List<Pets> availablePets;

    public PetShelter() {
        availablePets = new ArrayList<>();
    }

    public void addPet(Pets pet) {
        availablePets.add(pet);
        System.out.println(pet.getName() + " has been added to the shelter.");
    }

    public void removePet(Pets pet) {
        availablePets.remove(pet);
        System.out.println(pet.getName() + " has been removed from the shelter.");
    }

    public void listAvailablePets() {
        System.out.println("Available Pets in the Shelter:");
        for (Pets pet : availablePets) {
            System.out.println(pet);
        }
    }
}

