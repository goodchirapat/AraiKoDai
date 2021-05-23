package entity;

import entity.base.Entity;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import logic.Cell;
import logic.GameMap;

public class Bomb extends Entity{
	private int power;
	private Player owner;
	private AudioClip boomSound =new AudioClip(ClassLoader.getSystemResource("sound/boom.wav").toString());
	public Bomb(int power,Player owner,int i,int j) {
		super(i,j);
		this.power=power;
		this.symbol="B";
		this.owner=owner;
		this.setImageSource("bomb/bomb1.png");
		this.z=0;
	}
	public void countDown(int time) {
		Bomb x=this;
		Thread t=new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(time);
					x.remove();
					explode();
					System.out.println("boom");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
	}
	public void explode() {
		boomSound.play();
		this.myCell.damaged(this.owner.getSymbol());
		dealDamageToDirection("LEFT");
		dealDamageToDirection("UP");
		dealDamageToDirection("RIGHT");
		dealDamageToDirection("DOWN");
		
		
		this.owner.carriedBomb+=1;
	}
	public void dealDamageToDirection(String direction) {
		int iRange=0,jRange=0;
		switch(direction) {
		case "LEFT":
			jRange=-1;
			break;
		case "UP":
			iRange=-1;
			break;
		case "RIGHT":
			jRange=1;
			break;
		case "DOWN":
			iRange=1;
			break;
		default:
			break;
		}
		
		for(int i=1;i<=this.power;i++) {
			boolean inBoundI = (this.getI()+iRange*i >= 0) && (this.getI()+iRange*i < GameMap.row);
			boolean inBoundJ = (this.getJ()+jRange*i >= 0) && (this.getJ()+jRange*i < GameMap.column);
			if(inBoundI && inBoundJ) {
				Cell cell=GameMap.getCells()[this.getI()+iRange*i][this.getJ()+jRange*i];
				boolean facingWall=false;
				if(!cell.isPassable()) {
					facingWall=true;
				}
				cell.damaged(this.owner.getSymbol());
				if(facingWall) {
					break;
				}
			}
			
		}
	}
}
