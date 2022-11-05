package week3.structuralPatterns.ex2.animalTypes;

import week3.structuralPatterns.ex2.AbstractAnimal;

public class Bird extends AbstractAnimal {

    public Bird(Gender gender, String id, double weight) {
        super(gender, id, weight);
    }

    public Bird() {
        super();
    }

    @Override
    public String toString() {
        return "Bird{" +
                "gender=" + gender +
                ", id='" + id + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public void move() {
        System.out.println("Bird-MOVE!");
    }

    @Override
    public AbstractAnimal mate(AbstractAnimal partner) {
        if(this.gender != partner.gender) {
            return new Bird();
        }
        else {
            System.out.println("not mateable!");
            return null;
        }
    }

}
