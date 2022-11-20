package entities;

import gamescreens.CharacterDisplayScreen;
import ui.EnumInfluencerButtonProperty;
import ui.InfluencerButton;
import util.AssetLoader;
import util.ConstantsMiqo;

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
    private int ageChecker;
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
        this.ageChecker = age;

        loadAnimationMale();
        loadAnimationFemale();
        loadButtons();


        //TODO
//        loadAnimationsArray();
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
        if (gender == EnumGender.MALE) {
            g2.drawImage(animationMale[appearanceIndex][animationIndex], x, y, width, height, null);
        } else if (gender == EnumGender.FEMALE) {
            g2.drawImage(animationFemale[appearanceIndex][animationIndex], x, y, width, height, null);
        }

        for (InfluencerButton ib : arrowButtons) {
            ib.draw(g2);
        }
    }

    public void update() {
//        System.out.println("update");
        updateAnimationTick();
        updateGenderAppearance();
        //update age size / check age size, does math based on the difference between the age and if it is 18. Only does it once.
        tempChangeSize();
    }

    private void tempChangeSize() {
        if (age == 17) {
            height = ConstantsMiqo.SEVENTEEN_HEIGHT;
            width = ConstantsMiqo.SEVENTEEN_WIDTH;
            x = ConstantsMiqo.SEVENTEEN_X;
            y = ConstantsMiqo.SEVENTEEN_Y;
        } else if (age == 16) {
            height = ConstantsMiqo.SIXTEEN_HEIGHT;
            width = ConstantsMiqo.SIXTEEN_WIDTH;
            x = ConstantsMiqo.SIXTEEN_X;
            y = ConstantsMiqo.SIXTEEN_Y;
        } else if (age == 15) {
            height = ConstantsMiqo.FIFTEEN_HEIGHT;
            width = ConstantsMiqo.FIFTEEN_WIDTH;
            x = ConstantsMiqo.FIFTEEN_X;
            y = ConstantsMiqo.FIFTEEN_Y;
        } else if (age == 14) {
            height = ConstantsMiqo.FOURTEEN_HEIGHT;
            width = ConstantsMiqo.FOURTEEN_WIDTH;
            x = ConstantsMiqo.FOURTEEN_X;
            y = ConstantsMiqo.FOURTEEN_Y;
        } else if (age == 13) {
            height = ConstantsMiqo.THIRTEEN_HEIGHT;
            width = ConstantsMiqo.THIRTEEN_WIDTH;
            x = ConstantsMiqo.THIRTEEN_X;
            y = ConstantsMiqo.THIRTEEN_Y;
        } else if (age == 12) {
            height = ConstantsMiqo.TWELVE_HEIGHT;
            width = ConstantsMiqo.TWELVE_WIDTH;
            x = ConstantsMiqo.TWELVE_X;
            y = ConstantsMiqo.TWELVE_Y;
        } else if (age == 11) {
            height = ConstantsMiqo.ELEVEN_HEIGHT;
            width = ConstantsMiqo.ELEVEN_WIDTH;
            x = ConstantsMiqo.ELEVEN_X;
            y = ConstantsMiqo.ELEVEN_Y;
        } else if (age == 10) {
            height = ConstantsMiqo.TEN_HEIGHT;
            width = ConstantsMiqo.TEN_WIDTH;
            x = ConstantsMiqo.TEN_X;
            y = ConstantsMiqo.TEN_Y;
        } else if (age == 9) {
            height = ConstantsMiqo.NINE_HEIGHT;
            width = ConstantsMiqo.NINE_WIDTH;
            x = ConstantsMiqo.NINE_X;
            y = ConstantsMiqo.NINE_Y;
        } else if (age == 8) {
            height = ConstantsMiqo.EIGHT_HEIGHT;
            width = ConstantsMiqo.EIGHT_WIDTH;
            x = ConstantsMiqo.EIGHT_X;
            y = ConstantsMiqo.EIGHT_Y;
        } else if (age == 7) {
            height = ConstantsMiqo.SEVEN_HEIGHT;
            width = ConstantsMiqo.SEVEN_WIDTH;
            x = ConstantsMiqo.SEVEN_X;
            y = ConstantsMiqo.SEVEN_Y;
        } else if (age == 6) {
            height = ConstantsMiqo.SIX_HEIGHT;
            width = ConstantsMiqo.SIX_WIDTH;
            x = ConstantsMiqo.SIX_X;
            y = ConstantsMiqo.SIX_Y;
        } else if (age == 5) {
            height = ConstantsMiqo.FIVE_HEIGHT;
            width = ConstantsMiqo.FIVE_WIDTH;
            x = ConstantsMiqo.FIVE_X;
            y = ConstantsMiqo.FIVE_Y;
        } else if (age == 4) {
            height = ConstantsMiqo.FOUR_HEIGHT;
            width = ConstantsMiqo.FOUR_WIDTH;
            x = ConstantsMiqo.FOUR_X;
            y = ConstantsMiqo.FOUR_Y;
        } else if (age == 3) {
            height = ConstantsMiqo.THREE_HEIGHT;
            width = ConstantsMiqo.THREE_WIDTH;
            x = ConstantsMiqo.THREE_X;
            y = ConstantsMiqo.THREE_Y;
        } else if (age == 2) {
            height = ConstantsMiqo.TWO_HEIGHT;
            width = ConstantsMiqo.TWO_WIDTH;
            x = ConstantsMiqo.TWO_X;
            y = ConstantsMiqo.TWO_Y;
        } else if (age == 1) {
            height = ConstantsMiqo.ONE_HEIGHT;
            width = ConstantsMiqo.ONE_WIDTH;
            x = ConstantsMiqo.ONE_X;
            y = ConstantsMiqo.ONE_Y;
        } else {
            height = 415;
            width = 315;
            x = 215;
            y = 85;
        }
    }

    private boolean ageHasDecreased() {
        if (ageChecker > age) {
            ageChecker = this.age;
            return true;
        } else {
            ageChecker = this.age;
            return false;
        }
    }

    private boolean ageHasIncreased() {
        if (ageChecker < age) {
            ageChecker = this.age;
            return true;
        } else {
            ageChecker = this.age;
            return false;
        }

    }

    private void increaseSize() {
        width = (width + age);
        height = height + age;
        x = x - (age / 2);
        y = y - (age);

    }

    private void decreaseSize() {
        width = (width - age);
        height = height - age;
        x = x + (age / 2);
        y = y + (age);

    }

    private void changeHeightOld() {
        int ageMath;
        if (age < 18) {
            ageMath = age;
            ageMath = 18 - ageMath;

            height = (height - ageMath);
            width = (height - ageMath);
            x = x + (age / 2);
            y = y + (ageMath);
        }
    }

    private boolean ageIsBelowEighteen() {
        if (age < 18) {
            return true;
        } else {
            return false;
        }
    }

    private boolean ageHasChanged() {
        if (ageChecker != this.age) {
//            ageChecker = this.age;
//            ageChecker = age;
            return true;
        } else {
            return false;
        }
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
        BufferedImage img = AssetLoader.GetSpriteAtlas(AssetLoader.CHARACTER_SPRITESHEET_F);
        animationFemale = new BufferedImage[6][8];
        for (int j = 0; j < animationFemale.length; j++) {
            for (int i = 0; i < animationFemale[j].length; i++) {
                animationFemale[j][i] = img.getSubimage(i * 400, j * 500, 400, 500);
            }
        }
    }


    private void loadButtons() {
        arrowButtons = new InfluencerButton[8];
        arrowButtons[0] = new InfluencerButton(155, 420, EnumInfluencerButtonProperty.AGE_UP, this);
        arrowButtons[1] = new InfluencerButton(30, 420, EnumInfluencerButtonProperty.AGE_DOWN, this);
        arrowButtons[2] = new InfluencerButton(30, 182, 40, 40, EnumInfluencerButtonProperty.CHANGE_FEMALE, this);
        arrowButtons[3] = new InfluencerButton(133, 182, 40, 40, EnumInfluencerButtonProperty.CHANGE_MALE, this);
        arrowButtons[4] = new InfluencerButton(630, 68, EnumInfluencerButtonProperty.APPEARANCE_NEXT, this);
        arrowButtons[5] = new InfluencerButton(505, 68, EnumInfluencerButtonProperty.APPEARANCE_PREV, this);
        arrowButtons[6] = new InfluencerButton(190, 25,EnumInfluencerButtonProperty.RANDOMIZE_NAME, this);
        arrowButtons[7] = new InfluencerButton(700, 25,EnumInfluencerButtonProperty.RANDOMIZE_APPEARANCE, this);
    }

    private static int miqoGetSpriteAmount() {
        return 8;
    }

    public void makeShort(int age) {
        width = (width - age);
        height = height - age;
        x = x + (age / 2);
        y = y + (age);
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
