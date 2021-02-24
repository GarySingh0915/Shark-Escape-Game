package Java;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;

public class SharkEscapeLoop extends AnimationTimer {
    
    public Timeline animation;
    private final SharkEscape sharkEscape;
    Player player;
    MPlayer mplayer;
    
    SharkEscapeLoop(SharkEscape sharkEscape, Player player, MPlayer mplayer) {
    
        this.player = player;
        this.mplayer = mplayer;
        this.sharkEscape = sharkEscape;
    }
    
    @Override
    public void handle(long now) {
        
        animation = new Timeline(now);
        player.Update();
        if (!sharkEscape.singlePlayer) {
        	mplayer.Update();
        }
    }
    
    @Override
    public void start() {
        super.start();
    }
    
    @Override
    public void stop() {
        super.stop();
    }
    
}
