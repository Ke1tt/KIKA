package ee.ut.math.tvt.salessystem.ui.model;

import java.awt.GridLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddItemsWarehouseModel extends JFrame{

	public AddItemsWarehouseModel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		JLabel idLabel = new JLabel("Add product's bar code: ");
		JFormattedTextField id = new JFormattedTextField();
		id.setValue(new Double(0.0));
		JLabel nameLabel = new JLabel("Add product's name: ");
		JTextField name = new JTextField();
		JLabel priceLabel = new JLabel("Add product's price: ");
		JFormattedTextField price = new JFormattedTextField();
		price.setValue(new Double(0.0));
		JLabel quantityLabel = new JLabel("Add product's quantity: ");
		JFormattedTextField quantity = new JFormattedTextField();
		quantity.setValue(new Integer(0));
		
		panel.add(idLabel);
		panel.add(id);
		panel.add(nameLabel);
		panel.add(name);
		panel.add(priceLabel);
		panel.add(price);
		panel.add(quantityLabel);
		panel.add(quantity);
		
		setLocationRelativeTo(null);
		setTitle("Add items to warehouse. ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		pack();
	}
}
