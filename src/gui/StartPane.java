package gui;







import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



public class StartPane extends AnchorPane{
	
	private BackgroundImage background;
	private Button startbt;
	private Button howToPlaybt;
	private Button exitbt;
	private Label startLabel;
	private static Font bitFont;
	private static Font bitFont40;
	public static Scene scene;
	private AudioClip buttonsound;
	private AudioClip backgroundSound;
	
	
	public StartPane(boolean isRepeat) {
	
		this.setPrefHeight(632);
		this.setPrefWidth(808);
		
		buttonsound =new AudioClip(ClassLoader.getSystemResource("sound/buttonclick.mp3").toString());
		bitFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("font/AGoblinAppears-o2aV.ttf"),15);
		bitFont40 = Font.loadFont(ClassLoader.getSystemResourceAsStream("font/AGoblinAppears-o2aV.ttf"),40);
		background = new BackgroundImage(new Image("pane/StartScreen.png",808,632,false,true),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		initializeButton();
		startLabel = new Label("AraiKoDai");
		
		if(isRepeat) {
			playMusic();
		}

		startLabel.setFont(bitFont40);
		startLabel.setTextFill(Color.LIGHTGRAY);
		
		this.setBackground(new Background(background));
		this.getChildren().addAll(startLabel,startbt,howToPlaybt,exitbt);
		
		setPosition();
	}
	
	public void initializeButton() {
		
		startbt = new Button("Start");
		howToPlaybt = new Button("How to Play");
		exitbt = new Button("Exit");
		
		setButton(startbt);
		setButton(howToPlaybt);
		setButton(exitbt);
		
		startbt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonsound.play();
				goToCharP2Pane();
			
			}
		});
		
		howToPlaybt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonsound.play();
				goToHowToPlay();
		
			}
		});
		
		exitbt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonsound.play();
				System.exit(0);
			}
		});
		
	}
	
	
	public void goToCharP2Pane() {
		CharacterP1Pane ccp1=new CharacterP1Pane();
		HBox root = new HBox(); 
		scene = new Scene(root);
		root.getChildren().add(ccp1);
		Main.setWindow(scene);
		Main.window.setX(300);
		Main.window.show();
	}
	
	public void goToHowToPlay() {
		HowToPlayPane ccp1=new HowToPlayPane();
		HBox root = new HBox(); 
		scene = new Scene(root);
		root.getChildren().add(ccp1);
		Main.setWindow(scene);
		Main.window.show();
		Main.window.setX(300);
	}

	
	public void handedCursor(Button bt) {
		bt.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Main.scene.setCursor(Cursor.HAND);
			}
			
		});
		bt.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Main.scene.setCursor(Cursor.DEFAULT);
			}
			
		});
		
	}
	
	public void setPosition() {
		
		StartPane.setTopAnchor(startLabel, 50d);
		StartPane.setRightAnchor(startLabel, 225d);
		
		StartPane.setTopAnchor(startbt, 550d);
		StartPane.setRightAnchor(startbt, 200d);
		
		StartPane.setTopAnchor(howToPlaybt, 550d);
		StartPane.setLeftAnchor(howToPlaybt, 50d);
		
		StartPane.setTopAnchor(exitbt, 550d);
		StartPane.setRightAnchor(exitbt, 30d);
		
	}
	
	public void setButton(Button bt) {
		bt.setFont(bitFont);
		if(bt==howToPlaybt) bt.setPrefSize(200, 50);
		else bt.setPrefSize(145, 50);
		handedCursor(bt);
		
	}
	
	public void playMusic() {
		backgroundSound =new AudioClip(ClassLoader.getSystemResource("sound/bg.mp3").toString());
		backgroundSound.setCycleCount(AudioClip.INDEFINITE);
		backgroundSound.setVolume(0.15);
		backgroundSound.play();
	}
	
	public static Font getBitFont() {
		return bitFont;
	}


	public static Font getBitFont40() {
		return bitFont40;
	}
	
	

	

}
