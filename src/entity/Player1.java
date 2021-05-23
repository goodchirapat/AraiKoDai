package entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;


public class Player1 extends Player{

	public Player1(String name, int hp,int i,int j,char cha) {
		super(name,hp,i,j);
		this.symbol="P1";
		this.setImageSource("character/cha"+cha+"right.png");
		this.setImageLeft(new Image(ClassLoader.getSystemResource("character/cha"+cha+"left.png").toString()));
		this.setImageRight(new Image(ClassLoader.getSystemResource("character/cha"+cha+"right.png").toString()));
		
		// TODO Auto-generated constructor stub
	}

	public void action(KeyCode keycode) {
		// TODO Auto-generated method stub
		if(keycode==KeyCode.D){
			this.move(0, 1);
			this.turnRight();;
		}
		else if(keycode==KeyCode.W){
			this.move(-1,0);
		}
		else if(keycode==KeyCode.A){
			this.move(0,-1);
			this.turnLeft();
		}
		else if(keycode==KeyCode.S){
			this.move(1,0);
		}
		else if(keycode==KeyCode.SPACE){
			this.plantBomb();
		}
	}
}
