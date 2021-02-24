package Java;

import javafx.scene.image.Image;

public class SceneLoader {

    private final SharkEscape sharkEscape;
    private final Image box, platform, sawblade, chain, drill, nut, fish, hidden;
    public final int oceanWidth = SceneMap.SceneMap[0].length() * 64;

    public SceneLoader(SharkEscape sharkEscape) {

        this.sharkEscape = sharkEscape;
        box = new Image(sharkEscape.uriPath + "box.gif", 64, 64, true, false, true);
        platform = new Image(sharkEscape.uriPath + "platform.gif", 64, 64, true, false, true);
        sawblade = new Image(sharkEscape.uriPath + "Blade1.gif", 64, 64, true, false, true);
        chain = new Image(sharkEscape.uriPath + "Chain1.gif", 64, 64, true, false, true);
        drill = new Image(sharkEscape.uriPath + "Drill1.gif", 64, 64, true, false, true);
        nut = new Image(sharkEscape.uriPath + "Drilling1.gif", 64, 64, true, false, true);
        fish = new Image(sharkEscape.uriPath + "Fish1.gif", 64, 30, true, false, true);
        hidden = new Image(sharkEscape.uriPath + "hidden.gif", 64, 64, true, false, true);
    }

    public void loadSceneMap() {

        for (int i = 0; i < SceneMap.SceneMap.length; i++) { //Columns
            String line = SceneMap.SceneMap[i]; 

            for (int j = 0; j < line.length(); j++) {//Rows
                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case 'H':
                        createTile(j * 64, i * 64, 1, hidden);
                        break;
                    case 'B':
                        createTile(j * 64, i * 64, 2, box);
                        break;
                    case 'P':
                        createTile(j * 64, i * 64, 3, platform);
                        break;
                    case 'S':
                    	createTile(j * 64, i * 64, 4, sawblade);
                        break;
                    case 'C':
                    	createTile(j * 64, i * 64, 5, chain);
                        break;
                    case 'D':
                    	createTile(j * 64, i * 64, 6, drill);
                        break;
                    case 'N':
                    	createTile(j * 64, i * 64, 7, nut);
                        break;
                    case 'F':
                        loadFish(j * 64, i * 68, 0, fish);
                        break;
                }
            }
        }
    }

    private void createTile(double xPosition, double yPosition, int spriteType, Image image) {
        SceneSprite sceneSprite = new SceneSprite(xPosition, yPosition, spriteType, image);
        sharkEscape.root.getChildren().add(sceneSprite.getSpriteFrame());
        sharkEscape.choreographer.addCurrentCast(sceneSprite);
    } //createTile

    private void loadFish(double xPosition, double yPosition, int spriteType, Image image) {
        SceneSprite fish = new SceneSprite(xPosition, yPosition, spriteType, image);
        sharkEscape.root.getChildren().add(fish.getSpriteFrame());
        sharkEscape.choreographer.addDynamicCast(fish);
    }

}
