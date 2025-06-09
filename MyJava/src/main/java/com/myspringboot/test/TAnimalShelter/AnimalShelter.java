package com.myspringboot.test.TAnimalShelter;

import com.myspringboot.test.TAnimalShelter.entity.Animal;
import com.myspringboot.test.TAnimalShelter.entity.Dog;

import java.util.List;

public class AnimalShelter {
    // 这个方法可以接受任何动物列表
    public void printAnimals(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
    }

    // 这个方法可以向任何动物的父类列表添加动物
    public void addAnimal(List<? super Dog> animals, Dog dog) {
        animals.add(dog); // 安全，因为Dog一定是? super Dog的子类
    }
}
