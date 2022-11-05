package week3.structuralPatterns.ex2;

public interface Animal {
    public enum Gender {
        MALE,
        FEMALE
    }


    public AbstractAnimal mate(AbstractAnimal partner);
    public void  move();

}
