package ee.ut.math.tvt.kika;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class IntroUI{
	
		public String getVersionProps() throws IOException {
			String result = "";
			Properties prop = new Properties();
			String propFileName= "version.properties";
			
			InputStream istream = new FileInputStream(propFileName);
			prop.load(istream);
		
			String brn = prop.getProperty("build.revision.number");
			String bmjn = prop.getProperty("build.minor.number");
			String bman = prop.getProperty("build.major.number");
			
			result = brn + "." + bmjn + "." + bman;
			
			return result;
		}
		
		static Scene graafika() throws IOException{

		 BorderPane bp = new BorderPane();
		 
		 Label intro = new Label("Team name: KIKA" + "\n"
		 		+ "Team leader: Anastassia Ivanova" + "\n"
				 + "Team leader email: Nasty94@hot.ee" + "\n"
		 		+ "Team members: Keit Toom, Ingrid Kaasik, Kelian Kaio, Anastassia Ivanova");
		 
		 Image img = new Image("file:logo.png");
		 Label logo = new Label();
		 logo.setGraphic(new ImageView(img));
		 
		 IntroUI verprops = new IntroUI();
		 Label version = new Label("Software version number:" + verprops.getVersionProps());
		 
		 bp.setTop(intro);
		 bp.setCenter(logo);
		 bp.setBottom(version);
		 
		 Scene sc = new Scene(bp,400,200);
		 
		 return sc;
		}
	
}
