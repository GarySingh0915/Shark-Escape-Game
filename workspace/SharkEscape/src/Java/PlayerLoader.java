package Java;

public class PlayerLoader {
    
    private final SharkEscape sharkEscape;
    public Player player;
    public MPlayer mplayer;
    public boolean playerWinner = false;
    private final PlayerImage images = new PlayerImage();
    
    
    public PlayerLoader(SharkEscape sharkEscape) {
        this.sharkEscape = sharkEscape;
    }
    
    public void loadPlayers() {
        images.loadPlayerImage(sharkEscape);
        player = new Player(sharkEscape, 280, 300, images.bshark1,  images.bshark2);
        sharkEscape.root.getChildren().add(player.getSpriteFrame());
        
	    images.loadMplayerImage(sharkEscape);
	    mplayer = new MPlayer(sharkEscape, player, 280, 400, images.gshark1, images.gshark2);
	    sharkEscape.root.getChildren().add(mplayer.getSpriteFrame());
    }
} 
