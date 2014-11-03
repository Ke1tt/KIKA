package ee.ut.math.tvt.salessystem.ui.model;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
//import ee.ut.math.tvt.salessystem.ui.SalesSystemUI;

/**
 * Purchase history details model.
 */
public class PurchaseInfoTableModel extends SalesSystemTableModel<SoldItem> {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(PurchaseInfoTableModel.class);
		
	public PurchaseInfoTableModel() {
		super(new String[] { "Id", "Name", "Price", "Quantity", "Sum"});
	}

	@Override
	protected Object getColumnValue(SoldItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getName();
		case 2:
			return item.getPrice();
		case 3:
			return item.getQuantity();
		case 4:
			return item.getSum();
		}
		throw new IllegalArgumentException("Column index out of range");
		
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < headers.length; i++)
			buffer.append(headers[i] + "\t");
		buffer.append("\n");

		for (final SoldItem item : rows) {
			buffer.append(item.getId() + "\t");
			buffer.append(item.getName() + "\t");
			buffer.append(item.getPrice() + "\t");
			buffer.append(item.getQuantity() + "\t");
			buffer.append(item.getSum() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}
	
    /**
     * Add new StockItem to table.
     */
	
    public void addItem(final SoldItem item) {
        /**
         * XXX In case such stockItem already exists increase the quantity of the
         * existing stock.
         */
        
    	SoldItem existingItem = itemInShoppingCart(item.getStockItem().getId());
    	
    	if(existingItem != null){
    		if (checkQuantity(item.getStockItem(), existingItem.getQuantity() + item.getQuantity())){
    			existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        		log.debug("Increased " + item.getName() + " quantity by " + item.getQuantity());
    		}
    	}
    	else {
    		if(checkQuantity(item.getStockItem(), item.getQuantity())){
    			rows.add(item);
    			log.debug("Added " + item.getName() + " quantity of " + item.getQuantity());
    		}
    	}
        fireTableDataChanged();
    }
    
	//looks if there is a same item already in Shopping Cart
	public SoldItem itemInShoppingCart (long StockItemId){
		for (SoldItem item : getTableRows()){
			if (item.getStockItem().getId().equals(StockItemId)){
				return item;
			}
		}
		return null;
	}
	
	//checks the warehouse
	public boolean checkQuantity(StockItem item, int quantity){
		if(item.getQuantity() < quantity){
			log.debug("There aren't that many " + item.getName() + "'s in warehouse. ");
			return false;
		}
		return true;
		
	}
	
	public double totalSum(){
		double total = 0;
		for (SoldItem item: getTableRows()){
			total += item.getSum();
		}
		return total;
	}
	
	public ArrayList<SoldItem> soldItems(){
		ArrayList solditems = new ArrayList<SoldItem>();
		for(SoldItem item: getTableRows()){
			solditems.add(item);
		}
		return solditems;
	}
}
