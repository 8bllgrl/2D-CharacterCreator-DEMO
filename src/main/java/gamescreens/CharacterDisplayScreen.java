package gamescreens;

import entities.MiqoCharacter;
import main.Game;
import ui.UILoader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class CharacterDisplayScreen extends GameScreen implements GameScreenMethods {

    private MiqoCharacter character;
    private UILoader uiLoader;


    public CharacterDisplayScreen(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        uiLoader = new UILoader(this);
        character = new MiqoCharacter(215, 90, 315, 415,this);
    }

    @Override
    public void update() {

        character.update();

    }

    @Override
    public void draw(Graphics2D g2) {
        uiLoader.drawUIImproved(g2);
        uiLoader.drawUIText(g2);
        character.render(g2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
