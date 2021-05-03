package viewer;

import gui.GUI;
import model.elements.Element;

public class MonsterViewer implements ElementViewer {
    @Override
    public void drawElement(Element monster, GUI gui, DIRECTION dir) {
        gui.drawMonster(monster.getPosition());
    }
}