package com.myspringboot.test.TAnimalShelter;

import com.myspringboot.test.TAnimalShelter.entity.Animal;
import com.myspringboot.test.TAnimalShelter.entity.Dog;

import java.util.ArrayList;
import java.util.List;

public class AniTest {
    public static void main(String[] args) {
        // 使用
        List<Dog> dogs = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();

        AnimalShelter shelter = new AnimalShelter();
        shelter.printAnimals(dogs);    // 可以，Dog extends Animal
        shelter.addAnimal(animals, new Dog()); // 可以，Animal super Dog
    }
}
