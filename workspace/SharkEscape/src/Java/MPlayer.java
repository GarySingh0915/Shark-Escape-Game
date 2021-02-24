package Java;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class MPlayer extends Sprite implements MNode {
    public static final int TOP_BOUNDARY = 300;
    public static final int LEFT_BOUNDARY = 0;
    public static int RIGHT_BOUNDARY;
    public static final int BOTTOM_BOUNDARY = 600;

    private boolean animation = false;
    
    private final Image fish1, fish2, expl1, expl2, expl3, blade1, blade2, chain1, chain2, drill1, drill2, nut1, nut2;
    private final SceneSprite expl;
    
    private final SharkEscape sharkEscape;
    private final Player player;

    private double ACCLERATION = 4;
    private int frameCounter = 0, frameSpeed = 12;

    public MPlayer(SharkEscape sharkEscape, Player player, double xPosition, double yPosition, Image... imageStates) {
        super(xPosition, yPosition, 0, imageStates);

        this.spriteFrame.setTranslateX(xPosition);
        this.spriteFrame.setTranslateY(yPosition);

        this.sharkEscape = sharkEscape;
        this.player = player;
        
        fish1 = new Image(sharkEscape.uriPath + "Fish1.gif", 64, 30, true, false, true);
        fish2 = new Image(sharkEscape.uriPath + "Fish2.gif", 64, 30, true, false, true);
        expl1 = new Image(sharkEscape.uriPath + "hidden.gif", 64, 64, true, false, true);
        expl2 = new Image(sharkEscape.uriPath + "explosion1.gif", 64, 64, true, false, true);
        expl3 = new Image(sharkEscape.uriPath + "explosion2.gif", 64, 64, true, false, true);
        blade1 = new Image(sharkEscape.uriPath + "Blade1.gif", 64, 64, true, false, true);
        blade2 = new Image(sharkEscape.uriPath + "Blade2.gif", 64, 64, true, false, true);
        chain1 = new Image(sharkEscape.uriPath + "Chain1.gif", 64, 64, true, false, true);
        chain2 = new Image(sharkEscape.uriPath + "Chain2.gif", 64, 64, true, false, true);
        drill1 = new Image(sharkEscape.uriPath + "Drill1.gif", 64, 64, true, false, true);
        drill2 = new Image(sharkEscape.uriPath + "Drill2.gif", 64, 64, true, false, true);
        nut1 = new Image(sharkEscape.uriPath + "Drilling1.gif", 64, 64, true, false, true);
        nut2 = new Image(sharkEscape.uriPath + "Drilling2.gif", 64, 64, true, false, true);
        
        expl = new SceneSprite(xPosition, yPosition, 0, expl1);
        sharkEscape.root.getChildren().add(expl.getSpriteFrame());
        RIGHT_BOUNDARY = sharkEscape.oceanWidth;
    }

@Override
    public void Update() {
		if ((sharkEscape.isKeyPressed(KeyCode.ESCAPE))) {
			sharkEscape.menu.sharkEscapeRestart();
		}
        setImageStates();
        setMovement();
        if (spriteFrame.getTranslateX() >= player.spriteFrame.getTranslateX()) {
        	setScroller();
        } else {
        	player.setScroller();
        }
    }

    private void setImageStates() {
    	
        if (!animation) {
            if (frameCounter >= frameSpeed) {
            	spriteFrame.setImage(imageStates.get(0));
            	expl.spriteFrame.setImage(expl1);
                animation = true;
                frameCounter = 0;
            } else {
                frameCounter++;
            }
        } else if (animation) {
            if (frameCounter >= frameSpeed) {
            	spriteFrame.setImage(imageStates.get(1));
                animation = false;
                frameCounter = 0;
            } else {
                frameCounter++;
            }
        }
    	
        if (!sharkEscape.singlePlayer || spriteFrame.getTranslateX() > player.spriteFrame.getTranslateX() + 400) {
	        for (int i = 0; i < sharkEscape.choreographer.getCurrentCast().size(); i++) {
	
	            Sprite currentCast = sharkEscape.choreographer.getCurrentCast().get(i);
	            if (currentCast.spriteFrame.getTranslateX() < spriteFrame.getTranslateX() + 400 ||
	            		currentCast.spriteFrame.getTranslateX() > spriteFrame.getTranslateX() - 400) {
		    		if (!animation) {
		                if (frameCounter >= frameSpeed) {
		                	if (currentCast.spriteType == 4) {
		                		currentCast.spriteFrame.setImage(blade1);
		                	} else if (currentCast.spriteType == 5) {
		                		currentCast.spriteFrame.setImage(chain1);
		                	} else if (currentCast.spriteType == 6) {
		                		currentCast.spriteFrame.setImage(drill1);
		                	} else if (currentCast.spriteType == 7) {
		                		currentCast.spriteFrame.setImage(nut1);
		                	}	
		                }
		            } else if (animation) {
		                if (frameCounter >= frameSpeed) {
		                	if (currentCast.spriteType == 4) {
		                		currentCast.spriteFrame.setImage(blade2);
		                	} else if (currentCast.spriteType == 5) {
		                		currentCast.spriteFrame.setImage(chain2);
		                	} else if (currentCast.spriteType == 6) {
		                		currentCast.spriteFrame.setImage(drill2);
		                	} else if (currentCast.spriteType == 7) {
		                		currentCast.spriteFrame.setImage(nut2);
		                	}	
		                }
		            }
		        }
	    	}
        
        
	    	for (int i = 0; i < sharkEscape.choreographer.getDynamicCast().size(); i++) {
	
	            Sprite dynamicCast = sharkEscape.choreographer.getDynamicCast().get(i);
	            if (dynamicCast.spriteFrame.getTranslateX() < spriteFrame.getTranslateX() + 400 ||
	            		dynamicCast.spriteFrame.getTranslateX() > spriteFrame.getTranslateX() - 400) {
		    		if (!animation) {
		                if (frameCounter >= frameSpeed) {
		                	dynamicCast.spriteFrame.setImage(fish1);
		                }
		            } else if (animation) {
		                if (frameCounter >= frameSpeed) {
		                	dynamicCast.spriteFrame.setImage(fish2);
		                }
		            }
		        }
	    	}
        }

        if ((sharkEscape.isKeyPressed(KeyCode.D) && !sharkEscape.isKeyPressed(KeyCode.W) && !sharkEscape.isKeyPressed(KeyCode.S)) 
        || (!sharkEscape.isKeyPressed(KeyCode.D) && !sharkEscape.isKeyPressed(KeyCode.A) 
    			&& !sharkEscape.isKeyPressed(KeyCode.W) && !sharkEscape.isKeyPressed(KeyCode.S))) {
                if (frameCounter >= frameSpeed) {
                    spriteFrame.setScaleX(1);
                    spriteFrame.setRotate(0);
                }
        }//Right (and OR condition for No key pressed)

        if (sharkEscape.isKeyPressed(KeyCode.A) && !sharkEscape.isKeyPressed(KeyCode.W) && !sharkEscape.isKeyPressed(KeyCode.S)) {
                if (frameCounter >= frameSpeed) {
                    spriteFrame.setScaleX(-1);
                    spriteFrame.setRotate(0);
                }
        }//Left

        if (sharkEscape.isKeyPressed(KeyCode.D) && sharkEscape.isKeyPressed(KeyCode.W)) {
                if (frameCounter >= frameSpeed) {
                    spriteFrame.setScaleX(1);
                    spriteFrame.setRotate(315);
                }
        }//Right and UP

        if (sharkEscape.isKeyPressed(KeyCode.A) && sharkEscape.isKeyPressed(KeyCode.W)) {
                if (frameCounter >= frameSpeed) {
                    spriteFrame.setScaleX(-1);
                    spriteFrame.setRotate(45);
                }
        }//Left and UP
        
        if (sharkEscape.isKeyPressed(KeyCode.W) && !sharkEscape.isKeyPressed(KeyCode.A) && !sharkEscape.isKeyPressed(KeyCode.D)) {
                if (frameCounter >= frameSpeed) {
                    spriteFrame.setScaleX(1);
                    spriteFrame.setRotate(270);
                }
        }/*UP*/ 
        
        if (sharkEscape.isKeyPressed(KeyCode.D) && sharkEscape.isKeyPressed(KeyCode.S)) {
                if (frameCounter >= frameSpeed) {
                    spriteFrame.setScaleX(1);
                    spriteFrame.setRotate(45);
                }
        }//Right and DOWN

        if (sharkEscape.isKeyPressed(KeyCode.A) && sharkEscape.isKeyPressed(KeyCode.S)) {
                if (frameCounter >= frameSpeed) {
                    spriteFrame.setScaleX(-1);
                    spriteFrame.setRotate(315);
                }
        }//Left and DOWN
        
        if (sharkEscape.isKeyPressed(KeyCode.S) && !sharkEscape.isKeyPressed(KeyCode.A) && !sharkEscape.isKeyPressed(KeyCode.D)) {
                if (frameCounter >= frameSpeed) {
                    spriteFrame.setScaleX(1);
                    spriteFrame.setRotate(90);
                }
        }//DOWN and RIGHT

    }//setImageStates

    private void setMovement() {

        if (sharkEscape.isKeyPressed(KeyCode.A)) {
            moveMPlayerX(-2 * SPEED);
        }

        if (sharkEscape.isKeyPressed(KeyCode.D)) {
            moveMPlayerX(2 * SPEED);
        }
        
        if (sharkEscape.isKeyPressed(KeyCode.W)) {
        	moveMPlayerY(-2 * SPEED);
        }

        if (sharkEscape.isKeyPressed(KeyCode.S)) {
        	moveMPlayerY(2 * SPEED);
        }

    }//setMovement

    private void moveMPlayerX(int value) {
        boolean movingRight = value > 0;
        for (int i = 0; i < Math.abs(value) + ACCLERATION; i++) {
            for (Sprite currentCast : sharkEscape.choreographer.getCurrentCast()) {
                if (spriteFrame.getBoundsInParent().intersects(currentCast.getSpriteFrame().getBoundsInParent())) {
                	sharkEscape.conflict2++;
                	sharkEscape.conflictLabel2.setText(Integer.toString(sharkEscape.conflict2));
                    if (movingRight) {
                        if (spriteFrame.getTranslateX() + 145 == currentCast.spriteFrame.getTranslateX()) {
                            spriteFrame.setTranslateX(spriteFrame.getTranslateX() - 1);
                            expl.spriteFrame.setTranslateX(spriteFrame.getTranslateX() + 145);
                            expl.spriteFrame.setTranslateY(spriteFrame.getTranslateY());
                            expl.spriteFrame.setImage(expl2);
                           return;
                        }
                        if (spriteFrame.getTranslateX() + 115 == currentCast.spriteFrame.getTranslateX()) {
                            spriteFrame.setTranslateX(spriteFrame.getTranslateX() - 30);
                            expl.spriteFrame.setTranslateX(spriteFrame.getTranslateX() + 115);
                            expl.spriteFrame.setTranslateY(spriteFrame.getTranslateY());
                            expl.spriteFrame.setImage(expl3);
                           return;
                        }
                    } else {
                        if (spriteFrame.getTranslateX() == currentCast.spriteFrame.getTranslateX() + 64) {
                            spriteFrame.setTranslateX(spriteFrame.getTranslateX() + 1);
                            expl.spriteFrame.setTranslateX(spriteFrame.getTranslateX() - 64);
                            expl.spriteFrame.setTranslateY(spriteFrame.getTranslateY());
                            expl.spriteFrame.setImage(expl2);
                            return;
                        }
                        if (spriteFrame.getTranslateX() == currentCast.spriteFrame.getTranslateX() + 34) {
                            spriteFrame.setTranslateX(spriteFrame.getTranslateX() + 30);
                            expl.spriteFrame.setTranslateX(spriteFrame.getTranslateX() - 34);
                            expl.spriteFrame.setTranslateY(spriteFrame.getTranslateY());
                            expl.spriteFrame.setImage(expl3);
                            return;
                        }
                    }
                }
            }

            if (spriteFrame.getTranslateX() <= LEFT_BOUNDARY) {
                spriteFrame.setTranslateX(LEFT_BOUNDARY);
            }

            if (sharkEscape.conflict2 >= sharkEscape.maxConflictCount) {
            	if (!sharkEscape.sharkEscapeOver) {
            		sharkEscape.playerLoader.playerWinner = true;
            		sharkEscape.sharkEscapeOver = true;
            		sharkEscape.menu.sharkEscapeOver();
            	}
            } else if (spriteFrame.getTranslateX() >= sharkEscape.oceanWidth - 30 && 
            			spriteFrame.getTranslateX() > player.spriteFrame.getTranslateX()) {
            				spriteFrame.setTranslateX(sharkEscape.oceanWidth - 30);
            				sharkEscape.playerLoader.playerWinner = false;
            				if (!sharkEscape.sharkEscapeComplete) {
            					sharkEscape.sharkEscapeComplete = true;
            					sharkEscape.menu.sharkEscapeComplete();
            				}
            		} else {
            			spriteFrame.setTranslateX(spriteFrame.getTranslateX() + (movingRight ? 1 : -1));
            		}

        }//Main Loop
        
        upScore();
        
    } //MoveX

    private void moveMPlayerY(double value) {
        boolean movingDown = value > 0;
        for (int i = 0; i < Math.abs(value); i++) {
            for (Sprite currentCast : sharkEscape.choreographer.getCurrentCast()) {
                if (spriteFrame.getBoundsInParent().intersects(currentCast.getSpriteFrame().getBoundsInParent())) {
                	sharkEscape.conflict2++;
                	sharkEscape.conflictLabel2.setText(Integer.toString(sharkEscape.conflict2));
                    if (movingDown) {
                        if ((spriteFrame.getTranslateY()) + 49 == currentCast.spriteFrame.getTranslateY()) {
                            spriteFrame.setTranslateY(spriteFrame.getTranslateY() - 1);
                            expl.spriteFrame.setTranslateX(spriteFrame.getTranslateX());
                            expl.spriteFrame.setTranslateY(spriteFrame.getTranslateY() + 49);
                            expl.spriteFrame.setImage(expl2);
                            return;
                        }
                    }
                    else {
                    	if ((spriteFrame.getTranslateY()) - 64 == currentCast.spriteFrame.getTranslateY()) {
                            spriteFrame.setTranslateY(spriteFrame.getTranslateY() + 1);
                            expl.spriteFrame.setTranslateX(spriteFrame.getTranslateX());
                            expl.spriteFrame.setTranslateY(spriteFrame.getTranslateY() - 64);
                            expl.spriteFrame.setImage(expl3);
                            return;
                        }
                    }
                }
            }
            
            if (sharkEscape.conflict2 >= sharkEscape.maxConflictCount) {
            	if (!sharkEscape.sharkEscapeOver) {
            		sharkEscape.playerLoader.playerWinner = true;
            		sharkEscape.sharkEscapeOver = true;
            		sharkEscape.menu.sharkEscapeOver();
            	}
            } else {
            	spriteFrame.setTranslateY(spriteFrame.getTranslateY() + (movingDown ? 1 : -1));
            }
            
        }//MainLoop
        
        upScore();
        
    }//MoveY

    private void upScore() {

        for (int i = 0; i < sharkEscape.choreographer.getDynamicCast().size(); i++) {

            Sprite tempSprite = sharkEscape.choreographer.getDynamicCast().get(i);
            
            if (colFish(tempSprite)) {

                sharkEscape.score2 += 1;
                sharkEscape.scoreLabel2.setText(Integer.toString(sharkEscape.score2));
                sharkEscape.choreographer.addToRemoveSprites(tempSprite);
                sharkEscape.root.getChildren().remove(tempSprite.getSpriteFrame());
                sharkEscape.choreographer.resetRemovedSprites();
            }
           
        }

    }

    private boolean colFish(Sprite tempSprite) {

        return spriteFrame.getBoundsInParent().intersects(tempSprite.getSpriteFrame().getBoundsInParent());
    } // colFish
    
    
        
    

    private void setScroller() {
        spriteFrame.translateXProperty().addListener((v, oldValue, newValue) -> {

            int offSet = newValue.intValue();
            if (offSet > 400 && offSet < sharkEscape.oceanWidth - 400) {

                sharkEscape.root.setTranslateX(-(offSet - 400));
                sharkEscape.backGround.setTranslateX(-(offSet - 400));
            }
        });     

    } //Scroller

}//Class
