package ee.ut.math.tvt.kika;

import java.io.FileInputStream;
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
			
			istream.close();
			return result;
		}
		
		public String getAppProps() throws IOException {
			String result = "";
			Properties prop = new Properties();
			String propFileName = "application.properties";
			
			InputStream istream = new FileInputStream(propFileName);
			prop.load(istream);
			
			String tname = prop.getProperty("team.name");
			String tleader = prop.getProperty("team.leader");
			String tleaderemail = prop.getProperty("team.leader.email");
			String tmembers= prop.getProperty("team.members");
			
			result = "Team name: " + tname + "\n" + "Team leader: " + tleader + "\n" +
			"Team leader email: " + tleaderemail + "\n" + "Team members: " + tmembers;
			istream.close();
			return result;
		}
		
		static Scene graafika() throws IOException{

		 BorderPane bp = new BorderPane();
		 
		 IntroUI appprops = new IntroUI();
		 Label intro = new Label(appprops.getAppProps());
		 
		 Image img = new Image("file:logo.png");
		 Label logo = new Label();
		 logo.setGraphic(new ImageView(img));
		 
		 IntroUI verprops = new IntroUI();
		 Label version = new Label("Software version number: " + verprops.getVersionProps());
		 
		 bp.setTop(intro);
		 bp.setCenter(logo);
		 bp.setBottom(version);
		 
		 Scene sc = new Scene(bp,400,200);
		 
		 return sc;
		}
	
}
