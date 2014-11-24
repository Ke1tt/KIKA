package ee.ut.math.tvt.kika;

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IntroUI extends JFrame {
	private static final Logger log = Logger.getLogger(Intro.class);


	public String getVersionProps() {
		String result = "";
		Properties prop = new Properties();
		String propFileName = "version.properties";

		try {
			InputStream istream = new FileInputStream(propFileName);
			prop.load(istream);

			String brn = prop.getProperty("build.revision.number");
			String bmjn = prop.getProperty("build.minor.number");
			String bman = prop.getProperty("build.major.number");

			result = brn + "." + bmjn + "." + bman;

			istream.close();
		} catch (IOException e) {
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
			String tmembers = prop.getProperty("team.members");

			result = "Team name: " + tname + "\n" + "Team leader: " + tleader
					+ "\n" + "Team leader email: " + tleaderemail + "\n"
					+ "Team members: " + tmembers;
			istream.close();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return result;
	}

	public IntroUI() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLabel intro = new JLabel(getAppProps());
		
		ImageIcon img = new ImageIcon("logo.png");
		JLabel logo = new JLabel(img);
		
		JLabel version = new JLabel(getVersionProps());
		
		panel.add(intro, BorderLayout.CENTER);
		panel.add(logo, BorderLayout.PAGE_START);
		panel.add(version, BorderLayout.PAGE_END);
		panel.setSize(panel.getPreferredSize());
		add(panel);
		pack();
		log.info("IntroUI started");
	}

}
