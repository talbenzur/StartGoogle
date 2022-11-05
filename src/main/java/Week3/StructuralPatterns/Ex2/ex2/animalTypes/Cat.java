package Week3.StructuralPatterns.Ex2.ex2.animalTypes;

import Week3.StructuralPatterns.Ex2.ex2.AbstractAnimal;

public class Cat extends AbstractAnimal {
    public Cat(Gender gender, String id, double weight) {
        super(gender, id, weight);
    }

    public Cat() {
        super();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "gender=" + gender +
                ", id='" + id + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public void move() {
        System.out.println("Cat-MOVE!");
    }

    @Override
    public AbstractAnimal mate(AbstractAnimal partner) {
        if(this.gender != partner.gender) {
            return new Cat();
        }
        else {
            System.out.println("not mateable!");
            return null;
        }
    }

}
