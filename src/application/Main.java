package application;


import gui.EndGamePane;
import gui.HowToPlayPane;
import gui.MapSelectPane;
import gui.StartPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.GameMap;


public class Main extends Application {
	
	public static Stage window;
	public static Scene scene;
	public static StartPane startPane ;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Main.setStage(stage);
		HBox root = new HBox();
	    scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("AraiKoDai");
		stage.setResizable(false);
		startPane = new StartPane(true);
		root.getChildren().add(startPane);
		window.show();
	}
	
	public static void setWindow(Scene scene) {
		window.setScene(scene);
	}
	
	public static void setStage(Stage stage) {
		window = stage;
	}
	
	
	
	
	
	
}