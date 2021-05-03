package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import model.Position;
import viewer.ElementViewer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final TerminalScreen screen;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        screen = createScreen(terminal);
    }

    private TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.readInput();

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'w') return ACTION.W;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'a') return ACTION.A;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 's') return ACTION.S;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'd') return ACTION.D;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        return ACTION.NONE;
    }

    @Override
    public void drawHero(Position position, ElementViewer.DIRECTION direction) {

        switch(direction) {
            case RIGHT:
                drawCharacter(position.getX(), position.getY(), 'O');
                drawCharacter(position.getX()+1, position.getY(), '-');
                break;
            case LEFT:
                drawCharacter(position.getX(), position.getY(), 'O');
                drawCharacter(position.getX()-1, position.getY(), '-');
                break;
            case UP:
                drawCharacter(position.getX(), position.getY(), 'O');
                drawCharacter(position.getX(), position.getY()-1, '|');
                break;
            case DOWN:
                drawCharacter(position.getX(), position.getY(), 'O');
                drawCharacter(position.getX(), position.getY()+1, '|');
                break;
        }
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '#');
    }

    @Override
    public void drawMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), '@');
    }

    @Override
    public void drawText(Position position, String text) {
        TextGraphics tg = screen.newTextGraphics();
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c) {
        screen.setCharacter(x, y + 1, TextCharacter.fromCharacter(c)[0]);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}