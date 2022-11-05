package week3.structuralPatterns.ex2.wodenHorse;

public class WoodenHorse implements WoodenStructures {
    @Override
    public void roll() {
        System.out.println("wooden horse roll");
    }

    @Override
    public WoodenHorse replicate() {

        System.out.println("wooden horse replicate");
        return new WoodenHorse();
    }
}
