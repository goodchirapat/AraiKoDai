package entity;

import entity.base.Entity;
import javafx.scene.image.Image;

public class ImmortalPotion extends Potion{
	public ImmortalPotion(int i,int j) {
		super(i,j);
		this.setImageSource("potion/star.png");
		this.symbol="*";
	}


}
