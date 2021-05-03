package viewer;

import gui.GUI;
import model.elements.Element;

public class WallViewer implements ElementViewer {
    @Override
    public void drawElement(Element wall, GUI gui, DIRECTION dir) {
        gui.drawWall(wall.getPosition());
    }
}
