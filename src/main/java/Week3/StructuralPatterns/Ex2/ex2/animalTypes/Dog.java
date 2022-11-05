package Week3.StructuralPatterns.Ex2.ex2.animalTypes;

import Week3.StructuralPatterns.Ex2.ex2.AbstractAnimal;

public class Dog extends AbstractAnimal {

    public Dog(Gender gender, String id, double weight) {
        super(gender, id, weight);
    }
    public Dog(){
      super();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "gender=" + gender +
                ", id='" + id + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public void move() {
        System.out.println("Dog-MOVE!");
    }

    @Override
    public AbstractAnimal mate(AbstractAnimal partner) {
        if(this.gender != partner.gender) {
            return new Dog();
        }
        else {
            System.out.println("not mateable!");
            return null;
        }
    }

}
