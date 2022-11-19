package entities;

import gamescreens.CharacterDisplayScreen;
import ui.EnumInfluencerButtonProperty;
import ui.InfluencerButton;
import util.AssetLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MiqoCharacter extends Entity {

    private BufferedImage[][] animationFemale;
    private BufferedImage[][] animationMale;

    private BufferedImage[] tempAnimationWalking;
    private int appearanceIndex = 0;
    private static final int animationSpeed = 60;

    private InfluencerButton[] arrowButtons;

    private EnumGender gender;
    private String tribeLetter;
    private String firstName;
    private String lastName;
    private EnumCharacterAction action = EnumCharacterAction.WALK;
    private int age;
    private int voiceNumber;

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
        this.age = 25;

        loadAnimationMale();
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
        g2.drawImage(animationMale[appearanceIndex][animationIndex], x, y, width, height, null);

        for (InfluencerButton ib : arrowButtons) {
            ib.draw(g2);
        }
    }

    public void update() {
//        System.out.println("update");
        updateAnimationTick();
//        updateGenderAppearance();

//        updateAnimationTickTwo();
    }

    private void updateGenderAppearance() {
    }

    public void drawInfluencerUI(Graphics2D g2) {

    }

    //TODO
    private void loadAnimationsArray() {
        BufferedImage img = AssetLoader.GetSpriteAtlas(AssetLoader.CHARACTER_SPRITESHEET_M);
        tempAnimationWalking = new BufferedImage[7];
        for (int i = 0; i < tempAnimationWalking.length; i++) {
            tempAnimationWalking[i] = img.getSubimage(i * 400, 0 * 500, 400, 500);
        }
    }

    private void loadAnimationMale() {
        //TODO
        //How to make it so that both of the images get loaded, but which one gets displayed is determinate on the gender.
        BufferedImage img = AssetLoader.GetSpriteAtlas(AssetLoader.CHARACTER_SPRITESHEET_M);
        animationMale = new BufferedImage[6][8];
        for (int j = 0; j < animationMale.length; j++) {
            for (int i = 0; i < animationMale[j].length; i++) {
                animationMale[j][i] = img.getSubimage(i * 400, j * 500, 400, 500);
            }
        }
    }

    private void loadAnimationFemale() {
        //TODO
        //How to make it so that both of the images get loaded, but which one gets displayed is determinate on the gender.
        BufferedImage img = AssetLoader.GetSpriteAtlas(AssetLoader.CHARACTER_SPRITESHEET_M);
        animationMale = new BufferedImage[6][8];
        for (int j = 0; j < animationMale.length; j++) {
            for (int i = 0; i < animationMale[j].length; i++) {
                animationMale[j][i] = img.getSubimage(i * 400, j * 500, 400, 500);
            }
        }
    }


    private void loadButtons() {
        arrowButtons = new InfluencerButton[6];
        arrowButtons[0] = new InfluencerButton(155, 420, EnumInfluencerButtonProperty.AGE_UP,this);
        arrowButtons[1] = new InfluencerButton(30, 420, EnumInfluencerButtonProperty.AGE_DOWN,this);
        arrowButtons[2] = new InfluencerButton(30,182,40,40,EnumInfluencerButtonProperty.CHANGE_FEMALE,this);
        arrowButtons[3] = new InfluencerButton(133,182,40,40,EnumInfluencerButtonProperty.CHANGE_MALE,this);
        arrowButtons[4] = new InfluencerButton(630, 68,EnumInfluencerButtonProperty.APPEARANCE_NEXT,this);
        arrowButtons[5] = new InfluencerButton(505, 68,EnumInfluencerButtonProperty.APPEARANCE_PREV,this);
        System.out.println(arrowButtons[0].getBounds());
        System.out.println(arrowButtons[1].getBounds());
    }
    private static int miqoGetSpriteAmount() {
        return 8;
    }

    public void makeShort(int age){
        width = (width - age);
        height = height - age;
        x = x +(age/2);
        y = y +(age);
    }



    ////////////////


    public int getAppearanceIndex() {
        return appearanceIndex;
    }

    public EnumGender getGender() {
        return gender;
    }

    public String getTribeLetter() {
        return tribeLetter;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public InfluencerButton[] getArrowButtons() {
        return arrowButtons;
    }

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

    public CharacterDisplayScreen getDisplayScreen() {
        return displayScreen;
    }

    public void setGender(EnumGender gender) {
        this.gender = gender;
    }

    public void setAppearanceIndex(int appearanceIndex) {
        this.appearanceIndex = appearanceIndex;
    }

    public void setTribeLetter(String tribeLetter) {
        this.tribeLetter = tribeLetter;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getVoiceNumber() {
        return voiceNumber;
    }

    public void setVoiceNumber(int voiceNumber) {
        this.voiceNumber = voiceNumber;
    }
}
