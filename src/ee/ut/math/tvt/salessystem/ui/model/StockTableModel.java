package ee.ut.math.tvt.salessystem.ui.model;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;
	
/**
 * Stock item table model.
 */
public class StockTableModel extends SalesSystemTableModel<StockItem>{
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(StockTableModel.class);
	
	private Session session = HibernateUtil.currentSession();

	public StockTableModel() {
		super(new String[] {"Id", "Name", "Price", "Quantity"});
		
	}

	@Override
	protected Object getColumnValue(StockItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getName();
		case 2:
			return item.getPrice();
		case 3:
			return item.getQuantity();
		}
		throw new IllegalArgumentException("Column index out of range");
	}

	/**
	 * Add new stock item to table. If there already is a stock item with
	 * same id, then existing item's quantity will be increased.
	 * @param stockItem
	 */
	
	public void addItem(StockItem stockItem) {
		try {
			StockItem item = getItemById(stockItem.getId());
			item.setQuantity(item.getQuantity() + stockItem.getQuantity());
			log.debug("Found existing item " + stockItem.getName()
					+ " increased quantity by " + stockItem.getQuantity());
			
			//Increases item's quantity in database
			Transaction ta = session.beginTransaction();
			StockItem stock = (StockItem)session.get(StockItem.class,item.getId());
			stock.setQuantity(item.getQuantity());
			ta.commit();
		}
		catch (NoSuchElementException e) {
			rows.add(stockItem);
			log.debug("Added " + stockItem.getName()
					+ " quantity of " + stockItem.getQuantity());
			
			//adds item to warehouse
			Transaction ta = session.beginTransaction();
			session.save(stockItem);
			ta.commit();
		}
		fireTableDataChanged();
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < headers.length; i++)
			buffer.append(headers[i] + "\t");
		buffer.append("\n");

		for (final StockItem stockItem : rows) {
			buffer.append(stockItem.getId() + "\t");
			buffer.append(stockItem.getName() + "\t");
			buffer.append(stockItem.getPrice() + "\t");
			buffer.append(stockItem.getQuantity() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}


}
