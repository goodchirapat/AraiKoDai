package entity.base;


import javafx.scene.image.Image;
import logic.Cell;
import logic.GameMap;

public abstract class Entity {
	protected String symbol;
	protected Image image;
	protected int i,j,z;
	protected Cell myCell;
	
	
	public Entity(int i,int j) {
		setI(i);
		setJ(j);
		updateMyCell();
	}
	
	public void updateMyCell() {
		this.myCell=GameMap.getCells()[this.i][this.j];
	}
	
	public void remove() {
		this.myCell.remove(this.symbol);
	}
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setImageSource(String source) {
		this.image=new Image(ClassLoader.getSystemResource(source).toString());
	}
}
