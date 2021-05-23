package entity;

import entity.base.Entity;
import javafx.scene.image.Image;

public class HpPotion extends Potion{
	public HpPotion(int i,int j) {
		super(i,j);
		this.setImageSource("potion/heart.png");
		this.symbol="+HP";
	}


}
