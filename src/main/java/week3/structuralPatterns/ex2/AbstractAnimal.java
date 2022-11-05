package week3.structuralPatterns.ex2;
import static week3.structuralPatterns.ex2.Generator.*;

public class AbstractAnimal implements Animal {
    public final Gender gender;
    protected final String id;
    protected final double weight;

    public AbstractAnimal(Gender gender, String id, double weight) {
        this.gender = gender;
        this.id = id;
        this.weight = weight;
    }
    public AbstractAnimal() {
        this.gender = Random_Gender();
        this.id =  random_id();
        this.weight = random_weight();
    }

    @Override
    public AbstractAnimal mate(AbstractAnimal partner) {
        if(this.gender != partner.gender) {
            return new AbstractAnimal();
        }
        else {
            System.out.println("not mateable!");
            return null;
        }
    }

    @Override
    public void move() {
        System.out.println("AbstractAnimal-MOVE!");
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "gender=" + gender +
                ", id='" + id + '\'' +
                ", weight=" + weight +
                '}';
    }
}
