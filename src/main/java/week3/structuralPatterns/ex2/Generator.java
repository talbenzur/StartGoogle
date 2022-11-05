package week3.structuralPatterns.ex2;

import week3.structuralPatterns.ex2.animalTypes.AnimalType;
import week3.structuralPatterns.ex2.animalTypes.Bird;
import week3.structuralPatterns.ex2.animalTypes.Cat;
import week3.structuralPatterns.ex2.animalTypes.Dog;
import week3.structuralPatterns.ex2.ex2.animalTypes.*;
import java.util.Random;
import static week3.structuralPatterns.ex2.animalTypes.AnimalType.randomAnimalType;

public class Generator {

    public static Animal.Gender Random_Gender(){
        int randomNum = (int)Math.floor(Math.random()*(2));
           return Animal.Gender.values()[randomNum];
    }

    public static String random_id(){
        int len=9;
        String chars = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static double random_weight(){
        int min = 50;
        int max = 100;
        //Generate random int value from 50 to 100
        return Math.floor(Math.random()*(max-min+1)+min);
    }

    public static String random_name() {
        int len=6;
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static AbstractAnimal randomAnimal(){
        AbstractAnimal animal;

        AnimalType type= randomAnimalType();
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
        return animal;
    }

}
