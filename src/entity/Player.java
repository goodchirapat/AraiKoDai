package entity;

import entity.base.Entity;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import logic.Cell;
import logic.GameMap;

public abstract class Player extends Entity{
	protected String name;
	protected int hp, power;
	protected int carriedBomb;
	protected boolean immune,movable;
	protected Image imageLeft,imageRight;
	protected AudioClip collectSound =new AudioClip(ClassLoader.getSystemResource("sound/collect.wav").toString());
	protected AudioClip healSound =new AudioClip(ClassLoader.getSystemResource("sound/heal.wav").toString());
	protected AudioClip starSound =new AudioClip(ClassLoader.getSystemResource("sound/star.wav").toString());
	protected AudioClip tikSound =new AudioClip(ClassLoader.getSystemResource("sound/tik.wav").toString());
	

	public Player(String name, int hp, int i, int j) {
		super(i, j);
		this.name = name;
		this.hp = hp;
		this.symbol = "P";
		this.immune = false;
		this.z = 1;
		this.carriedBomb = 1;
		this.power = 1;
		this.movable=true;
		healSound.setVolume(healSound.getVolume()-0.9);
		collectSound.setVolume(0.5);
		starSound.setVolume(0.15);
		tikSound.setVolume(1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public abstract void action(KeyCode keycode);

	public void hpDown() {
		// TODO Auto-generated method stub
		if (!immune) {
			Player x = this;
			x.immune = true;
			x.hp -= 1;
			System.out.println(this.symbol + " is damaged");
			this.immune(3000);
		}

	}

	public void move(int vi, int vj) {
		if(movable) {
			if (GameMap.getCells()[this.getI() + vi][this.getJ() + vj].isPassable()) {
				this.remove();
				this.setI(this.getI() + vi);
				this.setJ(this.getJ() + vj);
				GameMap.add(this, this.getI(), this.getJ());
				this.updateMyCell();
				this.tikSound.play();
				movable=false;
				Thread cd=new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						movable=true;
					}
					
				});
				cd.start();
			}
		}

		
	}

	public void plantBomb() {
		if (!GameMap.getCells()[this.getI()][this.getJ()].hasBomb() && this.carriedBomb > 0) {
			this.carriedBomb -= 1;
			Bomb bomb = new Bomb(this.power, this, this.getI(), this.getJ());
			GameMap.add(bomb, this.getI(), this.getJ());
			System.out.println("add!!");
			bomb.countDown(3000);

		}
	}

	public void check() {
		if (this.myCell.isDamaged()) {
			this.hpDown();
		}
		Potion potion = this.myCell.getPotion();
		if (potion != null) {
			
			switch (potion.getSymbol()) {
			case "+P":
				this.power += 1;
				collectSound.play();
				break;
			case "+HP":
				this.hp += 1;
				healSound.play();
				break;
			case "+B":
				this.carriedBomb += 1;
				collectSound.play();
				break;
			case "*":
				starSound.play();
				if(!this.immune) {
					immune(5000);
				}
				
				break;
			default:
				break;

			}
			potion.remove();
		}

	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isImmune() {
		return immune;
	}

	public void setImmune(boolean immune) {
		this.immune = immune;
	}

	public int getCarriedBomb() {
		return carriedBomb;
	}

	public void setCarriedBomb(int carriedBomb) {
		this.carriedBomb = carriedBomb;
	}

	public void immune(int time) {
		Player x = this;
		Thread immunity = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					x.immune = true;
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				x.immune = false;
			}

		});
		immunity.start();
		System.out.println("blink");
		blink(time);
	}
	public void turnLeft() {
		this.setImage(imageLeft);
	}
	public void turnRight() {
		this.setImage(imageRight);
	}

	public Image getImageLeft() {
		return imageLeft;
	}

	public void setImageLeft(Image imageLeft) {
		this.imageLeft = imageLeft;
	}

	public Image getImageRight() {
		return imageRight;
	}

	public void setImageRight(Image imageRight) {
		this.imageRight = imageRight;
	}
	public void blink(int time) {
		Player x=this;
		Image png=new Image(ClassLoader.getSystemResource("character/png.png").toString());
		Image tmp=this.getImage();
		Thread timer=new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(time);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		Thread blink=new Thread(new Runnable() {
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					while(timer.getState()!=Thread.State.TERMINATED){
						x.setImage(png);
						Thread.sleep(100);
						x.setImage(tmp);
						Thread.sleep(100);
						
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		blink.start();
		timer.start();
	}


}
