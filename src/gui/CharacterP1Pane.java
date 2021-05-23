package gui;


import exception.NotSelectedException;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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


public class CharacterP1Pane extends AnchorPane{
	
	private BackgroundImage bg;
	private Image char1;
	private static ImageView imageView1;
	private Image char2;
	private static ImageView imageView2;
	private Image char3;
	private static ImageView imageView3;
	private Image char4;
	private static ImageView imageView4;
	private Image headLine;
	private ImageView imageView0;
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private Button confirmbt;
	private TextField textField ;
	private static String name;
	private Font bitfont;
	private  boolean isb1Selected;
	private  boolean isb2Selected;
	private  boolean isb3Selected;
	private  boolean isb4Selected;
	private static char picsymbol;
	public static Scene scene;
	private AudioClip buttonsound ;
	
	public CharacterP1Pane() {
		
		this.setPrefHeight(720);
		this.setPrefWidth(1280);
		
		isb1Selected=false;
		isb2Selected=false;
		isb3Selected=false;
		isb4Selected=false;
		
		bg = new BackgroundImage(new Image("pane/background.jpg",1280,720,false,true),
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		textField = new TextField("name");
		bitfont = StartPane.getBitFont();
		buttonsound =new AudioClip(ClassLoader.getSystemResource("sound/buttonclick.mp3").toString());
		initializeImage();
		initializeButtonch();
		this.setBackground(new Background(bg));	
		textField.setPrefSize(200, 40);
		textField.setFont(bitfont);
		textField.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				buttonsound.play();
				textField.setText("");
				
			}
		});
		this.getChildren().addAll(imageView0,confirmbt,textField,imageView1,imageView2,imageView3,imageView4,b1,b2,b3,b4);
		setPosition();
		
		
	}
	
	public void initializeImage() {
		
		headLine = new Image(ClassLoader.getSystemResource("pane/player1.png").toString());
		imageView0 = new ImageView();
		imageView0.setImage(headLine);
		
		char1 = new Image(ClassLoader.getSystemResource("pane/cha1.png").toString());
		imageView1 = new ImageView();
		imageView1.setImage(char1);
		
		char2 = new Image(ClassLoader.getSystemResource("pane/cha2.png").toString());
		imageView2 = new ImageView();
		imageView2.setImage(char2);
		
		char3 = new Image(ClassLoader.getSystemResource("pane/cha3.png").toString());
		imageView3 = new ImageView();
		imageView3.setImage(char3);
		
		char4 = new Image(ClassLoader.getSystemResource("pane/cha4.png").toString());
		imageView4 = new ImageView();
		imageView4.setImage(char4);
	
	}
	
	public void initializeButtonch() {
		b1 = new Button("Choose");
		b2 = new Button("Choose");
		b3 = new Button("Choose");
		b4 = new Button("Choose");
	    confirmbt = new Button("Confirm");
		
	    setButton(b1);
	    setButton(b2);
	    setButton(b3);
	    setButton(b4);
	    setButton(confirmbt);
		
		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonsound.play();
				unhighlight(b4,b2,b3);
				highlight(b1);
				isb1Selected=true;
				isb2Selected=false;
				isb3Selected=false;
				isb4Selected=false;
				
			}
		});
		
		
		b2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonsound.play();
				unhighlight(b1,b4,b3);
				highlight(b2);
				isb2Selected=true;
				isb1Selected=false;
				isb3Selected=false;
				isb4Selected=false;
			}
		});
		
		
		b3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonsound.play();
				unhighlight(b1,b2,b4);
				highlight(b3);
				isb3Selected=true;
				isb1Selected=false;
				isb2Selected=false;
				isb4Selected=false;
			}
		});
		
		
		b4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				buttonsound.play();
				unhighlight(b1,b2,b3);
				highlight(b4);
				isb4Selected=true;
				isb2Selected=false;
				isb1Selected=false;
				isb3Selected=false;
				
			}
		});
		
		confirmbt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				buttonsound.play();
				goToCharP2Pane();
				confirmChar();
			}
		});

	}
	
	
	public void goToCharP2Pane() {
		try {
		
		if((isb1Selected || isb2Selected || isb3Selected || isb4Selected) && !textField.getText().equals("name") && !textField.getText().equals("")) {
			name = textField.getText();
			System.out.println(textField.getText());
			CharacterP2Pane ccp2 = new CharacterP2Pane();
			HBox root = new HBox();
			scene = new Scene(root);
			root.getChildren().add(ccp2);
			Main.setWindow(scene);
			Main.window.show();
		}
		else { 
				throw new NotSelectedException(this);
				
			}
		}catch(NotSelectedException e) {

	   }
	}
	
	public void highlight(Button button) {
		// TODO 
		button.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void unhighlight(Button button1,Button button2,Button button3) {
		// TODO
		button1.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		button2.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		button3.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
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
	
	public void setPosition() {
		
		CharacterP1Pane.setLeftAnchor(textField, 500d);
		CharacterP1Pane.setTopAnchor(textField, 200d);
		
		CharacterP1Pane.setLeftAnchor(imageView0, 450d);
		CharacterP1Pane.setTopAnchor(imageView0, 60d);
		
		CharacterP1Pane.setLeftAnchor(confirmbt, 550d);
		CharacterP1Pane.setTopAnchor(confirmbt, 640d);
		
		CharacterP1Pane.setLeftAnchor(imageView1, 90d);
		CharacterP1Pane.setTopAnchor(imageView1, 300d);
		
		CharacterP1Pane.setLeftAnchor(imageView2, 380d);
		CharacterP1Pane.setTopAnchor(imageView2, 300d);
		
		CharacterP1Pane.setLeftAnchor(imageView3, 700d);
		CharacterP1Pane.setTopAnchor(imageView3, 300d);
		
		CharacterP1Pane.setLeftAnchor(imageView4, 1000d);
		CharacterP1Pane.setTopAnchor(imageView4, 300d);
		
		CharacterP1Pane.setLeftAnchor(b1, 100d);
		CharacterP1Pane.setTopAnchor(b1, 550d);
		
		CharacterP1Pane.setLeftAnchor(b2, 400d);
		CharacterP1Pane.setTopAnchor(b2, 550d);
		
		CharacterP1Pane.setLeftAnchor(b3, 700d);
		CharacterP1Pane.setTopAnchor(b3, 550d);
		
		CharacterP1Pane.setLeftAnchor(b4, 1000d);
		CharacterP1Pane.setTopAnchor(b4, 550d);
		
	}
	
	public void setButton(Button bt) {
		bt.setFont(bitfont);
		bt.setPrefSize(150, 50);
		handedCursor(bt);
		if(!(bt==confirmbt)) bt.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void confirmChar() {
		if (isb1Selected) {
			picsymbol='1';
		} else if (isb2Selected) {
			picsymbol='2';
		} else if (isb3Selected) {
			picsymbol='3';
		} else if (isb4Selected) {
			picsymbol='4';
		}
		
	}
	
	public static String getName() {
		return name;
	}
	
	public TextField getTextfield() {
		return textField;
	}

	public static char getPicsymbol() {
		return picsymbol;
	}

	public boolean isb1Selected() {
		return isb1Selected;
	}

	public boolean isb2Selected() {
		return isb2Selected;
	}

	public boolean isb3Selected() {
		return isb3Selected;
	}

	public boolean isb4Selected() {
		return isb4Selected;
	}
	
	public static ImageView getImage() {
		if(picsymbol=='1') {
			return imageView1;
		}else if(picsymbol=='2') {
			return imageView2;
		}else if(picsymbol=='3') {
			return imageView3;
		}else  {
			return imageView4;
		}
	}

	
	

	
	
	

	
	
	
	

}
