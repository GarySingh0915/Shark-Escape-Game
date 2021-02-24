# Shark-Escape-Game
Introduction to JavaFX for Game Development

JavaFX is a cross platform GUI toolkit, which is actually successor to the Java Swing libraries. In this presentation, I will present the features of JavaFX that makes programming games in Java a real fun and enjoyable experience, while learning the advanced Java programming  concepts.

Installation

As we are already developing applications with Java, so we don't need to download any other special JAR’s at all, as JavaFX comes included with the standard JDK (Java Development Kit) bundle, so no special separate installation needed. We can directly jump to code development for our game using JavaFX, compile the same and run the game classes, either using Eclipse or BlueJ.

Basic Framework Classes

To create a game using JavaFX framework, we need to first create the main class (SharkEscape.java) by extending it from Application class, and then calling its launch() method, which in-turn calls the init() method, followed by start() method. We need to next override the start() method as it is the only abstract method in Application class. 

Most of the work is mainly done in the start() method, where we use various classes like Stage, Scene, Group, AnimationTimer, Timeline, KeyCode, AudioClip, Label, Image, ImageView, Color, Background, Vbox, etc. to create, process and handle the game scene as well as multiple objects that are part of the scene. I will talk more about these classes in subsequent slides.

Graphics Processing – Scene & Stage Setup

Stage class helps in creating the main window of the game. It is the top level JavaFX container and the Application class passes an initial stage to its start() method. Stage class can be used to set the window title, icon, visibility, size, etc. Other content is added to Stage and then its show() method is called to display the window. 

Content like UI controls, images, text, background, etc are organized in a tree like structure containing Root, Group, parent and children nodes, before adding it to Scene class. Once all content is added to the Scene, it is then set to show in the Stage.
We will understand all these in more detail in later slides using SharkEscape game’s code snippets examples.

Graphics Processing – Animation Setup
After all content is added to Scene class, AnimationTimer class can be used to make the game content dynamic by changing its state over time. Using this class, we can implement a infinite game loop to update the game objects (images, text, UI controls) and rendering the scene to the screen, multiple times per second to create the illusion of movement. All the objects can be moved, transformed, resized, rotated, etc at node level or Group Level or at Root Level using functions like setTranslateX(), setTranslateY(), setRotate(), setScaleX(), setScaleY(), setImage(), etc. 
We will understand all these in more detail in later slides using SharkEscape game’s code snippets examples.
