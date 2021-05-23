package logic;

import java.util.ArrayList;


import entity.Field;
import entity.Player;
import entity.Player1;
import entity.Player2;
import entity.Wall;
import entity.BreakableWall;
import entity.base.Entity;
import gui.CharacterP1Pane;
import gui.CharacterP2Pane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public class GameMap {
	public static Cell[][] cells;
	public static int theme;
	public static Player player1;
	public static Player player2;
	public static int row;
	public static int column;
	public static void InitializeGameMap(String[][] map) {
		
		column = map[0].length;
		row = map.length;
		
		cells = new Cell[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				cells[i][j] = new Cell(i,j);
				add(new Field(i,j),i,j);
				switch(map[i][j]) {
				case "0":
					break;
				case "P1":
					player1=new Player1(CharacterP1Pane.getName(),3,i,j,CharacterP1Pane.getPicsymbol());
					add(player1,i,j);
					player1.updateMyCell();
					break;
				case "P2":
					player2=new Player2(CharacterP2Pane.getName(),3,i,j,CharacterP2Pane.getPicsymbol());
					add(player2,i,j);
					break;
				case "W":
					Wall wall=new Wall(i,j);
					add(wall,i,j);
					break;
				case "BW":
					BreakableWall breakableWall=new BreakableWall(i,j);
					add(breakableWall,i,j);
					break;
				default:
					break;
				
				}
				
				
			}
		}
	}
	public static void add(Entity entity,int i,int j) {
		cells[i][j].add(entity);
		entity.setI(i);
		entity.setJ(j);
	}
	public static Cell[][] getCells() {
		return cells;
	}
	public static void remove(Entity entity) {
		entity.remove();
	}
	public static void update(KeyCode keycode) {
		player1.action(keycode);
		player2.action(keycode);
		player1.check();
		player2.check();
	}
	public static boolean isEnd() {
		if(player1.getHp()==0 || player2.getHp()==0) {
			return true;
		}
		return false;
	}
	public static boolean player1Win() {
		if(player2.getHp()==0) {
			return true;
		}
		return false;
	}
	public static boolean player2Win() {
		if(player1.getHp()==0) {
			return true;
		}
		return false;
	}
}
