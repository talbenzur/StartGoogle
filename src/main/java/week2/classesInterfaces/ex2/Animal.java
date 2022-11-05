package week2.classesInterfaces.ex2;

public interface Animal {
    public enum Gender {
        MALE,
        FEMALE
    }


    public AbstractAnimal mate(AbstractAnimal partner);
    public void  move();

}
