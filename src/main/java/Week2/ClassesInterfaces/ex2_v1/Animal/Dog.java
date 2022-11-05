package Week2.ClassesInterfaces.ex2_v1.Animal;

public class Dog extends Animal{

    public Dog(Gender gender, int id, double weight) {
        super(gender, id, weight);
    }


    public void bark(){
        System.out.println("Bark!!!");
    }
}
