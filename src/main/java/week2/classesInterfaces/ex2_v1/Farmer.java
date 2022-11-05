package week2.classesInterfaces.ex2_v1;

import week2.classesInterfaces.ex2_v1.Animal.Animal;

public class Farmer {
    Farm farm;

    public Farmer(Farm farm) {
        this.farm = farm;
    }

    public String makeAnimalMove(Animal animal){
        System.out.println(animal.toString()+"  Move!!!!");
        return "Move";
    }

    public Animal requestAnimal(int id){
        return farm.provideAnimal(id);
    }

    public void insertNewAnimal(Animal animal){
        farm.add(animal);
    }

}
