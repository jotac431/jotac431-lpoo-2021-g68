package controller;

import model.Position;
import model.arena.Arena;
import model.elements.Monster;

public class MonsterController {
    private final Arena arena;

    public MonsterController(Arena arena) {
        this.arena = arena;
    }

    public void colision(){
        for (Monster monster : arena.getMonsters()) {
            switch (arena.getHero().getDirection()){
                case UP:
                    if ((arena.getHero().getPosition().getX() == monster.getPosition().getX()) && (arena.getHero().getPosition().getY() - 1 == monster
                    .getPosition().getY())) arena.getMonsters().remove(monster);
                case DOWN:
                    if ((arena.getHero().getPosition().getX() == monster.getPosition().getX()) && (arena.getHero().getPosition().getY() + 1 == monster
                            .getPosition().getY())) arena.getMonsters().remove(monster);
                case RIGHT:
                    if ((arena.getHero().getPosition().getX() + 1 == monster.getPosition().getX()) && (arena.getHero().getPosition().getY() == monster
                            .getPosition().getY())) arena.getMonsters().remove(monster);
                case LEFT:
                    if ((arena.getHero().getPosition().getX() - 1 == monster.getPosition().getX()) && (arena.getHero().getPosition().getY() == monster
                            .getPosition().getY())) arena.getMonsters().remove(monster);
            }
        }
    }

    public void moveMonsters() {
        for (Monster monster : arena.getMonsters())
            moveMonster(monster, monster.getPosition().getRandomNeighbour());
    }

    private void moveMonster(Monster monster, Position position) {
        if (arena.isEmpty(position)) {
            monster.setPosition(position);
            if (arena.getHero().getPosition().equals(position))
                arena.getHero().decreaseEnergy();
        }
    }
}
