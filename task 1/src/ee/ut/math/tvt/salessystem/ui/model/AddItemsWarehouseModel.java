package ee.ut.math.tvt.salessystem.ui.model;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

public class AddItemsWarehouseModel extends JFrame {
	private static final Logger log = Logger
			.getLogger(AddItemsWarehouseModel.class);
	private static final long serialVersionUID = 3674437109116865831L;
	
	private Session session = HibernateUtil.currentSession();
	
	private JButton cancelItem;
	private JButton confirmItem;

	protected void cancelButtonClicked() {
		setVisible(false);

	}

	protected StockItem confirmButtonClicked(JFormattedTextField id,
			JTextField name, JFormattedTextField price,
			JFormattedTextField quantity) {
		Long StockId = (Long.valueOf(Integer.parseInt(id.getText())));
		String StockName = (name.getText().toString());
		Double StockPrice = (Double.valueOf(price.getText()));
		Integer StockQuantity = (Integer.parseInt(quantity.getText()));
		StockItem item = new StockItem(StockId, StockName, StockPrice,
				StockQuantity);

		return item;
	}

	public AddItemsWarehouseModel(StockTableModel stock) {

		final JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(0, 2));

		cancelItem = new JButton("Cancel");
		cancelItem.addActionListener(new ActionListener() {

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
		confirmItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				StockItem stockItem = confirmButtonClicked(id, name, price, quantity);
				try {
					StockItem item = stock.addItem(stockItem);
					
					if (item.getName() != "poleolemas") {
						//Increases item's quantity in database
						Transaction ta = session.beginTransaction();
						StockItem stock = (StockItem)session.get(StockItem.class,item.getId());
						stock.setQuantity(item.getQuantity());
						ta.commit();
					}
					else {
						Transaction ta = session.beginTransaction();
						session.save(stockItem);
						ta.commit();
					}
					log.info("Item(s) added. ");
					
					setVisible(false);
				} catch (VerificationFailedException e) {
					JOptionPane.showMessageDialog(null,e);
				}

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
