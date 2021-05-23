package gui;

import application.Main;
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
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HowToPlayPane extends AnchorPane{
	private Label label;
	private Label p1;
	private Label p2;
	private Image wasdkeyIm;
	private ImageView wasdIv;
	private Image arrowkeyIm;
	private ImageView arrowkeyIv;
	private Image spacebarIm;
	private ImageView spacebarIv;
	private Image enterIm;
	private ImageView enterIv;
	private Font bitFont40  ;
	private Font bitFont  ;
	private Button returnbt;
	private AudioClip buttonsound ;

	
	public HowToPlayPane() {
		this.setPrefHeight(720);
		this.setPrefWidth(1280);
		bitFont40 = StartPane.getBitFont40();
		bitFont = StartPane.getBitFont();
		buttonsound =new AudioClip(ClassLoader.getSystemResource("sound/buttonclick.mp3").toString());
		label = new Label("How to play!");
		returnbt = new Button("Back");
		p1 = new Label("P1");
		p2 = new Label("P2");
		label.setFont(bitFont40);
		returnbt.setFont(bitFont);
		p1.setFont(bitFont40);
		p1.setTextFill(Color.BLUE);
		p2.setFont(bitFont40);
		p2.setTextFill(Color.RED);
		initializeImage();
		
		returnbt.setPrefSize(150, 50);
		
		handedCursor(returnbt);
		returnbt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				  buttonsound.play();
				  returnToMainmenu();
			}
		});
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.getChildren().addAll(p1,p2,label,wasdIv,arrowkeyIv,spacebarIv,enterIv,returnbt);
		
		
		setPosition();
	}
	
	public void initializeImage() {
		
		wasdkeyIm  = new Image(ClassLoader.getSystemResource("Pane/wasd.png").toString());
		arrowkeyIm = new Image(ClassLoader.getSystemResource("Pane/arrowkey.png").toString());
		spacebarIm = new Image(ClassLoader.getSystemResource("Pane/Spacebar.png").toString());
		enterIm = new Image(ClassLoader.getSystemResource("Pane/Enter.png").toString());
		wasdIv = new ImageView();
		wasdIv.setImage(wasdkeyIm);
		arrowkeyIv = new ImageView();
		arrowkeyIv.setImage(arrowkeyIm);
		spacebarIv = new ImageView();
		spacebarIv.setImage(spacebarIm);
		enterIv = new ImageView();
		enterIv.setImage(enterIm);
		
	}
	
	public void handedCursor(Button bt) {
		bt.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				StartPane.scene.setCursor(Cursor.HAND);
			}
			
		});
		bt.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				StartPane.scene.setCursor(Cursor.DEFAULT);
			}
			
		});
		
	}
	
	public void returnToMainmenu() {
		Main.startPane = new StartPane(false);
		HBox root = new HBox();
		root.getChildren().add(Main.startPane);
		Main.setWindow(Main.scene);
		Main.window.setX(500);
		Main.window.show();
	}
	
	public void setPosition() {
		HowToPlayPane.setLeftAnchor(label, 400d);
		HowToPlayPane.setTopAnchor(label, 50d);
		
		HowToPlayPane.setLeftAnchor(p1, 50d);
		HowToPlayPane.setTopAnchor(p1, 220d);
		
		HowToPlayPane.setLeftAnchor(p2, 50d);
		HowToPlayPane.setTopAnchor(p2, 420d);
		
		HowToPlayPane.setLeftAnchor(wasdIv, 250d);
		HowToPlayPane.setTopAnchor(wasdIv,150d);
		
		HowToPlayPane.setLeftAnchor(arrowkeyIv, 240d);
		HowToPlayPane.setTopAnchor(arrowkeyIv, 350d);
		
		HowToPlayPane.setRightAnchor(spacebarIv, 100d);
		HowToPlayPane.setTopAnchor(spacebarIv,200d);
		
		HowToPlayPane.setRightAnchor(enterIv, 200d);
		HowToPlayPane.setTopAnchor(enterIv,370d);
		
		HowToPlayPane.setLeftAnchor(returnbt, 50d);
		HowToPlayPane.setTopAnchor(returnbt, 50d);
	}

}
