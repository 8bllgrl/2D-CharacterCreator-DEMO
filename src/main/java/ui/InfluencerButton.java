package ui;

import entities.EnumGender;
import entities.MiqoCharacter;
import util.AssetLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
        } else if (buttonProperty == EnumInfluencerButtonProperty.RANDOMIZE_NAME ||
                buttonProperty == EnumInfluencerButtonProperty.RANDOMIZE_APPEARANCE ||
                buttonProperty == EnumInfluencerButtonProperty.RANDOMIZE_TRIBE ||
                buttonProperty == EnumInfluencerButtonProperty.RANDOMIZE_VOICE) {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.RANDOMIZER_BUTTON);
        } else if (buttonProperty == EnumInfluencerButtonProperty.PREVIOUS_TRIBE || buttonProperty == EnumInfluencerButtonProperty.PREVIOUS_VOICE) {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.PREVIOUS_ARROW_BUTTON);
        } else if (buttonProperty == EnumInfluencerButtonProperty.NEXT_TRIBE || buttonProperty == EnumInfluencerButtonProperty.NEXT_VOICE) {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.NEXT_ARROW_BUTTON);
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
        int tribeLetter = miqoCharacter.getTribeLetterIndex();
        int voiceNum = miqoCharacter.getVoiceNumber();
        switch (buttonProperty) {
            case AGE_UP:
                int age = miqoCharacter.getAge();
                if (age < 70) {
                    age++;
                    miqoCharacter.setAge(age);
//                    System.out.println("Age increased");
                    this.getMiqoCharacter().getDisplayScreen().getUILoader().update();
                }
                break; // when this is INSIDE of the loop, when the age reaches the end, it makes the age go down! bad.
            case AGE_DOWN:
                age = miqoCharacter.getAge();
                if (age > 1) {
                    age--;
                    miqoCharacter.setAge(age);
//                    System.out.println("Age decreased");
                    this.getMiqoCharacter().getDisplayScreen().getUILoader().update();
                }
                break; // if this break is inside of the loop, then the age will turn female. Bad!
            case CHANGE_FEMALE:
                miqoCharacter.setGender(EnumGender.FEMALE);
                miqoCharacter.setFirstName(AssetLoader.FEMALE_FIRSTNAMES[0]);
                miqoCharacter.setLastName("");
                this.getMiqoCharacter().getDisplayScreen().getUILoader().update();
                break;
            case CHANGE_MALE:
                miqoCharacter.setGender(EnumGender.MALE);
                miqoCharacter.setFirstName(AssetLoader.MALE_FIRSTNAMES[0]);
                miqoCharacter.setLastName("Nunh");
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
                miqoCharacter.setAppearanceIndex(downIndex);
                break;
            case RANDOMIZE_NAME:
                EnumGender gender = this.getMiqoCharacter().getGender();
                int min = 0;
                int max;
                int randomNum;
                if (gender == EnumGender.FEMALE) {
                    max = AssetLoader.FEMALE_FIRSTNAMES.length - 1;
                    randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

                    miqoCharacter.setFirstName(AssetLoader.FEMALE_FIRSTNAMES[randomNum]);

//                    System.out.println("E");
                } else if (gender == EnumGender.MALE) {
                    max = AssetLoader.MALE_FIRSTNAMES.length - 1;
                    randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

                    miqoCharacter.setFirstName(AssetLoader.MALE_FIRSTNAMES[randomNum]);
//                    System.out.println("E");
                }
                break;
            case NEXT_TRIBE:
                tribeLetter++;
                if (tribeLetter >= AssetLoader.TRIBE_LETTERS.length) {
                    tribeLetter = AssetLoader.TRIBE_LETTERS.length;
                }
                miqoCharacter.setTribeLetterIndex(tribeLetter);
                miqoCharacter.setTribeLetter(AssetLoader.TRIBE_LETTERS[tribeLetter]);
                break;
            case PREVIOUS_TRIBE:
                tribeLetter--;
                if (tribeLetter <= 0) {
                    tribeLetter = 0;
                }
                miqoCharacter.setTribeLetterIndex(tribeLetter);
                miqoCharacter.setTribeLetter(AssetLoader.TRIBE_LETTERS[tribeLetter]);
                break;
            case RANDOMIZE_TRIBE:
                min = 0;
                max = AssetLoader.TRIBE_LETTERS.length - 1;
                tribeLetter = ThreadLocalRandom.current().nextInt(min, max + 1);
                miqoCharacter.setTribeLetterIndex(tribeLetter);
                miqoCharacter.setTribeLetter(AssetLoader.TRIBE_LETTERS[tribeLetter]);
                break;
            case NEXT_VOICE:
                if (miqoCharacter.getGender() == EnumGender.MALE){

                }
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
