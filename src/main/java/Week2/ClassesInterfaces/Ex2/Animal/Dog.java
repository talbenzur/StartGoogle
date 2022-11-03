package Week2.ClassesInterfaces.Ex2.Animal;

public class Dog extends Animal{

    public Dog(Gender gender, int id, double weight) {
        super(gender, id, weight);
    }


    public void bark(){
        System.out.println("Bark!!!");
    }
}
