package ee.ut.math.tvt.salessystem.ui.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;

public class HistoryTableModel extends SalesSystemTableModel<HistoryItem> {
	private static final Logger log = Logger
			.getLogger(HistoryTableModel.class);
	private static final long serialVersionUID = -2525726730045875622L;
	
	private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	public HistoryTableModel() {
		super(new String[] {"Time of the order", "Total order price"});
	}

	@Override
	protected Object getColumnValue(HistoryItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return dateFormat.format(item.getSoldTime());
		case 1:
			return item.getPrice();
		}
		throw new IllegalArgumentException("Column index out of range");
	}
	
	public void addItem(final HistoryItem item){
		rows.add(item);
		fireTableDataChanged();
	}


}
