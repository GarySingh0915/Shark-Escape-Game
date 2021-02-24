package Java;

import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SharkEscape extends Application {
    
    public static final int WIDTH = 800, HEIGHT = 600;
    public int oceanWidth, maxConflictCount = 10000;
    public boolean singlePlayer = true;
    public boolean sharkEscapeComplete = false, sharkEscapeOver = false;
    public String uriPath = "file:///Users/ssing19/Documents/workspace/SharkEscape/bin/Data/";
    
    Stage stage;
    Scene scene;
    
    public Group root;
    public Group masterRoot;
    
    public final HashMap<KeyCode, Boolean> keys = new HashMap<>();
    
    public Menu menu;
    public Choreographer choreographer;
    public PlayerLoader playerLoader;
    public SharkEscapeLoop sharkEscapeLoop;
    public SceneLoader sceneLoader;
    
    public int score1 = 0, score2 = 0, conflict1 = 0, conflict2 = 0;
    public Label scoreLabel1, scoreLabel2, conflictLabel1, conflictLabel2;
    public ImageView  backGround, fish1, fish2, expl1, expl2, bshark1, gshark1;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    
        stage = primaryStage;
        stage.setTitle("SHARK ESCAPE");
        
        root = new Group();
        masterRoot = new Group();
        
        backGround = new ImageView(new Image(uriPath + "background.gif"));
        fish1 = new ImageView(new Image(uriPath + "Fish1.gif", 32, 15, true, false, true));
        expl1 = new ImageView(new Image(uriPath + "explosion1.gif", 32, 32, true, false, true));
        fish2 = new ImageView(new Image(uriPath + "Fish1.gif", 32, 15, true, false, true));
        expl2 = new ImageView(new Image(uriPath + "explosion1.gif", 32, 32, true, false, true));
        bshark1 = new ImageView(new Image(uriPath + "sharkp1.gif", 100, 35, true, false, true));
        gshark1 = new ImageView(new Image(uriPath + "sharkm1.gif", 100, 35, true, false, true));
        
        scoreLabel1 = new Label(Integer.toString(score1));
        scoreLabel1.setTextFill(Color.WHITE);
        conflictLabel1 = new Label(Integer.toString(conflict1));
        conflictLabel1.setTextFill(Color.WHITE);
        
        scoreLabel2 = new Label(Integer.toString(score2));
        scoreLabel2.setTextFill(Color.WHITE);
        conflictLabel2 = new Label(Integer.toString(conflict2));
        conflictLabel2.setTextFill(Color.WHITE);
        
        masterRoot.getChildren().addAll(backGround, fish1, fish2, expl1, expl2, bshark1, gshark1, conflictLabel1, conflictLabel2, scoreLabel1, scoreLabel2, root);
        
        bshark1.setTranslateX(540);
        bshark1.setTranslateY(0);
        expl1.setTranslateX(650);
        expl1.setTranslateY(5);
        conflictLabel1.setTranslateX(690);
        conflictLabel1.setTranslateY(10);
        fish1.setTranslateX(730);
        fish1.setTranslateY(15);
        scoreLabel1.setTranslateX(770);
        scoreLabel1.setTranslateY(10);
        
        gshark1.setTranslateX(540);
        gshark1.setTranslateY(30);
        expl2.setTranslateX(650);
        expl2.setTranslateY(35);
        conflictLabel2.setTranslateX(690);
        conflictLabel2.setTranslateY(40);
        fish2.setTranslateX(730);
        fish2.setTranslateY(40);
        scoreLabel2.setTranslateX(770);
        scoreLabel2.setTranslateY(40);
        
        scene = new Scene(masterRoot, WIDTH, HEIGHT);
        
        stage.getIcons().add(new Image(uriPath + "sharkicon.jpg"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        AudioClip bgmusic = new AudioClip(uriPath + "music.mp3");
        bgmusic.play();
        
        setKeysMapper();
        loadStartMenu();
        loadSceneMap();
        loadPlayers();
        sharkEscapeLoop();
    }
    //Maps scene keys with HashMap
    private void setKeysMapper() {
        
        scene.setOnKeyPressed(e -> keys.put(e.getCode(), true)); //true if pressed
        scene.setOnKeyReleased(e -> keys.put(e.getCode(), false)); //false if released
    }
    
    private void loadStartMenu() {
        menu = new Menu(this);
        menu.main();
    }
    
    public void loadSceneMap() {
        
        choreographer = new Choreographer();
        
        sceneLoader = new SceneLoader(this);
        sceneLoader.loadSceneMap();
        oceanWidth = sceneLoader.oceanWidth;
    }
    
    
    private void loadPlayers() {

        playerLoader = new PlayerLoader(this);
        playerLoader.loadPlayers();
    }
    
    private void sharkEscapeLoop() {
        
        sharkEscapeLoop = new SharkEscapeLoop(this, playerLoader.player, playerLoader.mplayer);
    }
    
    //returns true if the passed key(KeyCode.KEY) is true and false if its released, default value = false (returns false if nothing is pressed)
    public boolean isKeyPressed(KeyCode key) {
        
        return keys.getOrDefault(key, false);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
