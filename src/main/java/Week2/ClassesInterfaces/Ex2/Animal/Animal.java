package Week2.ClassesInterfaces.Ex2.Animal;

public class Animal implements IAnimal {

    private final Gender gender;
    private final int id;
    private double weight;


    public Animal(Gender gender, int id, double weight) {
        this.gender = gender;
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    @Override
    public void move() {
        System.out.println("MOVE!");
    }

    @Override
    public Animal mate() {
        Animal partner = new Animal(OppositeGender(), this.id, this.weight);
        return partner;
    }


    private Gender OppositeGender() {
        if (this.gender == Gender.male)
            return Gender.female;
        return Gender.male;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "gender=" + gender +
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
