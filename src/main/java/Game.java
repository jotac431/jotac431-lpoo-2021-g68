import controller.ArenaController;
import gui.LanternaGUI;
import model.arena.Arena;
import model.arena.ArenaBuilder;
import viewer.ArenaViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static void main(String[] args) throws FontFormatException, IOException, URISyntaxException {
        createGame(40, 20);
    }

    private static void createGame(int width, int height) throws FontFormatException, IOException, URISyntaxException {
        LanternaGUI gui = new LanternaGUI(width, height);

        Arena arena = new ArenaBuilder(width, height).createArena();
        ArenaViewer viewer = new ArenaViewer(gui);
        ArenaController controller = new ArenaController(arena, viewer);

        controller.start();
    }
}
