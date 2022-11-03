package Week2.ClassesInterfaces.Ex1;

public class Rectangle implements Figure{
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public void print() {
        System.out.println("area: "+ this.area());
    }
}
