package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.ui.tabs.PurchaseTab;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ConfirmOrderModel extends JFrame {
	
	private static final Logger log = Logger.getLogger(PurchaseInfoTableModel.class);
	
	public ConfirmOrderModel(double total, PurchaseTab purchase) {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JLabel totalSum = new JLabel(String.valueOf(total));
		JLabel totalSumLabel = new JLabel("Total sum: ");
		JFormattedTextField paidMoney = new JFormattedTextField();
		paidMoney.setValue(new Double(0.0));
		JLabel paidMoneyLabel = new JLabel("Paid Money: ");
		JLabel changeAmount = new JLabel();
		JLabel changeAmountLabel = new JLabel("Change: ");
		JButton calculateChange = new JButton("Calculate change");
		JButton accept = new JButton("Accept");
		JButton cancel = new JButton("Cancel");
		
		calculateChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				double paidMoneyValue=Double.parseDouble(paidMoney.getText());
				if (paidMoneyValue >= total) {
					changeAmount.setText(Double.toString(paidMoneyValue-total));
				} else {
					log.debug("Not enough cash.");
				}
			}
		});
		
		panel.add(totalSumLabel);
		panel.add(totalSum);
		panel.add(paidMoneyLabel);
		panel.add(paidMoney);
		panel.add(changeAmountLabel);
		panel.add(changeAmount);
		panel.add(calculateChange);
		panel.add(accept);
		panel.add(cancel);
		
		
		panel.setSize(400, 300);
		setLocationRelativeTo(null);
		setTitle("Order Confirmation. ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		pack();
			
		accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				purchase.submitPurchaseButtonClicked();
				setVisible(false);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				log.debug("Cancelled paying");
				setVisible(false);
			}
		});
		
		
	}

}
