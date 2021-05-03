package viewer;

import gui.GUI;
import model.Position;
import model.arena.Arena;
import model.elements.Element;

import java.io.IOException;
import java.util.List;

public class ArenaViewer {
    private final GUI gui;

    public ArenaViewer(GUI gui) {
        this.gui = gui;
    }

    public void draw(Arena arena) throws IOException {
        gui.clear();

        drawElements(arena.getWalls(), new WallViewer());
        drawElements(arena.getMonsters(), new MonsterViewer());
        drawElement(arena.getHero(), new HeroViewer());

        gui.drawText(new Position(0, 0), "Energy: " + arena.getHero().getEnergy());

        gui.refresh();
    }

    private void drawElements(List<? extends Element> elements, ElementViewer viewer) {
        for (Element element : elements)
            drawElement(element, viewer);
    }

    private void drawElement(Element element, ElementViewer viewer) {
        viewer.drawElement(element, gui, element.getDirection());
    }

    public void close() throws IOException {
        gui.close();
    }

    public GUI.ACTION getNextAction() throws IOException {
        return gui.getNextAction();
    }
}