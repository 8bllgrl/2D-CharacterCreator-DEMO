package ui;

import entities.EnumGender;
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

    public InfluencerButton(int x, int y, int width, int height, EnumInfluencerButtonProperty buttonProperty, MiqoCharacter miqoCharacter) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
        } else if (buttonProperty == EnumInfluencerButtonProperty.AGE_DOWN) {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.PREVIOUS_ARROW_BUTTON);
        } else if (buttonProperty == EnumInfluencerButtonProperty.CHANGE_MALE) {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.MALE_BUTTON);
        } else if (buttonProperty == EnumInfluencerButtonProperty.CHANGE_FEMALE) {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.FEMALE_BUTTON);
        } else if (buttonProperty == EnumInfluencerButtonProperty.APPEARANCE_NEXT) {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.NEXT_ARROW_BUTTON);
        } else if (buttonProperty == EnumInfluencerButtonProperty.APPEARANCE_PREV) {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.PREVIOUS_ARROW_BUTTON);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(appearance, x, y, width, height, null);
    }

    public void update() {

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
                    this.getMiqoCharacter().getDisplayScreen().getUILoader().update();
                }
                break; // when this is INSIDE of the loop, when the age reaches the end, it makes the age go down! bad.
            case AGE_DOWN:
                age = miqoCharacter.getAge();
                if (age > 1) {
                    age--;
                    miqoCharacter.setAge(age);
                    System.out.println("Age decreased");
                    this.getMiqoCharacter().getDisplayScreen().getUILoader().update();
                }
                break; // if this break is inside of the loop, then the age will turn female. Bad!
            case CHANGE_FEMALE:
                miqoCharacter.setGender(EnumGender.FEMALE);
                this.getMiqoCharacter().getDisplayScreen().getUILoader().update();
                break;
            case CHANGE_MALE:
                miqoCharacter.setGender(EnumGender.MALE);
                this.getMiqoCharacter().getDisplayScreen().getUILoader().update();
                break;
            case APPEARANCE_NEXT:

                int upIndex = miqoCharacter.getAppearanceIndex() + 1;

                if (upIndex >= AssetLoader.maximumAnimationIndex) {
                    upIndex = AssetLoader.maximumAnimationIndex;
                }

                miqoCharacter.setAppearanceIndex(upIndex);
                this.getMiqoCharacter().getDisplayScreen().getUILoader().update();
                break;
            case APPEARANCE_PREV:
                int downIndex = miqoCharacter.getAppearanceIndex() - 1;
                if (downIndex < 0) {
                    downIndex = 0;
                }
                System.out.println(downIndex);
                miqoCharacter.setAppearanceIndex(downIndex);
                this.getMiqoCharacter().getDisplayScreen().getUILoader().update();
                break;
        }
    }

    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
    }

    public MiqoCharacter getMiqoCharacter() {
        return miqoCharacter;
    }
}
