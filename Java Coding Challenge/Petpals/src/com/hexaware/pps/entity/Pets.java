package com.hexaware.pps.entity;

public class Pets {
	 private String name;
	    private int age;
	    private String breed;

	    public Pets(String name, int age, String breed) {
	        this.name = name;
	        this.age = age;
	        this.breed = breed;
	    }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public int getAge() { return age; }
	    public void setAge(int age) { this.age = age; }

	    public String getBreed() { return breed; }
	    public void setBreed(String breed) { this.breed = breed; }

	    @Override
	    public String toString() {
	        return "Pet [Name=" + name + ", Age=" + age + ", Breed=" + breed + "]";
	    }

}
