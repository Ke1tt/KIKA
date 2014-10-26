package ee.ut.math.tvt.salessystem.ui.model;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfirmOrderModel extends JFrame {
	
	
	
	public ConfirmOrderModel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JLabel totalSum = new JLabel();
		JLabel totalSumLabel = new JLabel("Total sum: ");
		JTextField paidMoney = new JTextField();
		JLabel paidMoneyLabel = new JLabel("Paid Money: ");
		JLabel changeAmount = new JLabel();
		JLabel changeAmountLabel = new JLabel("Change: ");
		
		panel.add(paidMoneyLabel);
		panel.add(paidMoney);
		panel.add(totalSumLabel);
		panel.add(totalSum);
		panel.add(changeAmountLabel);
		panel.add(changeAmount);
		
		
		panel.setSize(300, 200);
		setLocationRelativeTo(null);
		setTitle("Order Confirmation. ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		pack();
	}
}
