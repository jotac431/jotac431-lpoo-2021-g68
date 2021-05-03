package model.arena;

import model.elements.Hero;
import model.elements.Monster;
import model.elements.Wall;
import viewer.ElementViewer;

import java.util.ArrayList;
import java.util.List;

public class ArenaBuilder {

    private final int width;
    private int height;

    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setHero(createHero());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());

        return arena;
    }

    public ArenaBuilder(int width, int height) {

        this.width = width;
        this.height = height;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0, ElementViewer.DIRECTION.RIGHT));
            walls.add(new Wall(x, height - 1, ElementViewer.DIRECTION.RIGHT));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y, ElementViewer.DIRECTION.DOWN));
            walls.add(new Wall(width - 1, y, ElementViewer.DIRECTION.DOWN));
        }

        return walls;
    }

    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(10, 10, ElementViewer.DIRECTION.DOWN));
        monsters.add(new Monster(30, 10, ElementViewer.DIRECTION.DOWN));
        monsters.add(new Monster(10, 15, ElementViewer.DIRECTION.DOWN));
        return monsters;
    }

    protected Hero createHero() {
        return new Hero(width / 2, height / 2, ElementViewer.DIRECTION.RIGHT);
    }
}