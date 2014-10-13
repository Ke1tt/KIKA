package ee.ut.math.tvt.kika;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class IntroUI{
	private static final Logger log = Logger.getLogger(Intro.class);
	
	public IntroUI(){
		log.info("IntroUI started");
	}
		public String getVersionProps() {
			String result = "";
			Properties prop = new Properties();
			String propFileName= "version.properties";
			
			try { 
				InputStream istream = new FileInputStream(propFileName);
				prop.load(istream);
			
				String brn = prop.getProperty("build.revision.number");
				String bmjn = prop.getProperty("build.minor.number");
				String bman = prop.getProperty("build.major.number");
				
				result = brn + "." + bmjn + "." + bman;
				
				istream.close();
			} catch (IOException e){
				log.error(e.getMessage());
			}
			return result;
		}
		
		public String getAppProps() {
			String result = "";
			Properties prop = new Properties();
			String propFileName = "application.properties";
			
			try {
			InputStream istream = new FileInputStream(propFileName);
			prop.load(istream);
			
			String tname = prop.getProperty("team.name");
			String tleader = prop.getProperty("team.leader");
			String tleaderemail = prop.getProperty("team.leader.email");
			String tmembers= prop.getProperty("team.members");
			
			result = "Team name: " + tname + "\n" + "Team leader: " + tleader + "\n" +
			"Team leader email: " + tleaderemail + "\n" + "Team members: " + tmembers;
			istream.close();
			} catch (IOException e){
				log.error(e.getMessage());
			}
			return result;
		}
		
		static Scene graafika() {

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
