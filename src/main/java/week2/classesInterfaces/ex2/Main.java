package week2.classesInterfaces.ex2;


import week2.classesInterfaces.ex2.animalTypes.AnimalType;
import week2.classesInterfaces.ex2.farm.Farm;
import week2.classesInterfaces.ex2.farm.Farmer;

import static week2.classesInterfaces.ex2.Generator.randomAnimal;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();//create farm with 10 random animals
        System.out.println(farm.toString());
        Farmer farmer = new Farmer(farm);

        AbstractAnimal animal1= randomAnimal();
        AbstractAnimal animal2= randomAnimal();

        farmer.insertNewAnimal(animal1);
        farmer.insertNewAnimal(animal2);

        System.out.println(farmer.toString());

        farmer.makeAnimalMove(animal1);
        farmer.requestAnimal(AnimalType.DOG);
        System.out.println(farmer.toString());

    }
}
