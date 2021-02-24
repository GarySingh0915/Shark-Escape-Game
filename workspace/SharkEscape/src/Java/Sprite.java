package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Sprite {

    protected List<Image> imageStates = new ArrayList<>();
    protected ImageView spriteFrame = new ImageView();
    protected double xPosition;
    protected double yposition;
    protected int spriteType;

    Sprite(double xPosition, double yPosition, int spriteType, Image image) {
        this.xPosition = xPosition;
        this.yposition = yPosition;
        this.spriteType = spriteType;
        this.spriteFrame.setImage(image);
    }

    Sprite(double xPosition, double yPosition, int spriteType, Image... imageStates) {
        this.xPosition = xPosition;
        this.yposition = yPosition;
        this.spriteType = spriteType;
        this.imageStates = Arrays.asList(imageStates);
        this.spriteFrame.setImage(imageStates[0]);
    }

    public ImageView getSpriteFrame() {
        return spriteFrame;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getYposition() {
        return yposition;
    }

}
