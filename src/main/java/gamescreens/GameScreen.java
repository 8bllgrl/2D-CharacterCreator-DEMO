package gamescreens;

import main.Game;
import ui.InfluencerButton;

import java.awt.event.MouseEvent;

public class
GameScreen {
    protected Game game;

    public GameScreen(Game game){
        this.game = game;
    }

    public boolean isIn(MouseEvent e, InfluencerButton arrowButton){
//        return arrowButton.getBounds().contains(e.getX(), e.getY());
        return true;
    }
    public Game getGame() {
        return game;
    }
}
