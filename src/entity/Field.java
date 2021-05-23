package entity;

import java.util.Random;

import entity.base.Entity;
import gui.MapSelectPane;
import javafx.scene.image.Image;

public class Field extends Entity{
	public Field(int i,int j) {
		
		super(i,j);
		Random rand=new Random();
		int x;
		if(MapSelectPane.getTheme()==1) {
			x=rand.nextInt(3);
			this.setImageSource("map"+MapSelectPane.getTheme()+"/field"+x+".png");
		}
		else if(MapSelectPane.getTheme()==2){
			x=0;
			this.setImageSource("map"+MapSelectPane.getTheme()+"/field"+x+".png");
		}
		else {
			x=rand.nextInt(5);
			this.setImageSource("map"+MapSelectPane.getTheme()+"/field"+x+".png");
		}
		//this.image=new Image(ClassLoader.getSystemResource("map/field"+x+".png").toString());
		this.symbol="0";
		this.z=99;
	}
	

}
