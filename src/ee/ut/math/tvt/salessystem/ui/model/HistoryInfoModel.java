package ee.ut.math.tvt.salessystem.ui.model;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class HistoryInfoModel extends JFrame{

	private SalesSystemModel model;
	
	public HistoryInfoModel(){
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JTable table = new JTable();
		
		setLocationRelativeTo(null);
		setTitle("Purchase Information");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
	}
}
