package model.elements;

import viewer.ElementViewer;

public class Hero extends Element {
    private int energy;

    public Hero(int x, int y, ElementViewer.DIRECTION direction) {
        super(x, y, direction);
        this.energy = 10;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public int getEnergy() {
        return energy;
    }
}