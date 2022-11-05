package Week3.StructuralPatterns.Ex2.ex2.wodenHorse;

import Week3.StructuralPatterns.Ex2.ex2.AbstractAnimal;

public class WoodenStructureAdapter extends AbstractAnimal {
  WoodenHorse woodenHorse;

    public WoodenStructureAdapter(WoodenHorse woodenHorse) {
        this.woodenHorse = woodenHorse;
    }
    public WoodenStructureAdapter createWoodenStructureAdapter(WoodenHorse woodenHorse) {
        return new WoodenStructureAdapter(woodenHorse);
    }

    @Override
    public AbstractAnimal mate(AbstractAnimal partner) {
        if(!(this instanceof WoodenStructureAdapter))
            throw new IllegalArgumentException("not matchable");

        return createWoodenStructureAdapter(woodenHorse.replicate());
    }

    @Override
    public void move() {
        woodenHorse.roll();
    }

}

