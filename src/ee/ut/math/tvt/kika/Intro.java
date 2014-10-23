package ee.ut.math.tvt.kika;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.stage.Stage;

public class Intro extends Application {
	private static final Logger log = Logger.getLogger(Intro.class);


	public static void main(String[] args) {
		IntroUI intro = new IntroUI();
		log.info("IntroUI created");
		intro.setVisible(true);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
};
