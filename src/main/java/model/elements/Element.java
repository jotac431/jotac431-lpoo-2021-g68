package model.elements;

import model.Position;
import viewer.ElementViewer;

public class Element {
    private Position position;
    private ElementViewer.DIRECTION direction;

    public Element(int x, int y, ElementViewer.DIRECTION direction) {

        this.position = new Position(x, y);
        this.direction = direction;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ElementViewer.DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(ElementViewer.DIRECTION direction) {
        this.direction = direction;
    }
}