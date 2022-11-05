package week2.classesInterfaces.Ex1;

public class Circle implements Figure{
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {

        return Math.PI * (radius * radius);
    }
    @Override
    public void print() {
        System.out.println("area: "+ this.area());
    }
}
