package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// create title
			
			primaryStage.setTitle("Word Parser Program!");
			
			//create borderpane for style of application 
			
			BorderPane root = new BorderPane();
			
			//ask user what url they want to analyze
			
			Label urlquestion = new Label("Enter a Url: ");
			TextField urlInput = new TextField();
			Button urlButton = new Button("Enter");
			urlButton.setOnAction(actionEvent ->  {
				
				try {
					root.setCenter(new Text(WordParser.createString(urlInput.getText())));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			});
			HBox url = new HBox(20,urlquestion,urlInput,urlButton);
			url.setAlignment(Pos.CENTER);
			url.setPadding(new Insets(20,20,20,20));
			root.setTop(url);
			
			//create text field that displays either top 10 words, top 20 words, or top 50 words
			
			Text instruct = new Text("Enter a url to see word counts!");
			Text info = new Text("Eric Caudill Module 6 Valencia College");
			
			//set text to middle of borderpane
			
			root.setCenter(instruct);
			root.setBottom(info);
			
			
			
			
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
