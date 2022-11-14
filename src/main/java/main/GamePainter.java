package main;

import inputs.MouseInputs;
import util.AssetLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static main.Game.GAME_WIDTH;
import static main.Game.GAME_HEIGHT;

public class GamePainter extends JPanel {

    private MouseInputs mouseInputs;
    private Game game;

    public GamePainter(Game game) {
        mouseInputs = new MouseInputs(this);
        this.game = game;
        setPanelSize();
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
    }

    public void updateGame() {

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        game.render(g2);


        //stays at bottom
        g2.dispose();
    }

    public Game getGame() {
        return game;
    }

}