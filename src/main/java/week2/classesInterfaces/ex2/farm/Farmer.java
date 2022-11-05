package week2.classesInterfaces.ex2.farm;


import week2.classesInterfaces.ex2.AbstractAnimal;
import week2.classesInterfaces.ex2.Animal;
import week2.classesInterfaces.ex2.animalTypes.AnimalType;

public class Farmer {
    Farm farm;

    public Farmer(Farm farm) {
        this.farm = farm;
    }

    public String makeAnimalMove(Animal animal){
        System.out.println(animal.toString()+"  Move!!!!");
        return "Move";
    }

    public Animal requestAnimal(AnimalType type){
        return farm.provideAnimal(type);
    }

    public void insertNewAnimal(AbstractAnimal animal){
        farm.insertNewAnimalToFarm(animal);
    }


    @Override
    public String toString() {
        return "Farmer{" +
                "farm=" + farm +
                '}';
    }
}
