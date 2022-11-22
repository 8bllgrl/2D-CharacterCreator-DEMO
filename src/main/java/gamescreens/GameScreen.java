package gamescreens;

import main.Game;
import ui.InfluencerButton;

import java.awt.*;
import java.awt.event.MouseEvent;

public class
GameScreen {
    protected Game game;

    public GameScreen(Game game){
        this.game = game;
    }

    public boolean isIn(MouseEvent e, InfluencerButton influencerButton){
        return influencerButton.getBounds().contains(e.getX(),e.getY());
    }
    public boolean isIn(MouseEvent e, Rectangle influencerButton){
        return influencerButton.getBounds().contains(e.getX(),e.getY());
    }

    public Game getGame() {
        return game;
    }
}
