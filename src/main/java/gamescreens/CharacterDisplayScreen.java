package gamescreens;

import entities.MiqoCharacter;
import main.Game;
import ui.InfluencerButton;
import ui.UILoader;
import util.ConstantsMiqo;
import util.SoundsLoader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class CharacterDisplayScreen extends GameScreen implements GameScreenMethods {

    private MiqoCharacter character;
    private UILoader uiLoader;
    private InfluencerButton[] influencerButtons;
    private Rectangle charbounds;

    //SOUNDS
    SoundsLoader sound = new SoundsLoader();


    public CharacterDisplayScreen(Game game) {
        super(game);
        initClasses();
        createDisplayBoxBounds();
    }

    private void initClasses() {
//        character = new MiqoCharacter(215, 85, 315, 415, this);
        character = new MiqoCharacter(
                ConstantsMiqo.ADULT_X,
                ConstantsMiqo.ADULT_Y,
                ConstantsMiqo.ADULT_W,
                ConstantsMiqo.ADULT_H,
                this);
        uiLoader = new UILoader(this);
        influencerButtons = character.getArrowButtons();
    }

    private void createDisplayBoxBounds(){
        charbounds = new Rectangle(283,116,157,360);
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
//        g2.setColor(new Color(103, 171, 47, 115));
//        g2.fillRect(charbounds.x,charbounds.y,charbounds.width,charbounds.height);
    }

    private void playAudio(int i){
        sound.setFile(i);
        sound.play();
    }
    private void stopAudio(int i){
        sound.stop();
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

        if (isIn(e,charbounds)){
            System.out.println("Yo.");
            playAudio(character.getVoiceNumber());
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (InfluencerButton ib : influencerButtons) {
            if (isIn(e, ib)) {
                if (ib.isMousePressed()){
                    ib.applyButtonFunction();
                }
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
            if (isIn(e, ib)) {
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

    public UILoader getUILoader() {
        return uiLoader;
    }

}
