package main;

import gamescreens.CharacterDisplayScreen;

import java.awt.*;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePainter gamePainter;
    private Thread gameThread;

    private int FPS = 60;
    private int TICKSPEED = 200;

    public static int GAME_WIDTH = 10;
    public static int GAME_HEIGHT = 10;

    private CharacterDisplayScreen displayScreen;

    public Game() {
        initClasses();

        gamePainter = new GamePainter(this);
        gameWindow = new GameWindow(gamePainter);
        gamePainter.setFocusable(true);
        gamePainter.requestFocus();

        startGameLoop();
    }

    private void initClasses() {
        displayScreen = new CharacterDisplayScreen(this);
    }
    public void render(Graphics2D g2) {
        displayScreen.draw(g2);
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / TICKSPEED;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaUpdate = 0;
        double deltaFrame = 0;

        while (gameThread != null) {
            long currentTime = System.nanoTime();

            deltaUpdate += (currentTime - previousTime) / timePerUpdate;
            deltaFrame += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaUpdate >= 1) {
                displayScreen.update();
                updates++;
                deltaUpdate--;
            }

            if (deltaFrame >= 1) {
                gamePainter.repaint();
                frames++;
                deltaFrame--;

            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
//                System.out.println("FPS: " + frames + " |  UPS:" + updates);
                setFPS(frames);

                updates = 0;
                frames = 0;
            }
        }

    }
    private void startGameLoop () {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public CharacterDisplayScreen getDisplayScreen() {
        return displayScreen;
    }

    public void setFPS (int FPS){
        this.FPS = FPS;
    }
    ////////////


}
