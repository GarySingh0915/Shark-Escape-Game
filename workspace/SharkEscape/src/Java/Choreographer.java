package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Choreographer {

    private final List<Sprite> CURRENT_CAST;
    private final List<Sprite> DYNAMIC_CAST;
    private final Set<Sprite> REMOVE_SPRITES;

    Choreographer() {
        CURRENT_CAST = new ArrayList<>();
        DYNAMIC_CAST = new ArrayList<>();
        REMOVE_SPRITES = new HashSet<>();
    } //constructor

    public void addCurrentCast(Sprite... sprites) {
        if (sprites.length > 1) {
            CURRENT_CAST.addAll(Arrays.asList(sprites));
        } else {
            CURRENT_CAST.add(sprites[0]);
        }
    } //addCurrentCast

    public List<Sprite> getCurrentCast() {
        return CURRENT_CAST;
    }

    public void removeCurrentCast(Sprite... sprites) {
        CURRENT_CAST.removeAll(Arrays.asList(sprites));
    }//removeCurrentCast

    public void resetCurrentCast() {
        CURRENT_CAST.clear();
    }//resetCurrentCast
    
    public void addDynamicCast(Sprite... sprites) {

        if (sprites.length > 1) {
            DYNAMIC_CAST.addAll(Arrays.asList(sprites));
        } else {
            DYNAMIC_CAST.add(sprites[0]);
        }
    }//addDynamicCast

    public List<Sprite> getDynamicCast() {
        return DYNAMIC_CAST;
    }

    public void resetDynamicCast() {
        DYNAMIC_CAST.clear();
    }//reset DynamicCast
    
    public void removeDynamicCast(Sprite sprite) {
        DYNAMIC_CAST.remove(sprite);
    }

    public void addToRemoveSprites(Sprite... sprites) {
        if (sprites.length > 1) {
            REMOVE_SPRITES.addAll(Arrays.asList((Sprite[]) sprites));
        } else {
            REMOVE_SPRITES.add(sprites[0]);
        }
    }//addToRemoveCast

    public void resetRemovedSprites() {
        DYNAMIC_CAST.removeAll(REMOVE_SPRITES);
        REMOVE_SPRITES.clear();
    }
}
