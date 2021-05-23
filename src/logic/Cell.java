package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import entity.Blast;
import entity.Potion;
import entity.BombPotion;
import entity.HpPotion;
import entity.ImmortalPotion;
import entity.PowerPotion;
import entity.base.Entity;

public class Cell {
	private ArrayList<Entity> cellEntities;
	private Comparator<Entity> comparator;
	private boolean isDamaged;
	private int i,j;

	public Cell(int i,int j) {
		this.cellEntities = new ArrayList<Entity>();
		comparator = (Entity o1, Entity o2) -> {
			if (o1.getZ() < o2.getZ())
				return 1;
			return -1;
		};
		isDamaged=false;
		this.i=i;
		this.j=j;
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

	public ArrayList<Entity> getCellEntities() {
		return cellEntities;
	}

	public void add(Entity entity) {
		this.cellEntities.add(entity);
		Collections.sort(cellEntities, comparator);
	}

	public void remove(String symbol) {
		for (int i = 0; i < cellEntities.size(); i++) {
			if (cellEntities.get(i).getSymbol().equals(symbol)) {
				cellEntities.remove(i);
			}
		}
	}

	public int getSize() {
		return cellEntities.size();
	}

	public boolean isWall() {
		return find("W");
	}

	public boolean hasBomb() {
		return find("B");

	}
	public boolean isBreakableWall() {
		return find("BW");
	}
	public boolean isPassable() {
		if(this.isBreakableWall() || this.isWall() || this.hasBomb()) {
			return false;
		}
		return true;
	}

	public void damaged(String effectType) {
		if (!this.isWall()) {
			Cell x = this;
			if (this.isBreakableWall()) {
				this.drop();
			}
			Blast blast=new Blast(x.getI(),x.getJ(),effectType);
			x.add(blast);
			x.isDamaged=true;
			Thread clock = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						
						
						Thread.sleep(2000);
						x.isDamaged=false;
						x.remove("X");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			});
			clock.start();
		}
	}
	public boolean isDamaged() {
		return this.isDamaged;
	}
	public void drop() {
		 this.remove("BW");
		 Random rand = new Random();
	     int x = rand.nextInt(5); 
	     switch(x) {
	     case(0):
	    	break;
	     case(1):
	    	 this.add(new BombPotion(this.getI(),this.getJ()));
	     	break;
	     case(2):
	    	 this.add(new HpPotion(this.getI(),this.getJ()));
	     	break;
	     case(3):
	    	 this.add(new PowerPotion(this.getI(),this.getJ()));
	     	break;
	     case(4):
	    	 this.add(new ImmortalPotion(this.getI(),this.getJ()));
	     	break;
	     }
	}
	public boolean find(String symbol) {
		for (int i = 0; i < this.getCellEntities().size(); i++) {
			if (this.getCellEntities().get(i).getSymbol().equals(symbol)) {
				return true;
			}
		}
		return false;
	}
	public Potion getPotion() {
		for (int i = 0; i < this.getCellEntities().size(); i++) {
			if (this.getCellEntities().get(i).getSymbol().equals("+P")||
					this.getCellEntities().get(i).getSymbol().equals("+HP")||
					this.getCellEntities().get(i).getSymbol().equals("+B")||
					this.getCellEntities().get(i).getSymbol().equals("*")) {
				return (Potion) this.getCellEntities().get(i);
			}
		}
		return null;
	}

}
