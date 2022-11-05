package week3.structuralPatterns.ex2.farm;

import week3.structuralPatterns.ex2.AbstractAnimal;
import week3.structuralPatterns.ex2.Generator;
import week3.structuralPatterns.ex2.animalTypes.AnimalType;
import week3.structuralPatterns.ex2.animalTypes.Bird;
import week3.structuralPatterns.ex2.animalTypes.Dog;
import week3.structuralPatterns.ex2.animalTypes.Cat;

import java.util.ArrayList;
import java.util.List;


public class Farm {
    List<AbstractAnimal> animals = new ArrayList<>();

    public Farm(List<AbstractAnimal> animals) {
        this.animals = animals;
    }
    public Farm() {
        for (int i=0;i<10;i++){
            animals.add(Generator.randomAnimal());
        }
    }

    private void acquire(AnimalType type) { //generating new animal
        AbstractAnimal animal;

        switch (type){
            case BIRD:
                animal= new Bird();
                break;
            case CAT:
                animal=new Cat();
                break;
            case DOG:
                animal=new Dog();
                break;
            default:
                throw  new IllegalArgumentException("IllegalArgument");
        }
        animals.add(animal);
    }

    public void mateByFarm(AbstractAnimal animal1, AbstractAnimal animal2){
        AbstractAnimal child = animal1.mate(animal2);
        if(child!=null){
            animals.add(child);
        }
    }

    public AbstractAnimal provideAnimal(AnimalType type) {//return and remove the first animal if exist ,else-null

        for (AbstractAnimal animal : animals) {
            if (animal.getClass().toString().toLowerCase().contains(type.toString().toLowerCase())) {
                animals.remove(animal);
                return animal;
            }
        }
        return null;
    }

    public void insertNewAnimalToFarm(AbstractAnimal animal){
        animals.add(animal);
    }


    @Override
    public String toString() {

        return "Farm{" +
                "animals=" + animals +
                '}';
    }
}
