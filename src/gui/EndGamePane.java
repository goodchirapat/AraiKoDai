package gui;

import application.Main;
import gui.CharacterP1Pane;
import entity.Player1;
import entity.Player2;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import logic.GameMap;

public class EndGamePane extends AnchorPane {
	private BackgroundImage bg;
	private Font bitFont40 ;
	private Font bitFont ;
	private Label label ;
	private Button back ;
	private Button exitbt ;
	private AudioClip buttonSound;
	private ImageView image;

	
	public EndGamePane(boolean isP1Wins) {
		
		bitFont40 = StartPane.getBitFont40();
		bitFont = StartPane.getBitFont();
		label = new Label();
		back = new Button("Return to main menu");
		exitbt = new Button("Exit");
		buttonSound =new AudioClip(ClassLoader.getSystemResource("sound/buttonclick.mp3").toString());;
		
		if(isP1Wins) {
			whenP1Wins();
		}else {
			whenP2Wins();
		}
		
	}
	
	public void whenP2Wins() {
		this.setPrefHeight(720);
		this.setPrefWidth(1280);
		bg = new BackgroundImage(new Image("pane/congrat2.jpg",1280,720,false,true),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		this.setBackground(new Background(bg));
		label.setText("Player 2 wins");
		label.setFont(bitFont40);
		back.setFont(bitFont);
		back.setPrefHeight(50);
		handedCursor(back);
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				buttonSound .play();
				returnToMainmenu();
			}
		});
		exitbt.setFont(bitFont);
		exitbt.setPrefHeight(50);
		handedCursor(exitbt);
		exitbt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				 System.exit(0);
			}
		});
		image = CharacterP2Pane.getImage();
		this.getChildren().addAll(label,back,exitbt,image);
		setPosition();
	}
	
	public void whenP1Wins() {
		this.setPrefHeight(720);
		this.setPrefWidth(1280);
		bg = new BackgroundImage(new Image("pane/congrat1.jpg",1280,720,false,true),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		this.setBackground(new Background(bg));
		label.setText("Player 1 wins");
		label.setFont(bitFont40);
		back.setFont(bitFont);
		back.setPrefHeight(50);
		handedCursor(back);
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				buttonSound .play();
				 returnToMainmenu();
			}
		});
		exitbt.setFont(bitFont);
		exitbt.setPrefHeight(50);
		handedCursor(exitbt);
		exitbt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				 System.exit(0);
			}
		});
		image = CharacterP1Pane.getImage();
		this.getChildren().addAll(label,back,exitbt,image);
		setPosition();
	}
	
	public void returnToMainmenu() {
		Main.startPane = new StartPane(false);
		Main.setWindow(Main.scene);
		Main.window.setX(500);
		Main.window.show();
	}
	
	public void handedCursor(Button bt) {
		bt.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				MapSelectPane.scene.setCursor(Cursor.HAND);
			}
			
		});
		bt.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				MapSelectPane.scene.setCursor(Cursor.DEFAULT);
			}
			
		});
		
	}
	
	public void setPosition() {
		EndGamePane.setLeftAnchor(label, 370d);
		EndGamePane.setTopAnchor(label, 50d);
		EndGamePane.setLeftAnchor(back, 300d);
		EndGamePane.setBottomAnchor(back, 50d);
		EndGamePane.setLeftAnchor(exitbt, 750d);
		EndGamePane.setBottomAnchor(exitbt, 50d);
		EndGamePane.setLeftAnchor(image, 500d);
		EndGamePane.setTopAnchor(image, 250d);
	}

}
