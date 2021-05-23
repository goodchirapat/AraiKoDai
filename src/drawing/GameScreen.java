package drawing;


import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import logic.GameMap;

public class GameScreen extends Canvas{
	
	private KeyCode keyCode;
	
	private String[][] map3= 
		{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
		, {"W", "0", "P1", "W", "0", "0", "W", "0", "W", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "W"}
		, {"W", "0", "W", "W", "BW", "W", "W", "BW", "W", "BW", "W", "W", "W", "W", "W", "W", "W", "W", "BW", "W"}
		, {"W", "BW", "0", "0", "0", "0", "0", "0", "0", "BW", "BW", "0", "0", "0", "0", "0", "0", "0", "0", "W"}
		, {"W", "0", "W", "W", "0", "0", "W", "W", "W", "BW", "W", "0", "W", "W", "W", "W", "W", "BW", "BW", "W"}
		, {"W", "0", "W", "BW", "W", "W", "W", "BW", "BW", "0", "BW", "0", "0", "BW", "0", "0", "0", "0", "BW", "W"}
		, {"W", "0", "W", "0", "0", "0", "W", "0", "W", "0", "W", "W", "W", "W", "W", "W", "W", "W", "0", "W"}
		, {"W", "BW", "BW", "0", "W", "0", "0", "0", "W", "BW", "0", "0", "0", "0", "0", "0", "0", "BW", "BW", "W"}
		, {"W", "0", "W", "W", "0", "0", "W", "W", "W", "0", "W", "W", "W", "BW", "W", "W", "W", "W", "BW", "W"}
		, {"W", "0", "0", "W", "0", "0", "0", "BW", "0", "BW", "0", "0", "0", "0", "0", "0", "BW", "0", "0", "W"}
		, {"W", "W", "BW", "W", "BW", "W", "W", "W", "0", "W", "W", "W", "W", "BW", "W", "W", "BW", "0", "0", "W"}
		, {"W", "0", "0", "W", "0", "0", "0", "W", "0", "W", "0", "0", "0", "0", "W", "0", "W", "W", "BW", "W"}
		, {"W", "W", "BW", "W", "BW", "BW","BW", "W", "BW", "W", "W", "BW", "W", "BW", "W", "0", "W", "P2", "0", "W"}
		, {"W", "0", "0", "0", "0", "0", "0", "W", "0", "0", "0", "0", "0", "0", "0", "0", "BW", "0", "0", "W"}
		, {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
		};
	
	private String[][] map2= 
		{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
		, {"W", "BW", "BW", "0", "BW", "BW", "W", "W", "W", "W", "W", "BW", "W", "W", "BW", "0", "BW", "0", "BW", "W"}
		, {"W", "BW", "W", "W", "BW", "W", "BW", "0", "0", "BW", "0", "W", "BW", "W", "W", "BW", "0", "BW", "W", "W"}
		, {"W", "BW", "W", "W", "0", "0", "BW", "W", "0", "W", "W", "BW", "0", "0", "W", "BW", "W", "0", "BW", "W"}
		, {"W", "0", "BW", "0", "P1", "W", "W", "BW", "BW", "0", "W", "0", "0", "0", "0", "BW", "W", "W", "BW", "W"}
		, {"W", "W", "BW", "W", "0", "BW", "BW", "BW", "W", "BW", "BW", "0", "W", "BW", "W", "W", "BW", "0", "BW", "W"}
		, {"W", "W", "0", "0", "W", "BW", "BW", "BW", "0", "0", "W", "BW", "BW", "0", "W", "BW", "0", "0", "W", "W"}
		, {"W", "W", "0", "W", "W", "BW", "0", "W", "W", "W", "0", "W", "BW", "BW", "W", "W", "0", "0", "BW", "W"}
		, {"W", "0", "0", "W", "W", "BW", "BW", "0", "0", "BW", "W", "0", "0", "0", "W", "BW", "W", "0", "0", "W"}
		, {"W", "0", "W", "BW", "W", "0", "0", "0", "W", "BW", "0", "BW", "0", "BW", "BW", "W", "W", "BW", "0", "W"}
		, {"W", "W", "0", "0", "0", "BW", "W", "W", "W", "BW", "BW", "W", "0", "BW", "0", "W", "BW", "W", "W", "W"}
		, {"W", "W", "BW", "0", "0", "BW", "0", "W", "W", "0", "0", "BW", "BW", "0", "W", "W", "BW", "W", "0", "W"}
		, {"W", "BW", "BW", "0", "0", "W", "0", "0", "BW", "W", "W", "0", "0", "0", "W", "BW", "W", "BW", "W", "W"}
		, {"W", "W", "W", "W", "BW", "0", "0", "BW", "W", "0", "BW", "0", "W", "BW", "0", "0", "0", "P2", "W", "W"}
		, {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
		};
	
	private String[][] map1 =
		{{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
		, {"W", "P1", "BW", "0", "BW", "BW", "0", "0", "0", "BW", "W", "BW", "0", "W", "BW", "0", "BW", "0", "BW", "W"}
		, {"W", "0", "W", "W", "BW", "BW", "BW", "0", "0", "BW", "0", "W", "BW", "W", "W", "BW", "0", "BW", "W", "W"}
		, {"W", "0", "W", "BW", "0", "0", "0", "W", "0", "W", "W", "BW", "0", "0", "W", "BW", "W", "0", "BW", "W"}
		, {"W", "0", "BW", "0", "0", "W", "BW", "BW", "0", "0", "W", "0", "0", "0", "0", "BW", "W", "W", "BW", "W"}
		, {"W", "W", "BW", "W", "0", "BW", "BW", "0", "W", "BW", "BW", "0", "0", "BW", "W", "0", "BW", "0", "BW", "W"}
		, {"W", "W", "0", "0", "W", "0", "BW", "BW", "0", "0", "W", "BW", "BW", "0", "W", "BW", "0", "0", "W", "W"}
		, {"W", "W", "0", "W", "W", "BW", "0", "W", "BW", "W", "0", "W", "BW", "BW", "W", "W", "0", "0", "BW", "W"}
		, {"W", "0", "0", "W", "W", "0", "BW", "0", "0", "BW", "W", "0", "0", "0", "W", "BW", "W", "0", "0", "W"}
		, {"W", "0", "W", "0", "W", "0", "0", "0", "W", "BW", "0", "0", "0", "0", "BW", "W", "W", "BW", "0", "W"}
		, {"W", "W", "0", "0", "0", "BW", "0", "0", "W", "BW", "BW", "W", "0", "0", "0", "W", "BW", "0", "W", "W"}
		, {"W", "W", "BW", "0", "0", "BW", "0", "W", "W", "0", "0", "BW", "BW", "0", "W", "W", "BW", "0", "0", "W"}
		, {"W", "BW", "BW", "0", "0", "W", "0", "0", "BW", "W", "W", "0", "0", "W", "0", "BW", "0", "BW", "W", "W"}
		, {"W", "BW", "BW", "W", "BW", "0", "0", "BW", "W", "0", "BW", "0", "W", "W", "0", "0", "0", "P2", "W", "W"}
		, {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"}
		};
	private String[][][] map= {map1,map2,map3};
	
	public GameScreen(double width, double height, int theme) {
		super(width, height);
		this.setVisible(true);
		addListener();
		GameMap.InitializeGameMap(map[theme-1]);
	}
	public void update() {
		GameMap.update(keyCode);
		this.draw();
	}
	public void addListener() {
		this.setOnKeyPressed((KeyEvent event) -> {
			this.keyCode=event.getCode();
			System.out.println(this.keyCode);
			this.update();
			this.keyCode=null;
		});
	}
	public void draw() {
		this.getGraphicsContext2D().clearRect(0, 0,this.getWidth(),this.getHeight());
		for(int i=0;i<GameMap.row;i++) {
			for(int j=0;j<GameMap.column;j++) {
				for(int k=0;k<GameMap.getCells()[i][j].getSize();k++) {
					this.getGraphicsContext2D().drawImage(GameMap.getCells()[i][j].getCellEntities().get(k).getImage(), (this.getWidth()/GameMap.column)*j, (this.getHeight()/GameMap.row)*i);
				}
			}
		}
	}
}
