package Week3.StructuralPatterns.Ex2.ex2.animalTypes;


import java.util.Random;

public enum AnimalType {
    BIRD,
    CAT,
    DOG;

    public static AnimalType randomAnimalType(){
        AnimalType[] animals= AnimalType.values();
        int randIndex = new Random().nextInt(animals.length);
        return animals[randIndex];
    }
}
