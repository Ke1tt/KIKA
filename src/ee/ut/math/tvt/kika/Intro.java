package ee.ut.math.tvt.kika;

import javafx.application.Application;
import javafx.stage.Stage;

public class Intro extends Application{
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Intro of our team");
		primaryStage.setScene(IntroUI.graafika());
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
;