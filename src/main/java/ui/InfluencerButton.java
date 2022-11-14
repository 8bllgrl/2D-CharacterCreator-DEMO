package ui;

import util.AssetLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InfluencerButton {

    private int width;
    private int height;
    private int x;
    private int y;
    private EnumInfluencerButtonProperty buttonProperty;
    private boolean mouseOver,MousePressed;
    private BufferedImage appearance;
    private Rectangle bounds;

    public InfluencerButton(int x, int y, EnumInfluencerButtonProperty buttonProperty){
        this.x = x;
        this.y = y;
        this.width = 35;
        this.height = 35;
        this.buttonProperty = buttonProperty;
        loadAppearance();
        initializeBounds();

    }

    private void loadAppearance() {
        if(buttonProperty == EnumInfluencerButtonProperty.AGE_UP){
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.NEXT_ARROW_BUTTON);
            System.out.println("loaded age up button");
        } else {
            appearance = AssetLoader.GetSpriteAtlas(AssetLoader.PREVIOUS_ARROW_BUTTON);
            System.out.println("loaded other button");
        }
    }

    private void initializeBounds() {
        bounds = new Rectangle(x,y,width,height);
    }
    public void draw(Graphics g) {
        g.drawImage(appearance,x,y,width,height,null);
    }
}
