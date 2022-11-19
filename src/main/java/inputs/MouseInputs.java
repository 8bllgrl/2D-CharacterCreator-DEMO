package inputs;

import gamescreens.GameScreen;
import main.GamePainter;
import util.EnumGameScreen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener{

    private GamePainter gamePainter;

    public MouseInputs(GamePainter gamePainter){
        this.gamePainter = gamePainter;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gamePainter.getGame().getDisplayScreen().mouseClicked(e);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        gamePainter.getGame().getDisplayScreen().mousePressed(e);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gamePainter.getGame().getDisplayScreen().mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gamePainter.getGame().getDisplayScreen().mouseMoved(e);
    }
}
