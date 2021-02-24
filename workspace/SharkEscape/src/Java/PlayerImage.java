package Java;

import javafx.scene.image.Image;

public class PlayerImage {
	
    Image bshark1, bshark2, gshark1, gshark2;

    public void loadPlayerImage(SharkEscape sharkEscape) {
        
        bshark1 = new Image(sharkEscape.uriPath + "sharkp1.gif", 145, 49, true, false, true);
        bshark2 = new Image(sharkEscape.uriPath + "sharkp2.gif", 145, 49, true, false, true);
    }
    
    public void loadMplayerImage(SharkEscape sharkEscape) {
        
        gshark1 = new Image(sharkEscape.uriPath + "sharkm1.gif", 145, 49, true, false, true);
        gshark2 = new Image(sharkEscape.uriPath + "sharkm2.gif", 145, 49, true, false, true);
    }
}
