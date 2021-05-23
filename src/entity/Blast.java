package entity;

import entity.base.Entity;
import javafx.scene.image.Image;

public class Blast extends Entity{
	public Blast(int i,int j,String effectType) {
		super(i,j);
		if(effectType.equals("P1")) {
			this.setImageSource("bomb/volcano.png");
		}
		else {
			this.setImageSource("bomb/volcano1.png");
		}
		
		this.symbol="X";
		this.z=2;
	}


}
