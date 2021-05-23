package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameMap;

public class StatusPane extends Canvas{
	
	private GraphicsContext gc=this.getGraphicsContext2D();
	Font bitFont = StartPane.getBitFont();
	Font bitFont40 = StartPane.getBitFont40();
	Font font= bitFont;
	private long lastTimeTrigger=-1;
	private int currentTime=0;
	
	public StatusPane() {
		super(300, 900);
		this.setVisible(true);
	}
	
	public void draw(long now) {
		gc.setFont(font);
		gc.setFill(Color.SKYBLUE);
		gc.fillRect(0,0,300,200);
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillRect(0,200,300,200);
		gc.setFill(Color.TOMATO);
		gc.fillRect(0,500,300,200);
		gc.setFill(Color.ANTIQUEWHITE);
		gc.fillRect(0,700,300,200);
		gc.setFill(Color.BLACK);
		gc.fillText(GameMap.player1.getName(),30,110,240);
		gc.fillText("HP : "+GameMap.player1.getHp(),25,250);
		gc.fillText("POWER : "+GameMap.player1.getPower(),25,310);
		gc.fillText("CarriedBomb : "+GameMap.player1.getCarriedBomb(),25,370);
		gc.fillText(GameMap.player2.getName(),30,610,240);
		gc.fillText("HP : "+GameMap.player2.getHp(),25,750);
		gc.fillText("POWER : "+GameMap.player2.getPower(),25,810);
		gc.fillText("CarriedBomb : "+GameMap.player2.getCarriedBomb(),25,870);
		lastTimeTrigger=(lastTimeTrigger < 0 ? now :lastTimeTrigger);
		gc.clearRect(0, 400, 300,100);
		gc.fillText(timeStamp(now), 110, 455);
		
	}
	public String timeStamp(long now) {
		String hour,min;
		lastTimeTrigger=(lastTimeTrigger < 0 ? now :lastTimeTrigger);
		if(now-lastTimeTrigger>=1000000000) {
			currentTime++;
			//System.out.println("print time");
			lastTimeTrigger=now;
		}
		hour= currentTime/60 <10 ? "0"+String.valueOf(currentTime/60) : String.valueOf(currentTime/60);
		min=currentTime%60 <10 ? "0"+String.valueOf(currentTime%60) : String.valueOf(currentTime%60);
		return hour+" : "+min;
	}
}
