package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;

public class HistoryTableModel extends SalesSystemTableModel<HistoryItem> {
	private static final Logger log = Logger
			.getLogger(HistoryTableModel.class);
	private static final long serialVersionUID = -2525726730045875622L;
	
	public HistoryTableModel() {
		super(new String[] {"Date of the order", "Time of the order", "Total order price"});
	}

	@Override
	protected Object getColumnValue(HistoryItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getDate();
		case 1:
			return item.getTime();
		case 2:
			return item.getPrice();
		}
		throw new IllegalArgumentException("Column index out of range");
	}
	
	public void addItem(final HistoryItem item){
		rows.add(item);
		fireTableDataChanged();
	}


}
