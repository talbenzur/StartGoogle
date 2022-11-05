package week2.classesInterfaces.ex2_v1;

import week2.classesInterfaces.ex2_v1.Animal.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm(3);//create farm with 3 animals
        farm.printAnimals();
        Farmer farmer = new Farmer(farm);


        //Create 3 different types of Animal in the farm.
        Animal lion = new Lion(Gender.male, 12345, 80.4);
        farmer.insertNewAnimal(lion);
        Animal cat = new Cat(Gender.female, 23456, 6.9);
        farmer.insertNewAnimal(cat);
        Animal dog = new Dog(Gender.male, 34567, 13.2);
        farmer.insertNewAnimal(dog);

        farm.printAnimals();

        List<Animal> animals = farm.getAnimals();
        Animal animal = animals.get(1);
        Animal requestedAnimal = farmer.requestAnimal(animal.getId());
        System.out.println("requestedAnimal:" + requestedAnimal.toString());//print specific animal


        farmer.makeAnimalMove(animal);//move animal


    }
}
