package Week3.StructuralPatterns.Ex2.ex2;

public interface Animal {
    public enum Gender {
        MALE,
        FEMALE
    }


    public AbstractAnimal mate(AbstractAnimal partner);
    public void  move();

}
