package util;

public class ConstantsMiqo {

    //age variables for each age underneath 18.
    //REASON : i can't figure out the math for this. This can be turned into math, but for now it will be constants
    //--because I want this to be consistent in a game setting and i'm more concerned about the results for now than
    //--figuring out a perfect 'maths solutionz' to this o_O

    //TODO: The reason that this way of doing things is bad.
    //The reason why this is a bad way of doing things means i have to go in and do the math all over again when and if
    //i make the decision to change the height of the characters or how much the characters take up space on the screen.
    //it also takes up so much more memory than math does.
    //TODO: this could be temporarily fixed by making constants for the adult sizes, assigning the characters to this size
    //todo: and then making it so that the math on this page just uses the adult size in order to do math.

    //Defaults:
    public static final int ADULT_X = 215;
    public static final int ADULT_Y = 85;
    public static final int ADULT_W = 315;
    public static final int ADULT_H = 415;


    //height
    public static final int SEVENTEEN_HEIGHT = ADULT_H - 20;
    public static final int SIXTEEN_HEIGHT = ADULT_H - 25;
    public static final int FIFTEEN_HEIGHT = ADULT_H - 30;
    public static final int FOURTEEN_HEIGHT = ADULT_H - 35;
    public static final int THIRTEEN_HEIGHT = ADULT_H - 40;
    public static final int TWELVE_HEIGHT = ADULT_H - 45;
    public static final int ELEVEN_HEIGHT = ADULT_H - 50;
    public static final int TEN_HEIGHT = ADULT_H - 55;
    public static final int NINE_HEIGHT = ADULT_H - 60;
    public static final int EIGHT_HEIGHT = ADULT_H - 65;
    public static final int SEVEN_HEIGHT = ADULT_H - 70;
    public static final int SIX_HEIGHT = ADULT_H - 75;
    public static final int FIVE_HEIGHT = ADULT_H - 80;
    public static final int FOUR_HEIGHT = ADULT_H - 85;
    public static final int THREE_HEIGHT = ADULT_H - 80;
    public static final int TWO_HEIGHT = ADULT_H - 95;
    public static final int ONE_HEIGHT = ADULT_H - 100;

    //width
    public static final int SEVENTEEN_WIDTH = ADULT_W;
    public static final int SIXTEEN_WIDTH = ADULT_W;
    public static final int FIFTEEN_WIDTH = ADULT_W;
    public static final int FOURTEEN_WIDTH = ADULT_W - 30;
    public static final int THIRTEEN_WIDTH = ADULT_W - 35;
    public static final int TWELVE_WIDTH = ADULT_W - 40;
    public static final int ELEVEN_WIDTH = ADULT_W - 45;
    public static final int TEN_WIDTH = ADULT_W - 50;
    public static final int NINE_WIDTH = ADULT_W - 55;
    public static final int EIGHT_WIDTH = ADULT_W - 60;
    public static final int SEVEN_WIDTH = ADULT_W - 65;
    public static final int SIX_WIDTH = ADULT_W - 70;
    public static final int FIVE_WIDTH = ADULT_W - 75;
    public static final int FOUR_WIDTH = ADULT_W - 80;
    public static final int THREE_WIDTH = ADULT_W - 85;
    public static final int TWO_WIDTH = ADULT_W - 90;
    public static final int ONE_WIDTH = ADULT_W - 95;

    //x
    public static final int SEVENTEEN_X = ADULT_X + 20;
    public static final int SIXTEEN_X = ADULT_X + 25;
    public static final int FIFTEEN_X = ADULT_X + 30;
    public static final int FOURTEEN_X = ADULT_X + 35;
    public static final int THIRTEEN_X = ADULT_X + 40;
    public static final int TWELVE_X = ADULT_X + 45;
    public static final int ELEVEN_X = ADULT_X + 50;
    public static final int TEN_X = ADULT_X + 55;
    public static final int NINE_X = ADULT_X + 60;
    public static final int EIGHT_X = ADULT_X + 65;
    public static final int SEVEN_X = ADULT_X + 70;
    public static final int SIX_X = ADULT_X + 75;
    public static final int FIVE_X = ADULT_X + 80;
    public static final int FOUR_X = ADULT_X + 85;
    public static final int THREE_X = ADULT_X + 90;
    public static final int TWO_X = ADULT_X + 95;
    public static final int ONE_X = ADULT_X + 100;

    //y
    public static final int SEVENTEEN_Y = ADULT_Y + 20;
    public static final int SIXTEEN_Y = ADULT_Y + 25;
    public static final int FIFTEEN_Y = ADULT_Y + 30;
    public static final int FOURTEEN_Y = ADULT_Y + 35;
    public static final int THIRTEEN_Y = ADULT_Y + 40;
    public static final int TWELVE_Y = ADULT_Y + 45;
    public static final int ELEVEN_Y = ADULT_Y + 50;
    public static final int TEN_Y = ADULT_Y + 55;
    public static final int NINE_Y = ADULT_Y + 60;
    public static final int EIGHT_Y = ADULT_Y + 65;
    public static final int SEVEN_Y = ADULT_Y + 70;
    public static final int SIX_Y = ADULT_Y + 75;
    public static final int FIVE_Y = ADULT_Y + 80;
    public static final int FOUR_Y = ADULT_Y + 85;
    public static final int THREE_Y = ADULT_Y + 90;
    public static final int TWO_Y = ADULT_Y + 95;
    public static final int ONE_Y = ADULT_Y + 100;
}
