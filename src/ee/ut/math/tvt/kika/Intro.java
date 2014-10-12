package ee.ut.math.tvt.kika;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Intro extends Application{
	
	public void start(Stage primaryStage) throws IOException{
		primaryStage.setTitle("Intro of our team");
		primaryStage.setScene(IntroUI.graafika());
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
;