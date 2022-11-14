package gamescreens;

import entities.MiqoCharacter;
import main.Game;
import ui.InfluencerButton;
import ui.UILoader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class CharacterDisplayScreen extends GameScreen implements GameScreenMethods {

    private MiqoCharacter character;
    private UILoader uiLoader;
    private InfluencerButton[] influencerButtons;


    public CharacterDisplayScreen(Game game) {
        super(game);
        initClasses();
    }

    private void initClasses() {
        character = new MiqoCharacter(215, 90, 315, 415, this);
        uiLoader = new UILoader(this);
        influencerButtons = character.getArrowButtons();
    }

    @Override
    public void update() {

        character.update();
        uiLoader.update();

    }

    @Override
    public void draw(Graphics2D g2) {
        uiLoader.drawUIImproved(g2);
        uiLoader.drawUIText(g2);
        uiLoader.drawUIValueText(g2);
        character.render(g2);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (InfluencerButton ib : influencerButtons) {
            if (isIn(e, ib)) {
                ib.setMousePressed(true);
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (InfluencerButton ib : influencerButtons) {
            if (isIn(e, ib)) {
                if (ib.isMousePressed())
                    ib.applyButtonFunction();
                break;
            }
        }

        resetButtons();

    }
    private void resetButtons() {
        for (InfluencerButton ib : influencerButtons)
            ib.resetBools();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        for (InfluencerButton ib : influencerButtons) {
            ib.setMouseOver(false);
        }
        for (InfluencerButton ib : influencerButtons) {
            if (isIn(e,ib)){
                ib.setMouseOver(true);
                break;
            }
        }


    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public MiqoCharacter getCharacter() {
        return character;
    }
}
