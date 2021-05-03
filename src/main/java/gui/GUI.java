package gui;

import model.Position;
import viewer.ElementViewer;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawHero(Position position, ElementViewer.DIRECTION direction);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawText(Position position, String text);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, W, A, S, D}
}