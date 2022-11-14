//package discard;
//
//import util.AssetLoader;
//import util.ButtonFunction;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class InfluencerButton_OLD {
//    public final int RANDOM_BUTTON = 0;
//    public final int BACK_ARROW = 1;
//    public final int NEXT_ARROW = 2;
//
//    private ButtonFunction buttonFunction;
//
//    private int xPosition, yPosition;
//    private int buttonWidth;
//    private int buttonHeight;
//
//    private int buttonIndex;
//    private int appearanceIndex;
//    private BufferedImage[] images;
//    private boolean mouseOver;
//    private boolean mousePressed;
//    private Rectangle bounds;
//
//    public InfluencerButton_OLD(int xPosition, int yPosition, int buttonWidth, int buttonHeight, int appearanceIndex, ButtonFunction buttonFunction){
//        this.xPosition = xPosition;
//        this.yPosition = yPosition;
//        this.buttonWidth = buttonWidth;
//        this.buttonHeight = buttonHeight;
//        this.appearanceIndex = appearanceIndex;
//        this.buttonFunction = buttonFunction;
//        loadImgs();
//        initializeBounds();
//    }
//
//    private void loadImgs(){
//        images = new BufferedImage[3];
//        BufferedImage nextArrow = AssetLoader.GetSpriteAtlas(AssetLoader.NEXT_ARROW_BUTTON);
//        BufferedImage backArrow = AssetLoader.GetSpriteAtlas(AssetLoader.PREVIOUS_ARROW_BUTTON);
//        BufferedImage randomizerButton = AssetLoader.GetSpriteAtlas(AssetLoader.RANDOMIZER_BUTTON);
//
//        images[0] = randomizerButton;
//        images[1] = backArrow;
//        images[2] = nextArrow;
//    }
//
//    private void initializeBounds() {
//        bounds = new Rectangle(xPosition,yPosition,buttonWidth,buttonHeight);
//    }
//
//}
