package exception;

import gui.CharacterP1Pane;
import gui.CharacterP2Pane;
import gui.MapSelectPane;
import gui.StartPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class NotSelectedException extends Exception{
	
	public NotSelectedException(CharacterP1Pane CharacterP1Pane) {
		 super("Invalid selected");
		 Label label = new Label("Please select your character");
		 label.setTextFill(Color.RED);
		 label.setFont(StartPane.getBitFont());
		 AnchorPane.setTopAnchor(label, 20d);
		 AnchorPane.setRightAnchor(label,450d);
		 if((CharacterP1Pane.isb1Selected() || CharacterP1Pane.isb2Selected() || CharacterP1Pane.isb3Selected() || CharacterP1Pane.isb4Selected()) && CharacterP1Pane.getTextfield().getText().equals("name")&& !CharacterP1Pane.getTextfield().getText().equals("")) {
			 	if (CharacterP1Pane.getChildren().get(CharacterP1Pane.getChildren().size()-1) instanceof Label) CharacterP1Pane.getChildren().remove(CharacterP1Pane.getChildren().size()-1);
				label.setText("Please enter your name");
				AnchorPane.setTopAnchor(label, 20d);
				AnchorPane.setRightAnchor(label,500d);
				
		}if((CharacterP1Pane.isb1Selected() || CharacterP1Pane.isb2Selected() || CharacterP1Pane.isb3Selected() || CharacterP1Pane.isb4Selected()) && CharacterP1Pane.getTextfield().getText().equals("")) {
				if (CharacterP1Pane.getChildren().get(CharacterP1Pane.getChildren().size()-1) instanceof Label) CharacterP1Pane.getChildren().remove(CharacterP1Pane.getChildren().size()-1);
				label.setText("Please enter your name");
				AnchorPane.setTopAnchor(label, 20d);
				AnchorPane.setRightAnchor(label,500d);
		}
			
		 CharacterP1Pane.getChildren().add(label);
	}
	
	public NotSelectedException(CharacterP2Pane CharacterP2Pane) {
		super("Invalid selected");
		 Label label = new Label("Please select your character");
		 label.setTextFill(Color.RED);
		 label.setFont(StartPane.getBitFont());
		 AnchorPane.setTopAnchor(label, 20d);
		 AnchorPane.setRightAnchor(label,450d);
		 if((CharacterP2Pane.isb1Selected() || CharacterP2Pane.isb2Selected() || CharacterP2Pane.isb3Selected() || CharacterP2Pane.isb4Selected()) && CharacterP2Pane.getTextfield().getText().equals("name")&& !CharacterP2Pane.getTextfield().getText().equals("")) {
			 	if (CharacterP2Pane.getChildren().get(CharacterP2Pane.getChildren().size()-1) instanceof Label) CharacterP2Pane.getChildren().remove(CharacterP2Pane.getChildren().size()-1);
				label.setText("Please enter your name");
				AnchorPane.setTopAnchor(label, 20d);
				AnchorPane.setRightAnchor(label,500d);
		}if((CharacterP2Pane.isb1Selected() || CharacterP2Pane.isb2Selected() || CharacterP2Pane.isb3Selected() || CharacterP2Pane.isb4Selected()) && CharacterP2Pane.getTextfield().getText().equals("")) {
			if (CharacterP2Pane.getChildren().get(CharacterP2Pane.getChildren().size()-1) instanceof Label) CharacterP2Pane.getChildren().remove(CharacterP2Pane.getChildren().size()-1);
			label.setText("Please enter your name");
			AnchorPane.setTopAnchor(label, 20d);
			AnchorPane.setRightAnchor(label,500d);
		}
		 CharacterP2Pane.getChildren().add(label);
	}
	
	public NotSelectedException(MapSelectPane MapSelectPane) {
		super("Invalid selected");
		Label label = new Label("Please select map");
		 label.setTextFill(Color.RED);
		 label.setFont(StartPane.getBitFont());
		 AnchorPane.setTopAnchor(label, 20d);
		 AnchorPane.setRightAnchor(label,520d);
		 if((MapSelectPane.isb1Selected() || MapSelectPane.isb2Selected() || MapSelectPane.isb3Selected() ) ) {
			 if (MapSelectPane.getChildren().get(MapSelectPane.getChildren().size()-1) instanceof Label) MapSelectPane.getChildren().remove(MapSelectPane.getChildren().size()-1);
			 	System.out.println(MapSelectPane.getChildren());
				label.setText("Please enter your name");
				AnchorPane.setTopAnchor(label, 20d);
				AnchorPane.setRightAnchor(label,500d);
				System.out.println(label.isVisible()+label.getText());		
		}
		 MapSelectPane.getChildren().add(label);
	}
	

}
