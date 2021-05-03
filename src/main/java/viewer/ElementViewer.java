package viewer;

import gui.GUI;
import model.elements.Element;

public interface ElementViewer {
    void drawElement(Element element, GUI gui, DIRECTION dir);

    enum DIRECTION {UP, RIGHT, DOWN, LEFT}
}