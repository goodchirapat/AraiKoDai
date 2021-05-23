package entity;

import entity.base.Entity;
import javafx.scene.image.Image;

public class PowerPotion extends Potion{
	public PowerPotion(int i,int j) {
		super(i,j);
		this.setImageSource("potion/mushroom.png");
		this.symbol="+P";
	}



}
