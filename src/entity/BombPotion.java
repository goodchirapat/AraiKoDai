package entity;

import entity.base.Entity;
import javafx.scene.image.Image;

public class BombPotion extends Potion{

	public BombPotion(int i,int j) {
		super(i,j);
		this.setImageSource("potion/bluePotion.png");
		this.symbol="+B";
	}
	

}
