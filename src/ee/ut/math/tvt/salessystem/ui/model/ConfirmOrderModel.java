package ee.ut.math.tvt.salessystem.ui.model;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ConfirmOrderModel extends JFrame {
	
	
	
	public ConfirmOrderModel(double total) {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JLabel totalSum = new JLabel(String.valueOf(total));
		JLabel totalSumLabel = new JLabel("Total sum: ");
		JFormattedTextField paidMoney = new JFormattedTextField();
		JLabel paidMoneyLabel = new JLabel("Paid Money: ");
		//pmst sellega vist peab tegema
		//paidMoney.addPropertyChangeListener());
		double paidMoneyValue = Double.parseDouble(paidMoney.getText());
		JLabel changeAmount = new JLabel(String.valueOf(total - paidMoneyValue));
		JLabel changeAmountLabel = new JLabel("Change: ");
		
		
		
		
		panel.add(totalSumLabel);
		panel.add(totalSum);
		panel.add(paidMoneyLabel);
		panel.add(paidMoney);
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
