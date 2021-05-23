package entity;


import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;


public class Player2 extends Player{

	public Player2(String name, int hp,int i,int j,char cha) {
		super(name, hp,i,j);
		this.symbol="P2";
		this.setImageSource("character/cha"+cha+"right.png");
		//this.image = new Image(ClassLoader.getSystemResource("character/cha"+cha+"right.png").toString());
		this.setImageLeft(new Image(ClassLoader.getSystemResource("character/cha"+cha+"left.png").toString()));
		this.setImageRight(new Image(ClassLoader.getSystemResource("character/cha"+cha+"right.png").toString()));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action(KeyCode keycode) {
		// TODO Auto-generated method stub
		if(keycode==KeyCode.RIGHT){
			this.move(0, 1);
			this.turnRight();
		}
		else if(keycode==KeyCode.UP){
			this.move(-1,0);
		}
		else if(keycode==KeyCode.LEFT){
			this.move(0,-1);
			this.turnLeft();
		}
		else if(keycode==KeyCode.DOWN){
			this.move(1,0);
		}
		else if(keycode==KeyCode.ENTER){
			this.plantBomb();
		}
		if(this.myCell.isDamaged()){	
			this.hpDown();
		}
	}


}
