package Week2.ClassesInterfaces.ex2_v1;

import Week2.ClassesInterfaces.ex2_v1.Animal.*;

import java.util.ArrayList;
import java.util.List;

public class Farm extends Generator {
    List<Animal> animals = new ArrayList<>();

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    public Farm(int count) {
        createRandomAnimals(count);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    private void createRandomAnimals(int count) {
        for (int i = 0; i < count; i++) {
            acquire();
        }
    }

    private void acquire() { //generating new animal
        Animal animal = GenerateAnimal();
        animals.add(animal);
    }

    public void createNewAnimal(Animal animal) { //create new Animal by the mate()
        Animal newAnimal = animal.mate();
        animals.add(newAnimal);
    }

    public Animal provideAnimal(int id) {//return the animal if exist ,else-null
        return isAnimalExist(id);
    }

    private Animal isAnimalExist(int id) {
        for (Animal animal : animals) {
            if (animal.getId() == id)
                return animal;
        }
        return null;
    }


    public void printAnimals() {
        System.out.println("the animals are: \n");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println("\n");
    }

    public void add(Animal e) {
        animals.add(e);
    }
}
