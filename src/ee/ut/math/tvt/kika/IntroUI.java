package ee.ut.math.tvt.kika;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class IntroUI extends Application{
	
	 public void start(Stage primaryStage) {
		 	
		 BorderPane bp = new BorderPane();
		 
		 Label intro = new Label("Team name: KIKA" + "\n"
		 		+ "Team leader: Anastassia Ivanova" + "\n"
				 + "Team leader email: Nasty94@hot.ee" + "\n"
		 		+ "Team members: Keit Toom, Ingrid Kaasik, Kelian Kaio, Anastassia Ivanova");
		 
		 Image img = new Image("file:logo.png");
		 Label logo = new Label();
		 logo.setGraphic(new ImageView(img));
		 
		 Label version = new Label("Software version number:");
		 
		 bp.setTop(intro);
		 bp.setCenter(logo);
		 bp.setBottom(version);
		 
		 Scene sc = new Scene(bp,400,200);
		 
		 primaryStage.setTitle("Intro of our team");
		 primaryStage.setScene(sc);
		 primaryStage.show();
	    }
	
}
