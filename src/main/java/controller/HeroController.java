package controller;

import gui.GUI;
import model.Position;
import model.arena.Arena;
import viewer.ElementViewer;

public class HeroController {
    private final Arena arena;

    public HeroController(Arena arena) {
        this.arena = arena;
    }

    public void moveHeroLeft() {
        moveHero(arena.getHero().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(arena.getHero().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(arena.getHero().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(arena.getHero().getPosition().getDown());
    }

    public void dirSwordUp() { arena.getHero().setDirection(ElementViewer.DIRECTION.UP); }

    public void dirSwordLeft() {
        arena.getHero().setDirection(ElementViewer.DIRECTION.LEFT);
    }

    public void dirSwordRight() {
        arena.getHero().setDirection(ElementViewer.DIRECTION.RIGHT);
    }

    public void dirSwordDown() {
        arena.getHero().setDirection(ElementViewer.DIRECTION.DOWN);
    }

    private void moveHero(Position position) {
        if (arena.isEmpty(position)) {
            arena.getHero().setPosition(position);
            if (arena.isMonster(position)) arena.getHero().decreaseEnergy();
        }
    }

    public void doAction(GUI.ACTION action) {
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
        if (action == GUI.ACTION.W) dirSwordUp();
        if (action == GUI.ACTION.A) dirSwordLeft();
        if (action == GUI.ACTION.S) dirSwordDown();
        if (action == GUI.ACTION.D) dirSwordRight();
    }
}
