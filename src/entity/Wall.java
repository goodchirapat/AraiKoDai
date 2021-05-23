package entity;

import java.util.Random;

import entity.base.Entity;
import gui.MapSelectPane;
import javafx.scene.image.Image;
import logic.GameMap;

public class Wall extends Entity{
	public  Wall(int i,int j) {
		super(i,j);
		int x;
		Random rand=new Random();
		if(MapSelectPane.getTheme()==3) {
			x=rand.nextInt(6);
			this.setImageSource("map"+MapSelectPane.getTheme()+"/wall"+x+".png");
		}
		else {
			this.setImageSource("map"+MapSelectPane.getTheme()+"/wall0.png");
		}
		this.symbol="W";
		this.z=0;
	}
}
