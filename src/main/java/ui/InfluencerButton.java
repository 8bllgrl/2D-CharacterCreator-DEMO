package ui;

import entities.MiqoCharacter;
import util.AssetLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InfluencerButton {

    private int width;
    private int height;
    private int x;
    private int y;
    private EnumInfluencerButtonProperty buttonProperty;
    private boolean mouseOver, mousePressed;
    private BufferedImage appearance;
    private Rectangle bounds;
    private MiqoCharacter miqoCharacter;

    public InfluencerButton(int x, int y, EnumInfluencerButtonProperty buttonProperty, MiqoCharacter miqoCharacter) {
        this.x = x;
        this.y = y;
        this.width = 35;
        this.height = 35;
        this.buttonProperty = buttonProperty;
        this.miqoCharacter = miqoCharacter;
        loadAppearance();
        initializeBounds();
    }

    private void initializeBounds() {
        bounds = new Rectangle(x, y, width, height);
    }

    private void loadAppearance() {
        if (buttonProperty == EnumInfluencerButtonProperty.AGE_UP) {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.NEXT_ARROW_BUTTON);
        } else {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.PREVIOUS_ARROW_BUTTON);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(appearance, x, y, width, height, null);
    }

    public void update(){

    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }


    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void applyButtonFunction() {
        switch (buttonProperty) {
            case AGE_UP:
                int age = miqoCharacter.getAge();
                if (age < 70) {
                    age++;
                    miqoCharacter.setAge(age);
                    System.out.println("Age increased");
                    break;
                }
            case AGE_DOWN:
                age = miqoCharacter.getAge();
                if (age > 1) {
                    age--;
                    miqoCharacter.setAge(age);
                    System.out.println("Age decreased");
                    break;
                }
        }
    }

    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
    }

}
