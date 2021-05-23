package entity;

import java.util.Random;

import gui.MapSelectPane;
import javafx.scene.image.Image;

public class BreakableWall  extends Wall{
	public BreakableWall(int i,int j) {
		super(i,j);
		Random rand=new Random();
		int x;
		if(MapSelectPane.getTheme()==1) {
			x=rand.nextInt(3);
			this.setImageSource("map"+MapSelectPane.getTheme()+"/tree"+x+".png");
		}
		else if(MapSelectPane.getTheme()==2){
			x=0;
			this.setImageSource("map"+MapSelectPane.getTheme()+"/tree"+x+".png");
		}
		else {
			x=0;
			this.setImageSource("map"+MapSelectPane.getTheme()+"/wall"+x+".png");
		}
		//this.image=new Image(ClassLoader.getSystemResource("map/tree"+x+".png").toString());
		this.symbol="BW";
		this.z=0;
	}
}
