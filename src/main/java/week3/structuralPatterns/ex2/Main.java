package week3.structuralPatterns.ex2;


import week3.structuralPatterns.ex2.animalTypes.AnimalType;
import week3.structuralPatterns.ex2.farm.Farm;
import week3.structuralPatterns.ex2.farm.Farmer;
import week3.structuralPatterns.ex2.wodenHorse.WoodenHorse;
import week3.structuralPatterns.ex2.wodenHorse.WoodenStructureAdapter;


public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm();//create farm with 10 random animals
        System.out.println(farm.toString());
        Farmer farmer = new Farmer(farm);

        AbstractAnimal animal1= Generator.randomAnimal();
        AbstractAnimal animal2= Generator.randomAnimal();

        farmer.insertNewAnimal(animal1);
        farmer.insertNewAnimal(animal2);

        System.out.println(farmer.toString());

        farmer.makeAnimalMove(animal1);
        farmer.requestAnimal(AnimalType.DOG);
        System.out.println(farmer.toString());

        WoodenHorse woodenHorse1= new WoodenHorse();
        WoodenHorse woodenHorse2= new WoodenHorse();

        AbstractAnimal woodenAdapter= new WoodenStructureAdapter(woodenHorse1);
        AbstractAnimal woodenAdapter2= new WoodenStructureAdapter(woodenHorse2);

        woodenAdapter.mate(woodenAdapter2);
        woodenAdapter.move();


    }
}
