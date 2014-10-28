package ee.ut.math.tvt.salessystem.ui.model;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.controller.impl.*;
import ee.ut.math.tvt.salessystem.ui.tabs.*;
import ee.ut.math.tvt.salessystem.ui.model.*;

public class AddItemsWarehouseModel extends JFrame{
	 private JButton cancelItem;
	 private JButton confirmItem;
	 private SalesSystemModel model;
	 
	 
	 protected void cancelButtonClicked(){
	    	setVisible(false);
	  	  
	    }
	 protected StockItem confirmButtonClicked(JFormattedTextField id,  JTextField name,
			 JFormattedTextField price, JFormattedTextField quantity){
		 Long StockId = (Long.valueOf(Integer.parseInt(id.getText())));
		 String StockName = (name.getText().toString());
		 Double StockPrice = (Double.valueOf(price.getText()));
		 Integer StockQuantity = (Integer.parseInt(quantity.getText()));
		 StockItem item = new StockItem(StockId, StockName, StockPrice, StockQuantity);
		 
		 return item;
	 }

	public AddItemsWarehouseModel(StockTableModel stock){
		
	    
	   
	    
		final JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(0,2));
		
		cancelItem = new JButton("Cancel");
	    cancelItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				cancelButtonClicked();
				
			}
	    	

			
	    });
	    
	   
		
		JLabel idLabel = new JLabel("Add product's bar code: ");
		final JFormattedTextField id = new JFormattedTextField();
		id.setValue(new Double(0.0));
		JLabel nameLabel = new JLabel("Add product's name: ");
		final JTextField name = new JTextField();
		JLabel priceLabel = new JLabel("Add product's price: ");
		final JFormattedTextField price = new JFormattedTextField();
		price.setValue(new Double(0.0));
		final JLabel quantityLabel = new JLabel("Add product's quantity: ");
		final JFormattedTextField quantity = new JFormattedTextField();
		quantity.setValue(new Integer(0));
		
		 confirmItem = new JButton("Confirm");
		    confirmItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					StockItem item = confirmButtonClicked(id, name, price, quantity);
					stock.addItem(item);
					setVisible(false);
					
				}
		    	
		    });
		
		panel.add(idLabel);
		panel.add(id);
		panel.add(nameLabel);
		panel.add(name);
		panel.add(priceLabel);
		panel.add(price);
		panel.add(quantityLabel);
		panel.add(quantity);
		panel.add(cancelItem);
		panel.add(confirmItem);
		
		setLocationRelativeTo(null);
		setTitle("Add items to warehouse. ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		pack();
	}
}
