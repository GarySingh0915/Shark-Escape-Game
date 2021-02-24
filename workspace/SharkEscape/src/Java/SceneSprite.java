package Java;

import javafx.scene.image.Image;

public class SceneSprite extends Sprite {

    public SceneSprite(double xPosition, double yPosition, int spriteType, Image image) {
        super(xPosition, yPosition, spriteType, image);
        
        this.spriteFrame.setTranslateX(xPosition);
        this.spriteFrame.setTranslateY(yPosition);
        this.spriteType = spriteType;
    }
    
}
