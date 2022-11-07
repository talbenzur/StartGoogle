package week3.structuralPatterns.ex2.wodenHorse;

import week3.structuralPatterns.ex2.AbstractAnimal;

public class WoodenStructureAdapter extends AbstractAnimal {

  WoodenStructures woodenStructures;

    public WoodenStructureAdapter( WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }


    public WoodenStructureAdapter createWoodenStructureAdapter(WoodenStructures woodenStructures) {
        return new WoodenStructureAdapter(woodenStructures);
    }

    @Override
    public AbstractAnimal mate(AbstractAnimal partner) {
        if(!(this instanceof WoodenStructureAdapter))
            throw new IllegalArgumentException("not matchable");

        return createWoodenStructureAdapter(woodenStructures.replicate());
    }

    @Override
    public void move() {
        woodenStructures.roll();
    }

}

