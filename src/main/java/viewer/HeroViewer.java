package viewer;

import gui.GUI;
import model.elements.Element;

public class HeroViewer implements ElementViewer {
    @Override
    public void drawElement(Element hero, GUI gui, DIRECTION dir) {
        gui.drawHero(hero.getPosition(), dir);
    }
}
