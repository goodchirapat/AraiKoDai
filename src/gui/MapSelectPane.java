package gui;

import exception.NotSelectedException;
import application.Main;
import drawing.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import logic.GameMap;

public class MapSelectPane extends AnchorPane{
	
	private BackgroundImage background;
	private Font bitFont ;
	private Font bitFont40 ;
	private Button b1;
	private Button b2;
	private Button b3;
	private Button confirmbt;
	private boolean isb1Selected=false;
	private boolean isb2Selected=false;
	private boolean isb3Selected=false;
	private boolean isGameEnd=false;
	private Label label;
	private Image map1;
	private ImageView mapImageView1;
	private Image map2;
	private ImageView mapImageView2;
	private Image map3;
	private ImageView mapImageView3;
	private static int theme;
	public static Scene scene;
	private AudioClip buttonSound ;
	private AudioClip endSound ;
	private GameScreen gameScreen;
	
	public MapSelectPane() {
		this.setPrefHeight(720);
		this.setPrefWidth(1280);
		
		bitFont = StartPane.getBitFont();
		bitFont40 = StartPane.getBitFont40();
		buttonSound =new AudioClip(ClassLoader.getSystemResource("sound/buttonclick.mp3").toString());
		endSound =new AudioClip(ClassLoader.getSystemResource("sound/endSound.wav").toString());
		background = new BackgroundImage(new Image("pane/mapselectbg.png", 1280, 720, false, true), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		initializeButton();
		label = new Label("Map");
		map3 = new Image(ClassLoader.getSystemResource("pane/map3pane.png").toString());
		mapImageView3 = new ImageView(map3);
		map2 = new Image(ClassLoader.getSystemResource("pane/map2pane.png").toString());
		mapImageView2 = new ImageView(map2);
		map1 = new Image(ClassLoader.getSystemResource("pane/map1pane.png").toString());
		mapImageView1 = new ImageView(map1);
		
		label.setFont(bitFont40);
		this.setBackground(new Background(background));
		this.getChildren().addAll(label,confirmbt,b1,b2,b3,mapImageView1,mapImageView2,mapImageView3);
		
		setPosition();
	}
	
	public void initializeButton() {
		b1 = new Button("Choose");
		b2 = new Button("Choose");
		b3 = new Button("Choose");
	    confirmbt = new Button("Confirm");
		
		setButton(b1);
	    setButton(b2);
	    setButton(b3);
	    setButton(confirmbt);
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonSound.play();
				unhighlight(b2,b3);
				highlight(b1);
				isb1Selected=true;
				isb2Selected=false;
				isb3Selected=false;
			
			}
		});
		
	
		
		b2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonSound.play();
				unhighlight(b1,b3);
				highlight(b2);
				isb2Selected=true;
				isb1Selected=false;
				isb3Selected=false;
				
			}
		});
		
		
	
		b3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonSound.play();
				unhighlight(b1,b2);
				highlight(b3);
				isb3Selected=true;
				isb1Selected=false;
				isb2Selected=false;
				
			}
		});
		
		
		
	
		confirmbt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				buttonSound.play();
				if (isb1Selected) {
					setTheme(1);
				} else if (isb2Selected) {
					setTheme(2);
				} else if (isb3Selected) {
					setTheme(3);
				}
				initializeGameStart();
				
			}
		});
		

	}
	
	public 	void initializeGameStart() {
		try {
		
			if((isb1Selected || isb2Selected || isb3Selected ) ) {
					
			gameScreen= new GameScreen(1200,900,theme);
			StatusPane statuspane= new StatusPane();
			HBox root = new HBox(); 
			Scene scene = new Scene(root);
			root.getChildren().add(statuspane);
			root.getChildren().add(gameScreen);
			Main.setWindow(scene);
			gameScreen.requestFocus();
			Main.window.setX(200);
			Main.window.setY(50);
			Main.window.show();
			gameScreen.update();
		
		
		AnimationTimer animation = new AnimationTimer() {
			public void handle(long now) {
				gameScreen.update();
				statuspane.draw(now);
				AnimationTimer x=this;
				if(GameMap.isEnd() && !isGameEnd) {
					endSound.setVolume(2.0d);
					endSound.play();
					Thread wait =new Thread(new Runnable() {
						public void run() {
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							x.stop();
							Platform.runLater(new Runnable() {
								public void run() {
									endGame();
								}
							});   
							}
						}
					);
					wait.start();
					isGameEnd=true;
					
				}
			}
		};
	    animation.start();}
		else {
			throw new NotSelectedException(this);
		}
		}catch(NotSelectedException e){

		}
	}
	
	public void handedCursor(Button bt) {
		bt.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				CharacterP2Pane.scene.setCursor(Cursor.HAND);
			}
			
		});
		bt.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				CharacterP2Pane.scene.setCursor(Cursor.DEFAULT);
			}
			
		});
		
	}
	
	public void endGame() {
		EndGamePane endgame =  new EndGamePane(GameMap.player1Win());
		HBox root = new HBox();
		scene = new Scene(root);
		root.getChildren().add(endgame);
		Main.setWindow(scene);
		Main.window.setX(300);
		Main.window.setY(150);
		Main.window.show();
	}
	
	public void highlight(Button button) {
		// TODO 
		button.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void unhighlight(Button button1,Button button2) {
		// TODO
		button1.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		button2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
	}
	
	public void setButton(Button bt) {
		bt.setFont(bitFont);
		bt.setPrefSize(150, 50);
		handedCursor(bt);
		if(!(bt==confirmbt)) bt.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void setPosition() {
		
		MapSelectPane.setLeftAnchor(label, 570d);
		MapSelectPane.setTopAnchor(label, 100d);

		MapSelectPane.setLeftAnchor(mapImageView1,  70d);
		MapSelectPane.setTopAnchor(mapImageView1, 200d);
		
		MapSelectPane.setLeftAnchor(mapImageView2,  470d);
		MapSelectPane.setTopAnchor(mapImageView2, 200d);
		
		MapSelectPane.setRightAnchor(mapImageView3,  70d);
		MapSelectPane.setTopAnchor(mapImageView3, 200d);
		
		MapSelectPane.setLeftAnchor(b1, 150d);
		MapSelectPane.setTopAnchor(b1, 550d);
		
		MapSelectPane.setLeftAnchor(b2, 575d);
		MapSelectPane.setTopAnchor(b2, 550d);
		
		MapSelectPane.setRightAnchor(b3, 150d);
		MapSelectPane.setTopAnchor(b3, 550d);
		
		MapSelectPane.setLeftAnchor(confirmbt, 575d);
		MapSelectPane.setTopAnchor(confirmbt, 640d);
		
	}
	
	public static int getTheme() {
		return theme;
	}
	
	public static void setTheme(int i) {
			theme=i;
	}

	public  boolean isb1Selected() {
		return isb1Selected;
	}

	public  boolean isb2Selected() {
		return isb2Selected;
	}

	public  boolean isb3Selected() {
		return isb3Selected;
	}

	
	
}
	
