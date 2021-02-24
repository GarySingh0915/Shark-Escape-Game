package Java;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Menu extends AnimationTimer {

    private int currentChoice = 0;
    private final Label l1 = new Label();
    private final Label l2 = new Label();
    private final Label l3 = new Label();
    private final Label l4 = new Label();
    private final Label l5 = new Label();
    private final VBox menuBox = new VBox();
    private final Group menuRoot = new Group();
    private final Scene menuScene = new Scene(menuRoot, SharkEscape.WIDTH, SharkEscape.HEIGHT, Color.BLACK);;
    private final ImageView menuBG, holdImg, instructionImg, creditsImg, complete, GameOver;
    private final ImageView sharkrotating = new ImageView();
    private final SharkEscape sharkEscape;
    public Timeline animation;

    //Constructor
    public Menu(SharkEscape sharkEscape) {

        this.sharkEscape = sharkEscape;
        
        menuBG = new ImageView(new Image(sharkEscape.uriPath + "menu1.png", 800, 600, true, false, true));
        holdImg = new ImageView(new Image(sharkEscape.uriPath + "hold.gif", 800, 600, true, false, true));
        instructionImg = new ImageView(new Image(sharkEscape.uriPath + "ins.gif", 800, 600, true, false, true));
        creditsImg = new ImageView(new Image(sharkEscape.uriPath + "credits.gif", 800, 600, true, false, true));    
        complete = new ImageView(new Image(sharkEscape.uriPath + "complete.gif", 800, 600, true, false, true));
        GameOver = new ImageView(new Image(sharkEscape.uriPath + "GameOver.png", 800, 600, true, false, true));

    }

    //Menu-1
    public void main() {

        l1.setText("Play - Single-Player");
        setStyle(l1);
        l2.setText("Play - Multi-Player");
        setStyle(l2);
        l3.setText("Instruction");
        setStyle(l3);
        l4.setText("Credits");
        setStyle(l4);
        l5.setText("Exit");
        setStyle(l5);
        menuBox.getChildren().addAll(l1, l2, l3, l4, l5);
        menuBox.setBackground(Background.EMPTY);
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setTranslateX(40);
        menuBox.setTranslateY(300);
        
        Image sharkcircling = new Image(sharkEscape.uriPath + "Menu.png" );
        
        sharkrotating.setImage(sharkcircling);
        sharkrotating.setTranslateX(350);
        sharkrotating.setTranslateY(150);
        menuRoot.getChildren().addAll(menuBG, menuBox,sharkrotating);
        sharkEscape.stage.setScene(menuScene);
        start();

        setSceneEventHandling();
    }
    
    @Override
    public void handle(long now) {
        
        animation = new Timeline(now);
        sharkrotating.setScaleX(-1);
        sharkrotating.setRotate(now/10000000.0);
    }
    
    @Override
    public void start() {
        super.start();
    }
    
    @Override
    public void stop() {
        super.stop();
    }        		
    
    private void setStyle(Label label) {

        label.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px;");
        label.setPadding(new Insets(10, 10, 10, 10));
    }

    private void setSceneEventHandling() {

        menuScene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    if (currentChoice > 1) {
                        currentChoice -= 1;
                    }
                    break;
                case DOWN:
                    if (currentChoice < 5) {
                        currentChoice += 1;
                    }
                    break;
                case ENTER:
                    if (currentChoice == 1) { startSelectedSingle();
                    }
                    if (currentChoice == 2) { startSelectedMulti();
                    }
                    if (currentChoice == 3) { instructionSelected();
                    }
                    if (currentChoice == 4) { creditSelected();
                    }
                    if (currentChoice == 5) {
                        System.exit(0);
                    }
                default: break;
          
            }
            if (currentChoice == 1) {
                l1.setStyle("-fx-text-fill: Aqua; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l2.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l3.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l4.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l5.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
            } else if (currentChoice == 2) {
                l2.setStyle("-fx-text-fill: Aqua; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l1.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l3.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l4.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l5.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
            } else if (currentChoice == 3) {
                l3.setStyle("-fx-text-fill: Aqua; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l1.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l2.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l4.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l5.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
            } else if (currentChoice == 4) {
                l4.setStyle("-fx-text-fill: Aqua; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l1.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l2.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l3.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l5.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
            } else if (currentChoice == 5) {
                l5.setStyle("-fx-text-fill: Aqua; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l1.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l2.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l3.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
                l4.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
            }
        }); //Up/Down pressed
    } //createKeyHandeler

    private void startSelectedSingle() {
        menuRoot.getChildren().add(holdImg);
        sharkEscape.stage.setScene(menuScene);

        menuScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
            	sharkEscape.singlePlayer = true;
            	menuRoot.getChildren().remove(holdImg);
                sharkEscape.stage.setScene(sharkEscape.scene);
                sharkEscape.sharkEscapeLoop.start();
            }
        });
    }
    
    private void startSelectedMulti() {
        menuRoot.getChildren().add(holdImg);
        sharkEscape.stage.setScene(menuScene);

        menuScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
            	sharkEscape.singlePlayer = false;
            	menuRoot.getChildren().remove(holdImg);
                sharkEscape.stage.setScene(sharkEscape.scene);
                sharkEscape.sharkEscapeLoop.start();
            }
        });
    }

    public void sharkEscapeComplete() {
    	ImageView winner = new ImageView();
    	Image playerA = new Image(sharkEscape.uriPath + "sharkp1.gif");
    	Image playerB = new Image(sharkEscape.uriPath + "sharkm1.gif");
        
        if (sharkEscape.playerLoader.playerWinner) {
        	winner.setImage(playerA);
        } else {
        	winner.setImage(playerB);
        }
        winner.setTranslateX(150);
        winner.setTranslateY(150);
        
        sharkEscape.sharkEscapeComplete = true;
        sharkEscape.sharkEscapeLoop.stop();
        menuRoot.getChildren().addAll(complete, winner);
        sharkEscape.stage.setScene(menuScene);
              
        menuScene.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.ESCAPE) {
                	for(Sprite dynamicCast : sharkEscape.choreographer.getDynamicCast()) {
                		sharkEscape.root.getChildren().remove(dynamicCast.getSpriteFrame());
                    }
                	sharkEscape.choreographer.resetDynamicCast();
                	for(Sprite currentCast : sharkEscape.choreographer.getCurrentCast()) {
                		sharkEscape.root.getChildren().remove(currentCast.getSpriteFrame());
                    }
                	sharkEscape.choreographer.resetCurrentCast();
                	sharkEscape.loadSceneMap();
                	sharkEscape.score1 = 0;
                	sharkEscape.score2 = 0;
                	sharkEscape.conflict1 = 0;
                	sharkEscape.conflict2 = 0;
                	sharkEscape.scoreLabel1.setText(Integer.toString(sharkEscape.score1));
                	sharkEscape.scoreLabel2.setText(Integer.toString(sharkEscape.score2));
                	sharkEscape.conflictLabel1.setText(Integer.toString(sharkEscape.conflict1));
                	sharkEscape.conflictLabel2.setText(Integer.toString(sharkEscape.conflict2));
                	sharkEscape.keys.clear();
                	sharkEscape.playerLoader.player.spriteFrame.setTranslateX(280);
                	sharkEscape.playerLoader.player.spriteFrame.setTranslateY(300);
                	sharkEscape.playerLoader.mplayer.spriteFrame.setTranslateX(280);
                	sharkEscape.playerLoader.mplayer.spriteFrame.setTranslateY(400);
                	sharkEscape.playerLoader.player.spriteFrame.setImage(sharkEscape.playerLoader.player.imageStates.get(0));
            		sharkEscape.playerLoader.mplayer.spriteFrame.setImage(sharkEscape.playerLoader.mplayer.imageStates.get(0));
            		sharkEscape.playerLoader.player.spriteFrame.setScaleX(1);
            		sharkEscape.playerLoader.player.spriteFrame.setRotate(0);
            		sharkEscape.playerLoader.mplayer.spriteFrame.setScaleX(1);
            		sharkEscape.playerLoader.mplayer.spriteFrame.setRotate(0);
                	sharkEscape.root.setTranslateX(0);
                	sharkEscape.backGround.setTranslateX(0);
                	sharkEscape.sharkEscapeComplete = false;
            	    sharkEscape.sharkEscapeOver = false;
                	menuRoot.getChildren().removeAll(complete, winner);
                	sharkEscape.stage.setScene(menuScene);
                    setSceneEventHandling();
            }
        });
    }
     
    public void sharkEscapeOver() {
    	Label winnerLabel = new Label("WINNER");
    	ImageView winner = new ImageView();
        sharkEscape.sharkEscapeOver = true;
        sharkEscape.sharkEscapeComplete = true;
        sharkEscape.sharkEscapeLoop.stop();
    	if (!sharkEscape.singlePlayer) {
	    	winnerLabel.setStyle("-fx-text-fill: White; -fx-font-family: Ubuntu; -fx-font-size: 24px");
	    	winnerLabel.setTranslateX(32);
	        winnerLabel.setTranslateY(160);
	    	Image playerA = new Image(sharkEscape.uriPath + "sharkp1.gif");
	    	Image playerB = new Image(sharkEscape.uriPath + "sharkm1.gif");
	        
	        if (sharkEscape.playerLoader.playerWinner) {
	        	winner.setImage(playerA);
	        } else {
	        	winner.setImage(playerB);
	        }
	        winner.setTranslateX(100);
	        winner.setTranslateY(150);
	        menuRoot.getChildren().addAll(GameOver, winner, winnerLabel);
    	} else {
    		menuRoot.getChildren().addAll(GameOver);
    	}
        
        sharkEscape.stage.setScene(menuScene);
              
        menuScene.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.ESCAPE) {
                	for(Sprite dynamicCast : sharkEscape.choreographer.getDynamicCast()) {
                		sharkEscape.root.getChildren().remove(dynamicCast.getSpriteFrame());
                    }
                	sharkEscape.choreographer.resetDynamicCast();
                	for(Sprite currentCast : sharkEscape.choreographer.getCurrentCast()) {
                		sharkEscape.root.getChildren().remove(currentCast.getSpriteFrame());
                    }
                	sharkEscape.choreographer.resetCurrentCast();
                	sharkEscape.loadSceneMap();
                	sharkEscape.score1 = 0;
                	sharkEscape.score2 = 0;
                	sharkEscape.conflict1 = 0;
                	sharkEscape.conflict2 = 0;
                	sharkEscape.scoreLabel1.setText(Integer.toString(sharkEscape.score1));
                	sharkEscape.scoreLabel2.setText(Integer.toString(sharkEscape.score2));
                	sharkEscape.conflictLabel1.setText(Integer.toString(sharkEscape.conflict1));
                	sharkEscape.conflictLabel2.setText(Integer.toString(sharkEscape.conflict2));
                	sharkEscape.keys.clear();
                	sharkEscape.playerLoader.player.spriteFrame.setTranslateX(280);
                	sharkEscape.playerLoader.player.spriteFrame.setTranslateY(300);
                	sharkEscape.playerLoader.mplayer.spriteFrame.setTranslateX(280);
                	sharkEscape.playerLoader.mplayer.spriteFrame.setTranslateY(400);
                	sharkEscape.playerLoader.player.spriteFrame.setImage(sharkEscape.playerLoader.player.imageStates.get(0));
            		sharkEscape.playerLoader.mplayer.spriteFrame.setImage(sharkEscape.playerLoader.mplayer.imageStates.get(0));
            		sharkEscape.playerLoader.player.spriteFrame.setScaleX(1);
            		sharkEscape.playerLoader.player.spriteFrame.setRotate(0);
            		sharkEscape.playerLoader.mplayer.spriteFrame.setScaleX(1);
            		sharkEscape.playerLoader.mplayer.spriteFrame.setRotate(0);
                	sharkEscape.root.setTranslateX(0);
                	sharkEscape.backGround.setTranslateX(0);
                	sharkEscape.sharkEscapeComplete = false;
            	    sharkEscape.sharkEscapeOver = false;
            	    if (!sharkEscape.singlePlayer) {
            	    	menuRoot.getChildren().removeAll(GameOver, winner, winnerLabel);
            	    } else {
            	    	menuRoot.getChildren().removeAll(GameOver);
            	    }
                	sharkEscape.stage.setScene(menuScene);
                    setSceneEventHandling();
            }
        });
    }
    
    private void instructionSelected() {
        menuRoot.getChildren().add(instructionImg);
        menuScene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ESCAPE) {
                menuRoot.getChildren().remove(instructionImg);
                setSceneEventHandling();
            }
        });
    }
    
    private void creditSelected() {
        menuRoot.getChildren().add(creditsImg);
        menuScene.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.ESCAPE) {
                menuRoot.getChildren().remove(creditsImg);
                setSceneEventHandling();
            }
        });
    }

    public void sharkEscapeRestart() {
    	sharkEscape.sharkEscapeOver = true;
        sharkEscape.sharkEscapeComplete = true;
	    sharkEscape.sharkEscapeLoop.stop();
	    for(Sprite dynamicCast : sharkEscape.choreographer.getDynamicCast()) {
			sharkEscape.root.getChildren().remove(dynamicCast.getSpriteFrame());
	    }
		sharkEscape.choreographer.resetDynamicCast();
		for(Sprite currentCast : sharkEscape.choreographer.getCurrentCast()) {
			sharkEscape.root.getChildren().remove(currentCast.getSpriteFrame());
	    }
		sharkEscape.choreographer.resetCurrentCast();
		sharkEscape.loadSceneMap();
		sharkEscape.score1 = 0;
		sharkEscape.score2 = 0;
		sharkEscape.conflict1 = 0;
		sharkEscape.conflict2 = 0;
		sharkEscape.scoreLabel1.setText(Integer.toString(sharkEscape.score1));
		sharkEscape.scoreLabel2.setText(Integer.toString(sharkEscape.score2));
		sharkEscape.conflictLabel1.setText(Integer.toString(sharkEscape.conflict1));
		sharkEscape.conflictLabel2.setText(Integer.toString(sharkEscape.conflict2));
		sharkEscape.keys.clear();
		sharkEscape.playerLoader.player.spriteFrame.setTranslateX(280);
		sharkEscape.playerLoader.player.spriteFrame.setTranslateY(300);
		sharkEscape.playerLoader.mplayer.spriteFrame.setTranslateX(280);
		sharkEscape.playerLoader.mplayer.spriteFrame.setTranslateY(400);
		sharkEscape.playerLoader.player.spriteFrame.setImage(sharkEscape.playerLoader.player.imageStates.get(0));
		sharkEscape.playerLoader.mplayer.spriteFrame.setImage(sharkEscape.playerLoader.mplayer.imageStates.get(0));
		sharkEscape.playerLoader.player.spriteFrame.setScaleX(1);
		sharkEscape.playerLoader.player.spriteFrame.setRotate(0);
		sharkEscape.playerLoader.mplayer.spriteFrame.setScaleX(1);
		sharkEscape.playerLoader.mplayer.spriteFrame.setRotate(0);
		sharkEscape.root.setTranslateX(0);
		sharkEscape.backGround.setTranslateX(0);
		sharkEscape.sharkEscapeComplete = false;
	    sharkEscape.sharkEscapeOver = false;
		sharkEscape.stage.setScene(menuScene);
	    setSceneEventHandling();
	}

}
