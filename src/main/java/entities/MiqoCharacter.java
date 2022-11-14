package entities;

import gamescreens.CharacterDisplayScreen;
import ui.EnumInfluencerButtonProperty;
import ui.InfluencerButton;
import util.AssetLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MiqoCharacter extends Entity {

    private BufferedImage[][] animation;
    private BufferedImage[] tempAnimationWalking;
    private int appearanceIndex = 1;
    private static final int animationSpeed = 60;

    private InfluencerButton[] arrowButtons;

    private EnumGender gender;
    private String tribeLetter;
    private String firstName;
    private String lastName;
    private EnumCharacterAction action = EnumCharacterAction.WALK;


    //util:
    private Random randomizer;
    private CharacterDisplayScreen displayScreen;

    public MiqoCharacter(int x, int y, int width, int height, CharacterDisplayScreen displayScreen) {
        super(x, y, width, height);
        this.displayScreen = displayScreen;
        this.gender = EnumGender.MALE;
        this.firstName = "datih";
        this.lastName = "Nunh";
        this.tribeLetter = "H'";

        loadAnimation();
        loadButtons();

        //TODO
//        loadAnimationsArray();
    }

    public void updateAnimationTickTwo() {

        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            //this resets it back to the far left side of the animation if it reaches the end of the array!
            if (animationIndex >= tempAnimationWalking.length) {
                animationIndex = 0;
            }
        }

    }

    public void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            //this resets it back to the far left side of the animation if it reaches the end of the array!
            if (animationIndex >= miqoGetSpriteAmount()) {
                animationIndex = 0;
            }
        }
    }

    public void render(Graphics2D g2) {
//        g2.drawImage(tempAnimationWalking[animationIndex], x, y, width, height, null);
        g2.drawImage(animation[0][animationIndex], x, y, width, height, null);

        for (InfluencerButton ib : arrowButtons) {
            ib.draw(g2);
        }
    }

    public void update() {
//        System.out.println("update");
        updateAnimationTick();
//        updateAnimationTickTwo();
    }

    public void drawInfluencerUI(Graphics2D g2) {

    }

    //TODO
    private void loadAnimationsArray() {
        BufferedImage img = AssetLoader.GetSpriteAtlas(AssetLoader.CHARACTER_SPRITESHEET);
        tempAnimationWalking = new BufferedImage[7];
        for (int i = 0; i < tempAnimationWalking.length; i++) {
            tempAnimationWalking[i] = img.getSubimage(i * 400, 0 * 500, 400, 500);
        }
    }

    private void loadAnimation() {
        BufferedImage img = AssetLoader.GetSpriteAtlas(AssetLoader.CHARACTER_SPRITESHEET);
        animation = new BufferedImage[3][8];
        for (int j = 0; j < animation.length; j++) {
            for (int i = 0; i < animation[j].length; i++) {
                animation[j][i] = img.getSubimage(i * 400, j * 500, 400, 500);
            }
        }
    }
    private void loadButtons() {
        arrowButtons = new InfluencerButton[2];
        arrowButtons[0] = new InfluencerButton(155, 420, EnumInfluencerButtonProperty.AGE_UP);
        arrowButtons[1] = new InfluencerButton(30, 420, EnumInfluencerButtonProperty.AGE_DOWN);
    }
    private static int miqoGetSpriteAmount() {
        return 8;
    }



    ////////////////
    public void setRandomFirstName() {
        String[] firstNamesChoices;
        int max;
        int min = 0;
        if (gender == EnumGender.FEMALE) {
            firstNamesChoices = AssetLoader.FEMALE_FIRSTNAMES;
            max = firstNamesChoices.length;
            randomizer = new Random();
//            int randomNum = randomizer.nextInt((min - max) +1)+min;
        }

    }
}
