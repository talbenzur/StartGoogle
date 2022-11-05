package Week2.ClassesInterfaces.ex2.farm;


import Week2.ClassesInterfaces.ex2.AbstractAnimal;
import Week2.ClassesInterfaces.ex2.Animal;
import Week2.ClassesInterfaces.ex2.animalTypes.AnimalType;

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
