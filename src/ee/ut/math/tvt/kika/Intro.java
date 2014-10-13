package ee.ut.math.tvt.kika;

import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.stage.Stage;

public class Intro extends Application{
	private static final Logger log = Logger.getLogger(Intro.class);
	
	public void start(Stage primaryStage) {
		log.info("Intro started");
		primaryStage.setTitle("Intro of our team");
		primaryStage.setScene(IntroUI.graafika());
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
;